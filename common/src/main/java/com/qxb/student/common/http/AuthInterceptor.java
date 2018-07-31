package com.qxb.student.common.http;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.Encrypt;
import com.qxb.student.common.utils.JsonUtils;
import com.qxb.student.common.utils.Logger;
import com.qxb.student.common.utils.UserCache;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

import okhttp3.Cache;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

/**
 * http请求拦截器
 * 拦截处理认证头，验证签名等
 *
 * @author winky
 */
public class AuthInterceptor implements Interceptor {

    private final String POST = "POST";
    private final static String AUTHORIZATION = "Authorization";
    private final static String APP_SRC = "Appsrc";
    private final static Logger logger = Logger.getInstance();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (Logger.isDebug) {
            logger.d("HttpRequest:" + request.url().toString());
        }
        if (request.method().equals(POST)) {
            if (Config.CUSTOM.equals(request.header(Config.AUTH))) {
                User user = UserCache.getInstance().getUser();
                if (user != null) {
                    builder.addHeader(AUTHORIZATION, custom(user));
                    handle(builder, request.body(), user);
                }
            } else if (Config.COMMON.equals(request.header(Config.AUTH))) {
                builder.addHeader(AUTHORIZATION, Config.AUTH_COMMON_SECRET);
                if (Logger.isDebug) {
                    Buffer buffer = new Buffer();
                    Objects.requireNonNull(request.body()).writeTo(buffer);
                    byte[] buff = new byte[(int) buffer.size()];
                    buffer.inputStream().read(buff);
                    String params = new String(buff, "UTF-8");
                    logger.d("params:" + params);
                }
            }
            //删除自定义的认证头标记
            builder.removeHeader(Config.AUTH);
            builder.addHeader(APP_SRC, getAppSrc());
        }

        Response response = chain.proceed(builder.build());


        ResponseBody responseBody = response.body();
        long maxAge = 0;
        if ((responseBody != null ? responseBody.contentLength() : 0) > 0) {
            BufferedSource source = responseBody.source();
            source.request(responseBody.contentLength());
            Buffer buffer = source.buffer();
            String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));
            if (Logger.isDebug) {
                logger.d("HttpResponse:" + responseBodyString);
            }
            maxAge = JsonUtils.getInstance().toBean(responseBodyString, ApiModel.class).getCacheTime() / 1000;
        }

        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, max-age=" + (maxAge > 600 ? maxAge : 600))
                .build();
    }

    private void handle(Request.Builder builder, RequestBody body, User user) {
        try {
            //user.getTelphone();
            String loginName = "13343426551";
            String timeTemp = String.valueOf(System.currentTimeMillis());
            /*密钥*/
            String secretKey = Encrypt.getReverseString(timeTemp + loginName);
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            byte[] buff = new byte[(int) buffer.size()];
            buffer.inputStream().read(buff);
            String params = new String(buff, "UTF-8");
            /*待签名*/
            String signTemp = params + "&secretKey=" + secretKey;
            String md51 = Encrypt.md5(signTemp).toUpperCase();
            String sign = Encrypt.md5(Encrypt.getReverseString(md51)).toUpperCase();
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            for (String pair : signTemp.split("&")) {
                String[] kv = pair.split("=");
                bodyBuilder.add(kv[0], kv[1]);
            }
            bodyBuilder.add("timestamp", timeTemp);
            bodyBuilder.add("sign", sign);
            if (Logger.isDebug) {
                logger.d("------------------------------------------------------");
                logger.d("loginName:" + loginName);
                logger.d("timeTemp:" + timeTemp);
                logger.d("params:" + params);
                logger.d("------------------------------------------------------");
            }
            builder.post(bodyBuilder.build());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String custom(User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(user.getTelphone());
        buffer.append(":");
        buffer.append(user.getPassword());
        buffer.append(":student");
        return Encrypt.base64("13343426551:123456:student");
//        return Encrypt.base64(buffer.toString());
    }

    private String getAppSrc() {
//        PackageInfo packageInfo = SysUtils.getInstance().getPackageInfo();
        return "{\"os_type\":1,\"app_type\":1,\"ver_v\":\"76\",\"ver_s\":\"5.0\",\"chan\":\"3\"}";
    }
}

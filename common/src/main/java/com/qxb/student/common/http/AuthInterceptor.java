package com.qxb.student.common.http;

import android.support.annotation.NonNull;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.Encrypt;
import com.qxb.student.common.utils.Logger;
import com.qxb.student.common.utils.UserCache;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;

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

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (request.method().equals(POST)) {
            if (Config.CUSTOM.equals(request.header(Config.AUTH))) {
                User user = UserCache.getInstance().getUser();
                if (user != null) {
                    builder.addHeader(AUTHORIZATION, custom(user));
                    handle(builder, request.body(), user);
                }
            } else if (Config.COMMON.equals(request.header(Config.AUTH))) {
                builder.addHeader(AUTHORIZATION, Config.AUTH_COMMON_SECRET);
            }
            //删除自定义的认证头标记
            builder.removeHeader(Config.AUTH);
            builder.addHeader(APP_SRC, getAppSrc());
            builder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        }
        Response response = null;
        response = chain.proceed(builder.build());
        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                //只为通过缓存验证，600秒不作为缓存参考时间
                .header("Cache-Control", "public, max-age=600")
                .build();
    }

    private void handle(Request.Builder builder, RequestBody body, User user) {
        try {
            String loginName = user.getTelphone();
            String timeTemp = String.valueOf(System.currentTimeMillis());
            /*密钥*/
            String secretKey = Encrypt.getReverseString(timeTemp + loginName);
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            TreeMap<String, String> treeMap = new TreeMap<>();
            for (String pair : URLDecoder.decode(buffer.readUtf8(), Util.UTF_8.name()).split("&")) {
                String[] kv = pair.split("=");
                if (kv.length == 2) {
                    treeMap.put(kv[0], kv[1]);
                }
            }
            buffer.clear();
            StringBuilder params = new StringBuilder();
            FormBody.Builder bodyBuilder = new FormBody.Builder(Util.UTF_8);
            for (String key : treeMap.keySet()) {
                String value = treeMap.get(key);
                bodyBuilder.addEncoded(key, value);
                params.append(key).append("=").append(value).append("&");
            }
//            String s=new String(buffer.readString(Util.UTF_8));
            String signTemp = params.toString() + "secretKey=" + secretKey;
            params.setLength(0);
            String sign = Encrypt.md5(Encrypt.getReverseString(Encrypt.md5(signTemp).toUpperCase())).toUpperCase();
            bodyBuilder.add("timestamp", timeTemp);
            bodyBuilder.add("sign", sign);
            FormBody fromBody = bodyBuilder.build();

            if (Logger.isDebug) {
                Logger logger = Logger.getInstance();
                logger.d("------------------------------------------------------");
                logger.d("loginName:" + loginName);
                logger.d("timeTemp:" + timeTemp);
                logger.d("signTemp:" + signTemp);
                logger.d("------------------------------------------------------");
            }
            builder.post(fromBody);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String custom(@NonNull User user) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(user.getTelphone());
        buffer.append(":");
        buffer.append(user.getPassword());
        buffer.append(":student");
//        return Encrypt.base64("18908683128:123456:student");
        return Encrypt.base64(buffer.toString());
    }

    private String getAppSrc() {
//        PackageInfo packageInfo = SysUtils.getInstance().getPackageInfo();
        return "{\"os_type\":1,\"app_type\":1,\"ver_v\":\"77\",\"ver_s\":\"5.1\",\"chan\":\"3\"}";
    }
}

package com.qxb.student.common.http;

import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.AppSrc;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.Encrypt;
import com.qxb.student.common.utils.Logger;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.utils.UserCache;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private final String POST = "POST";
    private final static String AUTHORIZATION = "Authorization";
    private final static String APP_SRC = "Appsrc";
    private final static String DISPOSITION = "Content-Disposition";
    private final static Logger logger = Logger.getInstance();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (request.method().equals(POST)) {
//            HttpUrl httpUrl = request.url();
            if (Config.CUSTOM.equals(request.header(Config.AUTH))) {
                User user = UserCache.getInstance().getUser();
                if (user != null) {
                    builder.addHeader(AUTHORIZATION, custom(user));
                    handle(builder, request.url(), request.body(), user);
                }
            } else {
                builder.addHeader(AUTHORIZATION, common());
            }
            builder.addHeader(APP_SRC, getAppSrc());
        }
        Response response = chain.proceed(builder.build());
        return response;
    }

    private void handle(Request.Builder builder, HttpUrl httpUrl, RequestBody body, User user) {
        String loginName = user.getTelphone();
        String timeTemp = String.valueOf(System.currentTimeMillis());
        /*密钥*/
        String secretKey = Encrypt.getReverseString(timeTemp + loginName);
        /*待签名*/
//        String signTemp = values.toString() + "&secretKey=" + secretKey;
//        String md51 = Encrypt.md5(signTemp).toUpperCase();
//        String sign = Encrypt.md5(Encrypt.getReverseString(md51)).toUpperCase();
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//        if (values != null) {
//            for (String key : values.keySet()) {
//                String value = values.getAsString(key);
//                if (TextUtils.isEmpty(value)) {
//                    continue;
//                }
//                bodyBuilder.add(key, value);
//            }
//        }
//        bodyBuilder.add("timestamp", timeTemp);
//        bodyBuilder.add("sign", sign);
//        logger.d("------------------------------------------------------");
//        logger.d("loginName:" + loginName);
//        logger.d("timeTemp:" + timeTemp);
//        logger.d("request:" + httpUrl.url().toString());
//        logger.d("params:");
//        logger.d("------------------------------------------------------");
//        builder.post(bodyBuilder.build());
    }

    private String common() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(Encrypt.md5("fdas897329hflsh*&929jdjksjk))8238901)_02821###889sjfdskal;11n;;``11;"));
        buffer.append(":");
        buffer.append(Encrypt.md5("sokd889223_938$&@^@!(19LWKfdj1112990)*&&!JK02010838ufdskll38x988**&*()ook"));
        return Encrypt.base64(buffer.toString());
    }

    private String custom(@NonNull User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(user.getTelphone());
        buffer.append(":");
        buffer.append(user.getPassword());
        buffer.append(":student");
        return Encrypt.base64(buffer.toString());
    }

    private String getAppSrc() {
        return new Gson().toJson(new AppSrc());
    }
}

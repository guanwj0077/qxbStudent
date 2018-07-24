package com.qxb.student.common.http;

import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Retrofit 数据转换
 *
 * @author winky
 * @date 2018/7/24
 */
public final class JsonConverterFactory extends Converter.Factory {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    public JsonConverterFactory() {
        super();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new ResponseBodyConverter<>(type);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new RequestBodyConverter<>();
    }


    private class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        private final Type type;

        public ResponseBodyConverter(Type type) {
            this.type = type;
        }

        /**
         * 转换方法
         */
        @Override
        public T convert(ResponseBody value) throws IOException {
            BufferedSource bufferedSource = Okio.buffer(value.source());
            String tempStr = bufferedSource.readUtf8();
            bufferedSource.close();
            return JSON.parseObject(tempStr, type);
        }
    }

    private class RequestBodyConverter<T> implements Converter<T, RequestBody> {
        @Override
        public RequestBody convert(T value) {
            return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value));
        }
    }
}

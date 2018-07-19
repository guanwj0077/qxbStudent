package com.qxb.student.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author winky
 * @date 2018/7/19
 */
public class JsonUtils {

    private static final Singleton<JsonUtils> SINGLETON = new Singleton<JsonUtils>() {
        @Override
        protected JsonUtils create() {
            return new JsonUtils();
        }
    };

    public static JsonUtils getInstance() {
        return SINGLETON.get();
    }

    private volatile Gson gson = new Gson();

    /**
     * 将json字符串转换成java对象
     *
     * @param json json
     * @param cls  模型
     * @return object
     */
    public <T> T toBean(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    /**
     * 将json字符串转换成java List对象
     *
     * @param json json
     * @param cls  模型
     * @return List<Class>
     */
    public <T> List<T> toList(String json, Class<T> cls) {
        try {
            return gson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将bean对象转化成json字符串
     *
     * @param obj object
     * @return json
     */
    public String toJson(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

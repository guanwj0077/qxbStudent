package com.qxb.student.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

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

    private JsonUtils() {
        TypeUtils.compatibleWithJavaBean = true;
    }

    /**
     * 将json字符串转换成java对象
     *
     * @param json
     * @param cls
     * @return
     */
    public <T> T toBean(String json, Class<T> cls) {
        try {
            System.out.println(json);
            return JSON.parseObject(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将json字符串转换成java List对象
     *
     * @param json
     * @param cls
     * @return
     */
    public <T> List<T> toList(String json, Class<T> cls) {
        try {
            return JSON.parseArray(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将bean对象转化成json字符串
     *
     * @param obj
     * @return
     */
    public String toJson(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}

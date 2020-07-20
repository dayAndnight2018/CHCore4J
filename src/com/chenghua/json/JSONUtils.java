package com.chenghua.json;
import com.alibaba.fastjson.*;
import com.alibaba.fastjson.serializer.JSONSerializer;

public class JSONUtils<T> {

    public static <T> T parseObject(String objStr, Class<T> clazz){
        T result = null;
        try {
            result = JSON.parseObject(objStr, clazz);
            return result;
        }catch (Exception ex){
            return null;
        }
    }

    public static String toJsonString(Object obj){
        return JSON.toJSONString(obj);
    }
}

package com.chenghua.beans;

import com.chenghua.collections.ArrayUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanUtils {

    public static boolean isAllFieldsNull(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        if (ArrayUtils.notBlank(fields)) {
            for (Field field : fields) {
                try {
                    PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), obj.getClass());
                    Method method = descriptor.getReadMethod();
                    method.setAccessible(true);
                    Object result = method.invoke(obj);
                    if (result != null) {
                        return false;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    public static <T> T defaultValue(T source, T defaultVal){
        T result = source;
        if(result == null){
            result = defaultVal;
        }
        return result;
    }
}

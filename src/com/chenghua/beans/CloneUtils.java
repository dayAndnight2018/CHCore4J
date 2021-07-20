package com.chenghua.beans;

import java.io.*;

public class CloneUtils {

    /**
     * 采用序列化流的方式克隆对象
     * @param source
     * @param <T>
     * @return
     */
    public static <T extends Serializable> T clone(T source){
        T result = null;
        try (ByteArrayOutputStream bao = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bao);){
            oos.writeObject(source);
            try (ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bai);){
                result = (T) ois.readObject();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}

package com.chenghua.collections;

import com.chenghua.exceptions.CollectionNullOrEmptyException;
import com.chenghua.extendslite.StringExtends;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayUtils {

    public static <T> boolean notBlank(T[] array) {
        return array != null && array.length > 0;
    }

    public static <T> void print(T[] array, PrintStream stream) throws CollectionNullOrEmptyException {
        if(notBlank(array)){
            if(stream == null ){
                stream = System.out;
            }
            stream.println(Arrays.toString(array));
            return;
        }
        throw new CollectionNullOrEmptyException("The array is null or empty!");
    }

    public static <T> void print(T[] array, PrintStream stream, String splitter) throws CollectionNullOrEmptyException {
        if(StringExtends.isBlank(splitter)){
            print(array,stream);
        }
        if(notBlank(array)){
            if(stream == null ){
                stream = System.out;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0;i < array.length ; i++){
                sb.append(array[i].toString());
                if(i!=array.length-1){
                    sb.append(splitter);
                    sb.append(StringExtends.ONE_SPACE);
                }
            }
            sb.append("]");
            stream.println(sb.toString());
            return;
        }
        throw new CollectionNullOrEmptyException("The array is null or empty!");
    }
}

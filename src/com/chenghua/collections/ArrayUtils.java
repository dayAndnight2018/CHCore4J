package com.chenghua.collections;

import com.chenghua.beans.AssertUtils;
import com.chenghua.exceptions.CollectionNullOrEmptyException;
import com.chenghua.extendslite.StringUtils;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayUtils {

    /**
     * judge if an array is not null and not empty
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean notBlank(T[] array) {
        return AssertUtils.notNull(array) && array.length > 0;
    }

    /**
     * judge if an array is null or empty
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean nullOrEmpty(T[] array) {
        return !notBlank(array);
    }

    /**
     * judge if the ele is in the array
     *
     * @param ele
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean anyMatch(T ele, T[] array) {
        if (nullOrEmpty(array)) {
            return false;
        }
        return Arrays.asList(array).contains(ele);
    }

    /**
     * judge if any element in judge is in total
     *
     * @param partial
     * @param total
     * @param <T>
     * @return
     */
    public static <T> boolean anyMatch(T[] partial, T[] total) {
        if (nullOrEmpty(total)) {
            return false;
        }
        if (nullOrEmpty(partial)) {
            return true;
        }
        Stream<T> stream = Arrays.stream(total);
        for (T temp : partial) {
            if (stream.anyMatch(temp::equals)) {
                return true;
            }
        }
        return false;
    }

    /**
     * judge if all elements are in total
     *
     * @param judge
     * @param total
     * @param <T>
     * @return
     */
    public static <T> boolean allMatch(T[] judge, T[] total) {
        if (nullOrEmpty(total)) {
            return false;
        }
        if (nullOrEmpty(judge)) {
            return true;
        }
        for (T temp : judge) {
            if (!anyMatch(temp, total)) {
                return false;
            }
        }
        return true;
    }

    /**
     * distinct an array
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> T[] distinct(T[] array) {
        if (nullOrEmpty(array)) {
            return null;
        }
        HashSet<T> set = new HashSet<T>(Arrays.asList(array));
        return (T[]) set.toArray();
    }

    /**
     * obtain elements by page
     *
     * @param array
     * @param page
     * @param num
     * @param <T>
     * @return
     */
    public static <T> T[] page(T[] array, long page, long num) {
        if (nullOrEmpty(array)) {
            return null;
        }
        Stream<T> stream = Arrays.stream(array);

        long size = stream.count();
        long totalPage = 0;
        if (size % num == 0) {
            totalPage = size / num;
        } else {
            totalPage = size / num + 1;
        }

        if (page > totalPage) {
            return null;
        }
        return (T[]) stream.skip((page - 1) * num).limit(num).collect(Collectors.toList()).toArray();
    }

    public static <T> void print(T[] array) throws CollectionNullOrEmptyException {
        if (notBlank(array)) {
            CollectionUtils.print(Arrays.asList(array));
            return;
        }
        throw new CollectionNullOrEmptyException("The array is null or empty!");
    }

    public static <T> void print(T[] array, PrintStream stream) throws CollectionNullOrEmptyException {
        if (notBlank(array)) {
            if (stream == null) {
                stream = System.out;
            }
            stream.println(Arrays.toString(array));
            return;
        }
        throw new CollectionNullOrEmptyException("The array is null or empty!");
    }

    public static <T> void print(T[] array, PrintStream stream, String splitter) throws CollectionNullOrEmptyException {
        if (StringUtils.isBlank(splitter)) {
            print(array, stream);
        }
        if (notBlank(array)) {
            if (stream == null) {
                stream = System.out;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i].toString());
                if (i != array.length - 1) {
                    sb.append(splitter);
                    sb.append(StringUtils.ONE_SPACE);
                }
            }
            sb.append("]");
            stream.println(sb.toString());
            return;
        }
        throw new CollectionNullOrEmptyException("The array is null or empty!");
    }
}

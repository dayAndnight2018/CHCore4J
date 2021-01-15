package com.chenghua.beans;

import com.chenghua.exceptions.AssertClassNotMatchException;
import com.chenghua.exceptions.AssertFailedException;
import com.chenghua.exceptions.AssertNotEqualsException;
import com.chenghua.exceptions.AssertOneNullInputException;

import java.util.Objects;

public class AssertUtils {

    /**
     * 必须重写hashcode equals方法
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean equals(Object obj1, Object obj2) {
        return Objects.equals(obj1, obj2);
    }

    /**
     * 以抛出异常的方式检测相等性
     *
     * @param obj1
     * @param obj2
     * @throws AssertOneNullInputException
     * @throws AssertClassNotMatchException
     * @throws AssertNotEqualsException
     */
    public static void assertEquals(Object obj1, Object obj2) throws AssertNotEqualsException {
        if (!equals(obj1, obj2)) {
            throw new AssertNotEqualsException();
        }
    }

    /**
     * 不等
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean notEquals(Object obj1, Object obj2) {
        return !equals(obj1, obj2);
    }

    /**
     * 以抛出异常的方式确保不等
     *
     * @param obj1
     * @param obj2
     * @throws AssertFailedException
     */
    public static void assertNotEquals(Object obj1, Object obj2) throws AssertFailedException {
        if (equals(obj1, obj2)) {
            throw new AssertFailedException();
        }
    }

    /**
     * 非空
     *
     * @param obj
     * @return
     */
    public static boolean notNull(Object obj) {
        return obj != null;
    }

    /**
     * 以抛出异常的方式判断非空
     *
     * @param obj
     */
    public static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }
}

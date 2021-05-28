package com.chenghua.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionUtils {

    /**
     * 返回空List
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList(){
        return new ArrayList<>();
    }

    /**
     * judge a collection is not null and not empty
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> boolean notBlank(Collection collection) {
        return collection != null && collection.size() != 0;
    }

    /**
     * judge a collection is null or empty
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> boolean nullOrEmpty(Collection collection) {
        return !notBlank(collection);
    }

    /**
     * if any element in collection
     *
     * @param ele
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> boolean anyMatch(T ele, Collection<T> collection) {
        if (nullOrEmpty(collection)) {
            return false;
        }
        if (ele == null) {
            return true;
        }

        return collection.contains(ele);
    }

    /**
     * if any element in collection
     *
     * @param judge
     * @param total
     * @param <T>
     * @return
     */
    public static <T> boolean anyMatch(Collection<T> judge, Collection<T> total) {
        if (nullOrEmpty(total)) {
            return false;
        }
        if (nullOrEmpty(judge)) {
            return true;
        }

        for (T temp : judge) {
            if (anyMatch(temp, total)) {
                return true;
            }
        }
        return false;
    }

    /**
     * if all elements in collection
     *
     * @param judge
     * @param total
     * @param <T>
     * @return
     */
    public static <T> boolean allMatch(Collection<T> judge, Collection<T> total) {
        return !nullOrEmpty(total) && (nullOrEmpty(judge) || total.containsAll(judge));
    }

    public static void print(Collection collection) {
        collection.stream().forEach(System.out::println);
    }
}

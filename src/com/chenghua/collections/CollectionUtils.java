package com.chenghua.collections;

import java.util.*;

public class CollectionUtils {

    /**
     * 返回空List
     *
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 返回空Set
     *
     * @param <T>
     * @return
     */
    public static <T> Set<T> newHashSet() {
        return new HashSet<>();
    }

    /**
     * 返回空HashMap
     *
     * @param <U>
     * @param <V>
     * @return
     */
    public static <U, V> Map<U, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 确保非空
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> List<T> insure(List<T> collection) {
        return collection != null ? collection : newArrayList();
    }

    /**
     * 确保非空
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> Set<T> insure(Set<T> collection) {
        return collection != null ? collection : newHashSet();
    }

    /**
     * 确保非空
     *
     * @param collection
     * @param <U>
     * @param <V>
     * @return
     */
    public static <U, V> Map<U, V> insure(Map<U, V> collection) {
        return collection != null ? collection : newHashMap();
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
        return !nullOrEmpty(collection) && collection.contains(ele);
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

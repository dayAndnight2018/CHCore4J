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
     * 返回List
     *
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList(List<T> list) {
        if (nullOrEmpty(list))
            return newArrayList();
        else
            return new ArrayList<>(list);
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
     * 返回复制Set
     *
     * @param <T>
     * @return
     */
    public static <T> Set<T> newHashSet(Set<T> set) {
        if(nullOrEmpty(set))
            return newHashSet();
        else
            return new HashSet<>(set);
    }

    /**
     * 返回复制Set
     *
     * @param <T>
     * @return
     */
    public static <T> Set<T> newHashSet(Collection<T> collection) {
        if(nullOrEmpty(collection))
            return newHashSet();
        else
            return new HashSet<>(collection);
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
     * 返回空HashMap
     *
     * @param <U>
     * @param <V>
     * @return
     */
    public static <U, V> Map<U, V> newHashMap(Map<U, V> map) {
        if (nullOrEmpty(map))
            return newHashMap();
        else
            return new HashMap<>(map);
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
    public static <T> boolean notBlank(Collection<T> collection) {
        return collection != null && collection.size() != 0;
    }

    /**
     * map判断非空
     * @param map
     * @param <U>
     * @param <V>
     * @return
     */
    public static <U, V> boolean notBlank(Map<U, V> map) {
        return map != null && map.entrySet().size() != 0;
    }

    /**
     * judge a collection is null or empty
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> boolean nullOrEmpty(Collection<T> collection) {
        return !notBlank(collection);
    }

    /**
     * 空判断
     * @param map
     * @param <U>
     * @param <V>
     * @return
     */
    public static <U, V> boolean nullOrEmpty(Map<U, V> map) {
        return !notBlank(map);
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

    /**
     * 计算并集，不影响原来的元素
     * @param set1
     * @param set2
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Set<T> set1, Set<T> set2){
        if (nullOrEmpty(set1) && nullOrEmpty(set2)){
            return newHashSet();
        }
        if (nullOrEmpty(set1)){
            return newHashSet(set2);
        }
        if (nullOrEmpty(set2)){
            return newHashSet(set1);
        }
        Set<T> result = newHashSet(set1);
        result.addAll(set2);
        return result;
    }

    /**
     * 计算并集
     * @param collection1
     * @param collection2
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Collection<T> collection1, Collection<T> collection2){
        return union(newHashSet(collection1), newHashSet(collection2));
    }

    /**
     * 交集
     * @param set1
     * @param set2
     * @param <T>
     * @return
     */
    public static <T> Set<T> intersect(Set<T> set1, Set<T> set2){
        if (nullOrEmpty(set1) || nullOrEmpty(set2)){
            return newHashSet();
        }
        Set<T> result = newHashSet(set1);
        result.retainAll(set2);
        return result;
    }

    /**
     * 并集
     * @param collection1
     * @param collection2
     * @param <T>
     * @return
     */
    public static <T> Set<T> intersect(Collection<T> collection1, Collection<T> collection2){
        return intersect(newHashSet(collection1), newHashSet(collection2));
    }

    /**
     * 差集
     * @param set1
     * @param set2
     * @param <T>
     * @return
     */
    public static <T> Set<T> except(Set<T> set1, Set<T> set2){
        if (nullOrEmpty(set1)){
            return newHashSet();
        }
        if (nullOrEmpty(set2)){
            return newHashSet(set1);
        }
        Set<T> result = newHashSet(set1);
        result.removeAll(set2);
        return result;
    }

    /**
     * 差集
     * @param collection1
     * @param collection2
     * @param <T>
     * @return
     */
    public static <T> Set<T> except(Collection<T> collection1, Collection<T> collection2){
        return except(newHashSet(collection1), newHashSet(collection2));
    }
}

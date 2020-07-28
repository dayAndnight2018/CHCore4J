package com.chenghua.cache;

import com.chenghua.datetime.DateTime;

public interface CacheOperations<T> {

    T get(String key);

    void set(String key, T val, DateTime expires);

    void set(String key, T val, int relativeExpiresSeconds);

    int count();

    String[] keys();

    T remove(String key);

    void clear();

    boolean contains(String key);
}

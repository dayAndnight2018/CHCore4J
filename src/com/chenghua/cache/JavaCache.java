package com.chenghua.cache;

import com.chenghua.collections.Tuple;
import com.chenghua.datetime.DateTime;
import com.chenghua.exceptions.InvalidConstructorArgs;
import com.chenghua.exceptions.InvalidInputException;
import com.chenghua.extendslite.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaCache<T> implements CacheOperations<T> {

    private static JavaCache instance = null;
    private static final Object LOCK = new Object();
    private volatile ConcurrentHashMap<String, Tuple<T, DateTime>> map;
    private static final ExecutorService service = Executors.newFixedThreadPool(1);

    public static JavaCache getInstance(int capacity) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new JavaCache(capacity);
                }
            }
        }
        return instance;
    }

    private JavaCache(int capacity) {
        map = new ConcurrentHashMap<String, Tuple<T, DateTime>>(capacity);
        service.submit(() -> {
            while (true) {
                Thread.sleep(1000*60);
                List<String> keys = new ArrayList<>();
                Tuple<T, DateTime> temp = null;
                DateTime time = null;
                for (String s : map.keySet()) {
                    temp = map.get(s);
                    time = temp.getValue();
                    if (time != null && time.before(DateTime.now())){
                        keys.add(s);
                    }
                }
                for(String s:map.keySet()){
                    if(keys.contains(s)){
                        map.remove(s);
                    }
                }
            }
        });
    }

    @Override
    public T get(String key) {
        if (contains(key)) {
            Tuple<T, DateTime> value = (Tuple<T, DateTime>) map.get(key);
            DateTime date = value.getValue();
            if (date == null || date.after(DateTime.now())) {
                return value.getKey();
            }
            remove(key);
        }
        return null;
    }

    @Override
    public void set(String key, T val, DateTime expires) {
        Tuple<T, DateTime> tuple = new Tuple<T, DateTime>(val, expires);
        map.put(key, tuple);
    }

    @Override
    public void set(String key, T val, int relativeExpiresSeconds) {
        try {
            set(key, val, DateTime.now().addSeconds(relativeExpiresSeconds));
        } catch (InvalidConstructorArgs invalidConstructorArgs) {
            invalidConstructorArgs.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int count() {
        return map.size();
    }

    @Override
    public String[] keys() {
        return map.keySet().toArray(new String[]{});
    }

    @Override
    public T remove(String key) {
        if (contains(key)) {
            Tuple<Object, DateTime> tuple = (Tuple<Object, DateTime>) map.remove(key);
            return (T) tuple.getKey();
        }
        return null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(String key) {
        if (StringUtils.isBlank(key)) {
            return false;
        }

        return map.containsKey(key);
    }
}

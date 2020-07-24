package com.chenghua.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFactory {

    private Map<String, Future> map = new HashMap<>();

    static ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*15);
    }

    public void addTask(String taskName, Callable callable){
        map.put(taskName, executorService.submit(callable));
    }

    public <T> T getResult(String taskName, T defaultVal){
        try {
            return (T) map.get(taskName);
        }catch (Exception ex){
            return defaultVal;
        }
    }
}

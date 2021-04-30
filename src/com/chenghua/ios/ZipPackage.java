package com.chenghua.ios;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ZipPackage {

    private HashMap<String, InputStream> map = new HashMap<>();

    public InputStream get(String key){
        if(!map.containsKey(key))
            return null;
        return  map.get(key);
    }

    public boolean add(String key, InputStream stream){
        if(map.containsKey(key))
            return false;
        map.put(key,stream);
        return true;
    }

    public boolean set(String key, InputStream stream){
        if(!map.containsKey(key))
            return false;
        map.put(key,stream);
        return true;
    }

    public boolean remove(String key, InputStream stream){
        if(!map.containsKey(key))
            return false;
        map.remove(key);
        return true;
    }

    public int size(){
        return map.size();
    }

    public Set<String> keys(){
        return  map.keySet();
    }

    public Set<Map.Entry<String,InputStream>> entries(){
        return map.entrySet();
    }
}

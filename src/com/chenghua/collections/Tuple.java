package com.chenghua.collections;

public class Tuple<U, V> {

    private U u;
    private V v;

    public Tuple() {
        u = null;
        v = null;
    }

    public Tuple(U u, V v) {
        this.u = u;
        this.v = v;
    }

    public U getKey() {
        return u;
    }

    public V getValue() {
        return v;
    }

    public void setKey(U u) {
        this.u = u;
    }

    public void setValue(V v) {
        this.v = v;
    }

}

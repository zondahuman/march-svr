package com.abin.lee.march.svr.concurrent.lru;

/**
 * Created by abin on 2018/1/18 23:15.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lru
 */
public interface LruCache<K, V> {
    public V get(K key);

    void put(K key, V value);
}

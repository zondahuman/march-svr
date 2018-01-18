package com.abin.lee.march.svr.concurrent.lru;

import java.util.LinkedHashMap;

/**
 * Created by abin on 2018/1/18 22:50.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lru
 */
public class LruLinkedHashMap<K, V> {

    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    LinkedHashMap<K, V> map;

    public LruLinkedHashMap(int cacheSize){
        
    }
}

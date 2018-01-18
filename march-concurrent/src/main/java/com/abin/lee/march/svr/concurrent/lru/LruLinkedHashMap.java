package com.abin.lee.march.svr.concurrent.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by abin on 2018/1/18 22:50.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lru
 */
public class LruLinkedHashMap<K, V> implements LruCache<K, V>{

    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    LinkedHashMap<K, V> map;

    public LruLinkedHashMap(int capacity){
        this.map = new LinkedHashMap<K, V>(capacity){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
                return size() > capacity;
            }
        };
    }

    public void clear() {
        map.clear();
    }


    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);

    }

    public static void main(String[] args) {
        LruLinkedHashMap<String, Integer> cache = new LruLinkedHashMap<>(2);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);

        System.out.println("a:" + cache.get("a"));
        System.out.println("b:" + cache.get("b"));
        System.out.println("c:" + cache.get("c"));
        System.out.println("d:" + cache.get("d"));

        Random random = new Random();

        System.out.println(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(0,30)+random.nextInt(10));


        
    }
}

package com.jd.validator.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-14 09:25
 */
public class ConcurrentHashMapDemo {

    private Map<Integer, Integer> cache = new ConcurrentHashMap<>(15);

    public static void main(String[] args) {

        ConcurrentHashMapDemo ch = new ConcurrentHashMapDemo();

        System.out.println(ch.fibonaacci(80));
    }

    public int fibonaacci(Integer i) {

        if (i == 0 || i == 1) {

            return i;
        }

        System.out.println("cache============>"+ cache);

        // JDK8 bug https://bugs.openjdk.java.net/browse/JDK-8062841
        return cache.computeIfAbsent(i, (key) -> {

            System.out.println("fibonaacci : " + key);

            return fibonaacci(key - 1) + fibonaacci(key - 2);

        });

    }


}

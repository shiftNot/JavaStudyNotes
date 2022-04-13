package com.itheima02_并发包.p02ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class MyThread extends Thread {
    //HashMap在多线程环境下存储安全隐患
    //public HashMap<String, Integer> hm = new HashMap<>();
    //Hashtable可以解决HashMap的线程安全问题
    //public Hashtable<String, Integer> hm = new Hashtable<>();
    //ConcurrentHashMap可以解决HashMap的线程安全问题
    public ConcurrentHashMap<String, Integer> hm = new ConcurrentHashMap<>();

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            hm.put(getName() + i, i);
        }
    }
}

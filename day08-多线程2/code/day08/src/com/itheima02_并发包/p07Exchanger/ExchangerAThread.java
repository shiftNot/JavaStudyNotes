package com.itheima02_并发包.p07Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerAThread extends Thread {
    private Exchanger<String> e;

    public ExchangerAThread(Exchanger<String> e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            //将内容给到另一个线程，等待内容回收，长时间没有收到数据,不会有任何反应
            //但是这样的代码，并不利于程序的设计。
            //String result = e.exchange("B线程，你好，这是我给你的礼物,收到请回复");
            String result = e.exchange("B线程，你好，这是我给你的礼物,收到请回复", 3, TimeUnit.SECONDS);
            System.out.println("线程A收到的礼物:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

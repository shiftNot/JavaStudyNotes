package com.itheima02_并发包.p07Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerBThread extends Thread {
    private Exchanger<String> e;

    public ExchangerBThread(Exchanger<String> e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            String result = e.exchange("A线程，你好，这是我给你的礼物，你的礼物我收到了", 3, TimeUnit.SECONDS);
            System.out.println("线程B收到的礼物:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

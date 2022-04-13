package com.itheima04_内部类.p01成员内部类;

public class Person {
    private boolean live = true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    //心脏类
    class Heart {
        //心脏跳动的方法
        public void jump() {
            if (live) {
                System.out.println("砰砰...砰砰...砰砰...");
            } else {
                System.out.println("哔......");
            }
        }
    }

    public void show(){
        //内部类的内容，外部类不能直接使用
        Heart h = new Heart();
        h.jump();
    }
}

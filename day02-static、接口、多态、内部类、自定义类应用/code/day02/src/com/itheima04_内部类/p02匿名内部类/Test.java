package com.itheima04_内部类.p02匿名内部类;

/*
1.介绍：内部类的简化写法。它的本质是一个指定父类或接口的(带具体实现)子类或实现类对象。
2.意义:当一个类或接口中的方法，在重写后，只需要使用1次的时候，可以使用匿名内部类简化书写。
3.格式:
    new 父类名或者接口名(){  // 方法重写 };
    表示创建了new后面指定类型的子类或实现类对象，而不需要体现这个子类或实现类的名字(匿名)
4.使用场景
    通过多态的形式指向父类引用
    直接调用方法
    作为方法参数传递

 */
public class Test {
    public static void main(String[] args) {
        //想要调用showFly方法，需要四部(1.创建实现类 2.重写接口中的抽象方法 3.创建实现类对象 4.调用方法)
        /*FlyableImpl f = new FlyableImpl();
        showFly(f);*/
        //如果说对于父类或接口的实现，最终只需要使用1次，优先考虑匿名内部类
        //匿名内部类可以一步完成上面的动作。
        /*
          //下面整体，代表的是Flyable的一个实现类对象。
          new Flyable(){
                重写Flyable的方法
          }
         */

        //通过多态的形式指向父类引用
        Flyable f = new Flyable() {
            @Override
            public void fly() {
                System.out.println("直线起飞2");
            }
        };
        f.fly();
        //直接调用方法
        new Flyable() {
            @Override
            public void fly() {
                System.out.println("直线起飞2");
            }
        }.fly();
        //作为方法参数传递
        showFly(new Flyable() {
            @Override
            public void fly() {
                System.out.println("直线起飞2");
            }
        });
    }

    //这里将飞的动作抽象化，将来交给Flyable的实现类做具体的实现。
    public static void showFly(Flyable f) {
        System.out.println("准备就绪");
        f.fly();
        System.out.println("平稳落地");
    }
}

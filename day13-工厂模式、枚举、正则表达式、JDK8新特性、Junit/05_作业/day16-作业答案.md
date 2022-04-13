# 			day17 作业答案

## 一 完成单例设计模式代码

**饿汉式**

 ~~~java
public class SingleDemo {

    //（1）定义一个私有静态变量，定义该静态变量的时候，创建一个该类的对象赋予该变量
    private static SingleDemo instance = new SingleDemo();

    //（2）把构造器私有化
    private SingleDemo(){

    }

    //（3）提供一个公开的静态方法，把唯一的对象给返回出去
    public static SingleDemo getInstance(){
        return instance;
    }

}
 ~~~

**懒汉式**

~~~java
public class SingleDemo {

    //（1）定义一个私有的静态变量，准备之后接收唯一的实例对象
    private static SingleDemo instance;

    //（2）私有化构造器
    private SingleDemo(){

    }

    /*
     （3）定义公开的静态方法，等待需要使用这个对象的时候，先判断是否有唯一对象，
    如果没有则创建一个对象进行返回，如果有则直接返回该对象
     */
    public static SingleDemo getInstance(){
        if(instance==null){//判断是否存在唯一对象
            instance = new SingleDemo();//创建该对象
        }
        return instance;
    }

}
~~~



## 二 完成多例设计模式代码

~~~java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Multition {
    // 定义该类被创建的总数量
    private static final int maxCount = 3;
    // 定义存放类实例的list集合
    private static List instanceList = new ArrayList();
    // 构造方法私有化,不允许外界创建本类对象
    private Multition() {
    }
    static {
        // 创建本类的多个实例,并存放到list集合中
        for (int i = 0; i < maxCount; i++) {
            Multition multition = new Multition();
            instanceList.add(multition);
        }
    }
    // 给外界提供一个获取类对象的方法
    public static Multition getMultition(){
        Random random = new Random();
        // 生成一个随机数
        int i = random.nextInt(maxCount);
        // 从list集合中随机取出一个进行使用
        return (Multition)instanceList.get(i);
    }
}
~~~

 

## 三 完成工厂设计模式代码

1.编写一个Car接口, 提供run方法

```java
public interface Car {
    public void run();
}
```

2.编写一个Bmw类实现Car接口,重写run方法

```java
public class Bmw implements Car {
    @Override
    public void run() {
        System.out.println("宝马以每小时500公里的速度在奔跑.....");
    }
}
```

3.编写一个Benz类实现Car接口

```java
public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("奔驰汽车以每秒1米的速度在挪动.....");
    }
}
```

4.提供一个CarFactory(汽车工厂),用于生产汽车对象

```java
public class CarFactory {
    /**
     * @param id : 车的标识
     *           bmw: 代表需要创建Bmw类对象
     *           benz : 代表需要创建Benz类对象
     *           如果传入的车标识不正确,代表当前工厂生成不了当前车对象,则返回null
     * @return
     */
    public Car createCar(String id){
        if("bmw".equals(id)){
            return new Bmw();
        }else if("benz".equals(id)){
            return new Benz();
        }
        return null;
    }
}
```

5.定义CarFactoryTest测试汽车工厂

```java
public class CarFactoryTest {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car bmw = carFactory.createCar("bmw");
        bmw.run();
        Car benz = carFactory.createCar("benz");
        benz.run();
    }
}
```




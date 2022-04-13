# day15 单例模式、多例模式、枚举、工厂模式

# 今日内容

- 单例模式	
- 多例模式
- 枚举
- 工厂模式

# 教学目标

- [ ] 能够说出单例设计模式的好处
- [ ] 能够说出多例模式的好处
- [ ] 能够定义枚举
- [ ] 能够使用工厂模式编写java程序

# 第一章 单例设计模式

## 知识点--概述

### 目标

理解单例设计模式思想

### 路径

- 介绍
- 作用
- 模式特点
- 实现方式分类

### 讲解

#### 1.1.1 介绍

单例模式（Singleton Pattern）是 Java 中的设计模式之一，属于创建型模式，
它提供了一种创建对象的最佳方式。

#### 1.1.2 作用

保证在程序运行期间,某个类有且仅能创建一个对象,从而节省内存资源。

#### 1.1.3 模式特点

​	1.将构造方法私有化,确保在类的外部不能通过new来创建对象

​	2.在本类中创建该类的对象

​	3.提供公共的访问方式来访问该类的唯一对象  静态方法

#### 1.1.4 实现方式分类

- 饿汉模式:类加载到内存中时，就将类的对象创建好，以备使用，且对象不能再新建。
- 懒汉模式:在需要使用对象的时候，通过指定方法获取创建的对象，且对象只能创建这一次。

### 小结

```

```

## 知识点--饿汉式

### 目标

理解饿汉式实现过程

### 路径

- 实现步骤
- 演示饿汉式单例模式

### 讲解

#### 1.2.1 实现步骤

1. 将构造方法私有化，使其不能在类的外部通过new关键字创建该类对象。
2. 定义一个本类类型的成员属性，并且创建对象；使用private  static final修饰； 
3. 定义一个公共,静态方法,返回这个唯一对象。

#### 1.2.2 演示饿汉式单例模式

需求:定义一个饿汉式单例模式的类，演示饿汉式单例模式的使用。

//饿汉式单例模式类

```java
public class Singleton {
    // 1.将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
    private Singleton() {}

    // 2.在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static final Singleton instance = new Singleton();
    
    // 3.定义一个静态方法返回这个唯一对象。
    public static Singleton getInstance() {
        return instance;
    }
}
```

//测试类

```

```

### 小结

```

```



## 知识点--懒汉式

### 目标

理解懒汉式实现过程

### 路径

- 实现步骤
- 演示懒汉式单例模式

### 讲解

#### 1.3.1实现步骤

1. 构造方法私有化；

2. 内部定义私有、静态本类类型成员属性，不初始化；

3. 提供公有、静态方法，获取此对象引用；

4. 在方法内，先判断成员属性是否被初始化：
   
   - 否：初始化；
   
   - 是 :  返回这个引用。

#### 1.3.2 演示懒汉式单例模式

需求:定义一个懒汉式单例模式的类，演示饿汉式单例模式的使用。

```java
public class Singleton {

    // 2.在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static Singleton instance;
    
    // 1.将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
    private Singleton() {}
    
    // 3.定义一个静态方法返回这个唯一对象。要用的时候才例化出对象
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

//测试类代码

```

```

### 小结

```

```



# 第二章 多例设计模式

## 知识点--概述

### 目标

理解多例设计模式思想

### 路径

- 介绍
- 作用
- 模式特点
- 实现方式分类

### 讲解

#### 2.1.1介绍

多例模式(Multiton Pattern)是 Java 中的设计模式之一，属于创建型模式。
它提供了一种控制创建的对象个数的方式。

#### 2.1.2作用

在程序运行期间,保证某个类有且仅能创建固定数量个对象,从而节省内存空间

#### 2.1.3模式特点

​	1.构造方法要私有化,确保在类的外部不能通过new来创建对象

​	2.在本类中创建固定个数的对象

​	3.提供公共的访问方式   公共静态方法

#### 2.1.4 实现方式分类

通用对象模式：无特殊含义区分的若干对象定义

特定对象模式:  有特殊含义区分的若干对象定义

### 小结

```

```



## 知识点--通用对象模式

### 目标

理解通用对象的多例模式实现过程

### 路径

- 实现步骤
- 演示通用对象的多例模式

### 讲解

### 2.2.1实现步骤

1. 创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
2. 内部成员位置定义该类被创建的总数量,使用private static final修饰
3. 内部成员位置定义一个“集合”,使用 private static修饰
4. 在静态代码块中创建指定个数的本类对象,并添加到集合中
5. 提供一个公有、静态方法，随机获取集合中的一个对象。

### 2.2.2演示通用对象的多例模式

需求:定义一个通用对象的多例模式的类，演示通用对象的多例模式的使用。

//通用对象的多例模式的类

```java
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
```

//测试类

```java
public static void main(String[] args) {
    // 编写一个循环从中获取类对象
    for (int i = 0; i < 10; i++) {
        Multition multition = Multition.getMultition();
        System.out.println(multition);
    }
}
```

### 小结

```

```

## 知识点--特定对象模式

### 目标

理解特定对象的多例模式实现过程

### 路径

- 实现步骤
- 演示特定对象的多例模式

### 讲解

### 2.2.1实现步骤

1. 创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
2. 内部成员位置定义“几个本类对象” ,使用 public static final修饰 ​	

### 2.2.2演示特定对象的多例模式

需求:定义一个性别类(使用特定对象的多例模式定义)，该类中只有boy,girl 两种性别，演示特定对象的多例模式的使用。

```java
public class Sex {
    private String title;
    //1.构造方法私有化
    private Sex(String title){
        this.title = title;
    }
    //2.定义两个Sex对象
    public static final Sex BOY = new Sex("男");
    public static final Sex GIRL = new Sex("女");


    @Override
    public String toString() {
        return title;
    }
}

```

### 小结

```

```

# 第三章 工厂设计模式

## 知识点--定义与使用

### 目标

掌握工厂模式的设计思想

### 路径

- 介绍
- 应用场景
- 演示工厂模式的使用

### 讲解

#### 3.1.1介绍

工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一，属于创建型模式。
它提供了一种创建对象的最佳方式。将本类需要分别通过new来创建的事物，统一了操作方式。

#### 3.1.2应用场景

如果要创建的对象传入参数过于繁杂，或子类过于繁杂的时，可以使用工厂模式，把对象的创建和使用的过程分开，简化获取对象的过程。调用者只负责使用，不管对象的创建和初始化。

#### 3.1.3演示工厂模式的使用

需求:需求:Car接口(含run方法)，实现类有奔驰和法拉利，使用工厂模式，模拟获取奔驰和法拉利汽车对象。

```
思路:创建复杂对象的代码封装到工厂类中,外界就可以通过工厂类直接获取该对象
分析:
	自己创建对象：
			Falali fll = new Falali(需要很多初始化参数);
			Benchi bc = new Benchi(需要很多初始化参数);
	定义汽车工厂:
			Falali getFaLaLi(){初始化法拉利汽车}
			Benchi getBenCh(){初始化奔驰汽车} 
步骤:
	1. 编写一个Car接口, 提供run方法
	2. 编写一个Falali类实现Car接口,重写run方法
	3. 编写一个Benchi类实现Car接口
	4. 提供一个CarFactory(汽车工厂),用于生产汽车对象
	5. 定义CarFactoryTest测试汽车工厂
```

//Car接口

```java
public interface Car {
    public void run();
}
```

//Falali类

```java
public class Falali implements Car {
    
    @Override
    public void run() {
        System.out.println("法拉利以每小时1公里的速度在奔跑.....");
    }
}
```

3.Benchi类

```java
public class Benchi implements Car {
    @Override
    public void run() {
        System.out.println("奔驰汽车以每秒1米的速度在挪动.....");
    }
}
```

4.CarFactory(汽车工厂)

```java
public class CarFactory {
    public static  Car createCar(String id){
        if("falali".equals(id)){
            return new Falali();
        }else if("benchi".equals(id)){
            return new Benchi();
        }
        return null;
    }
}
```

5.定义CarFactoryTest测试汽车工厂

```java
public class CarFactoryTest {
    public static void main(String[] args) {
        Car benchi = CarFactory.createCar("benchi");
        benchi.run();
        Car falali = CarFactory.createCar("falali");
        falali.run();
    }
}
```

> 作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。
> **需要注意复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式**。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。

### 小结

```

```

# day13 【单例模式、多例模式、枚举、工厂模式】

## 今日目标

- 枚举---->必须掌握
  - 定义枚举
  - 使用枚举
- 工厂模式---->必须掌握
- JDK8新特性
  - 方法引用---->了解
  - Base64---->必须掌握
- 正则表达式---->必须掌握
- Junit单元测试---->必须掌握



# 第一章 枚举

## 1.1 枚举的定义和使用--重点

#### 不使用枚举存在的问题

假设我们要定义一个人类，人类中包含姓名和性别。通常会将性别定义成字符串类型，效果如下：

```java
public class Person {
    private String name;
    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
	
    // 省略get/set/toString方法
}
```

```java
public class Demo01 {
    public static void main(String[] args) {
        Person p1 = new Person("张三", "男");
        Person p2 = new Person("张三", "abc"); // 因为性别是字符串,所以我们可以传入任意字符串
    }
}
```

不使用枚举存在的问题：可以给性别传入任意的字符串，导致性别是非法的数据，不安全。

#### 枚举的概念

   枚举是一种引用数据类型,java中枚举的底层是一个有固定个数对象的"特殊类"。**所以如果某种类型的数据有固定个值,就可以定义为枚举类型。比如性别,  季节，方向。**

#### 定义枚举的格式

- 格式:

  ```java
  public enum 枚举名{
      枚举值,枚举值,枚举值,... // 枚举值全部字母大小,多个枚举值使用逗号隔开
  }
  ```

- 案例:

  ```java
  // 性别枚举类型
  public enum Gender {
      // 枚举值
      MAN,WOMAN,YAO
  }
  
  // 季节枚举类型
  public enum Season {
      SPRING,
      SUMMER,
      AUTUMN,
      WINTER
  }
  
  // 方向枚举类型
  public enum Direction {
      UP,
      DOWN,
      LEFT,
      RIGHT
  }
  
  ```

  

#### 枚举的使用

- 格式:  `枚举名.枚举值`

- 案例:

  ```java
  public class Person {
      String name;
      // 性别枚举类型的成员变量
      Gender gender;
  
      public Person(String name, Gender gender) {
          this.name = name;
          this.gender = gender;
      }
  
  
      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", gender=" + gender +
                  '}';
      }
  }
  
  public class Test {
      public static void main(String[] args) {
          // 枚举使用: 枚举名.枚举值
  
          // 创建Person对象
          Person p = new Person("张三", Gender.MAN);
          System.out.println("p:" + p);
  
          // 修改p对象的性别为妖
          p.gender = Gender.YAO;
          System.out.println("p:" + p);
      }
  }
  执行结果:
  p:Person{name='张三', gender=MAN}
  p:Person{name='张三', gender=YAO}
  ```

  



## 1.2 枚举中的其他内容( 听听就好)

- 枚举的本质是一个使用了多例设计模式的类，所以枚举中还可以有**成员变量，成员方法,构造方法等**。

- 枚举的本质是一个类，我们刚才定义的Sex枚举最终效果如下：

  ```java
  public enum Gender {
      // 枚举值
      MAN(10),WOMAN(20),YAO(30);
  
  
      // 成员变量
      int num;
  
      // 构造方法,必须私有化
      private Gender(int num){
          this.num = num;
      }
  
      // 成员方法
      public void method(){
          System.out.println("成员方法method...");
      }
  
  }
  
  public class Test {
      public static void main(String[] args) {
          // 定义一个Gender类型的变量g1,并赋值
          Gender g1 = Gender.MAN;
          System.out.println("num: "+g1.num);// num: 10
          g1.method();// 成员方法method...
      }
  }
  
  ```

  



# 第二章 工厂设计模式

## 2.1 工厂模式的概述

#### 工厂模式的介绍

​    工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式**属于创建型模式**，它提供了一种创建对象的最佳方式。之前我们创建类对象时, 都是使用new 对象的形式创建, 除new 对象方式以外, 工厂模式也可以创建对象.

耦合度: 类与类之间的关系,如果关系比较强,高耦合,  如果关系比较弱,低耦合(开发)

需求:  有10个类,需要在10个测试类中,分别创建这10个类的对象

以前: 直接通过new 来创建   --->每一个测试类都需要和这10个类进行关联--(耦合度高)

工厂模式: 定义一个工厂类,专门用来创建这10个类的对象, 并提供获取对象的方法,那这个时候测试类只需要跟工厂类关联即可---->  低耦合

#### 工厂模式的作用

将获取对象的代码与要创建对象的代码进行分开，获取对象的代码不需要直接创建对象，也就不需要关心创建对象时需要的数据。只需要通过工厂类获取对象即可。 	

- 解决类与类之间的耦合问题

#### 案例演示

##### 需求

1. 编写一个Car接口, 提供run方法
2. 编写一个Falali类实现Car接口,重写run方法
3. 编写一个Benchi类实现Car接口,重写run方法

   提供一个工厂类,可以用来生产汽车对象

##### 实现代码

1.编写一个Car接口, 提供run方法

```java
public interface Car {
    void run();
}

```

2.编写一个Falali类实现Car接口,重写run方法

```java
public class Falali implements Car {
    @Override
    public void run() {
        System.out.println("法拉利正在以300迈的速度行驶...");
    }
}
```

3.编写一个Benchi类实现Car接口

```java
public class Benchi implements Car {
    @Override
    public void run() {
        System.out.println("奔驰正在以200迈的速度行驶...");
    }
}

```

4.提供一个CarFactory(汽车工厂),用于生产汽车对象

```java
// 工厂类: 专门创建对象
public class CarFactory {

    /**
     * 创建汽车对象
     * @param brand 汽车品牌
     * @return 汽车对象
     */
    public static Car createCar(String brand){
        if (brand.equalsIgnoreCase("Falali")){
            // 创建法拉利汽车对象,并返回
            return new Falali();

        }else if (brand.equalsIgnoreCase("Benchi")){
            // 创建奔驰汽车对象,并返回
            return new Benchi();

        }else{
            return null;
        }

    }
}
```

5.定义CarFactoryTest测试汽车工厂

```java
public class Test {
    public static void main(String[] args) {
        // 不使用工厂设计模式--->得到法拉利对象,奔驰对象
        // Falali fl = new Falali();
        // Benchi bc = new Benchi();


        // 使用工厂设计模式--->得到法拉利对象,奔驰对象
        Car car1 = CarFactory.createCar("Falali");
        car1.run();

        Car car2 = CarFactory.createCar("Benchi");
        car2.run();

    }
}

```

# 第三章JDK8新特性

## 3.1 方法引用

#### 方法引用概述

- 方法引用使用一对冒号 **::** , 方法引用就是用来在一定的情况下,替换Lambda表达式

#### 方法引用基本使用

- 使用场景:
  - 如果一个Lambda表达式大括号中的代码和另一个方法中的代码一模一样,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
  - 如果一个Lambda表达式大括号中的代码就是调用另一方法,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式

```java
public class Test {

    public static void print(){
        System.out.println("执行代码...");
    }

    public static void main(String[] args) {
        /*
            - 如果一个Lambda表达式大括号中的代码和另一个方法中的代码一模一样,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
            - 如果一个Lambda表达式大括号中的代码就是调用另一方法,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式

         */
        // 创建线程并启动
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行代码...");
            }
        }).start();

        // Lambda表达式中的代码和Test类的print方法的方法体一模一样,所以可以直接把print方法引用过来替换Lambda表达式
        new Thread(()->{System.out.println("执行代码...");}).start();
        
        // Lambda表达式中的代码就是调用Test类的print方法,所以可以直接把print方法引用过来替换Lambda表达式
        new Thread(()->{Test.print();}).start();
        
        new Thread(Test::print).start();
    }
}

```



## 3.2 方法引用的分类

#### 构造方法引用

```java
public class Test1_构造方法引用 {
    public static void main(String[] args) {
        /*
            引入构造方法的格式: 类名::new
         */
        //创建集合
        ArrayList<String> list = new ArrayList<>();
        list.add("杨紫");
        list.add("迪丽热巴");
        list.add("陈钰琪");

        // 需求: 使用Stream流把集合中的元素转换为Person对象,打印输出
        //list.stream().map((String name)->{return new Person(name);}).forEach((Person p)->{System.out.println(p);});

        // map方法中的Lambda表达式大括号中的代码就是调用Person类的构造方法,符合方法引用的场景
        list.stream().map(Person::new).forEach((Person p)->{System.out.println(p);});



    }
}


```

#### 静态方法引用

```java
public class Test2_静态方法引用 {
    public static void main(String[] args) {
        /*
            引用静态方法的格式: 类名::方法名
         */
        //创建集合
        ArrayList<String> list = new ArrayList<>();
        list.add("110");
        list.add("111");
        list.add("112");

        // 需求: 使用Stream流把集合中的元素转换为int值,打印输出
        //list.stream().map((String str)->{return Integer.parseInt(str);}).forEach((Integer i)->{System.out.println(i+1);});

        // map方法中的Lambda表达式大括号中的代码就是调用Integer类的静态方法,符合方法引用的场景
        list.stream().map(Integer::parseInt).forEach((Integer i)->{System.out.println(i+1);});

    }
}


```

#### 有参数成员方法引用

- 成员方法有参数

  ```java
  public class Test3_成员方法有参数 {
      public static void main(String[] args) {
          /*
              成员方法有参数引用:  对象名::方法名
           */
          //创建集合
          ArrayList<String> list = new ArrayList<>();
          list.add("杨紫");
          list.add("迪丽热巴");
          list.add("陈钰琪");
  
          // 需求:使用Stream流把集合中所有元素打印输出
          /*list.stream().forEach((String name)->{
              System.out.println(name);
          });*/
          
          // forEach方法中Lambda表达式大括号中的代码其实就是调用System.out的println()方法,符合方法引用使用场景
          list.stream().forEach(System.out::println);
  
  
      }
  }
  
  ```

#### 没有参数成员方法引用

- 成员方法没有参数

  ```java
  public class Test4_成员方法没有参数 {
      public static void main(String[] args) {
          /*
              成员方法没有参数引用: 类名::方法名
           */
          //创建集合
          ArrayList<String> list = new ArrayList<>();
          list.add("杨紫");
          list.add("迪丽热巴");
          list.add("陈钰琪");
  
          // 需求: 使用Stream流把集合中的元素转换为该元素对应的字符长度,打印输出
          //list.stream().map((String name)->{return name.length();}).forEach(System.out::println);
  
          //  map方法中Lambda表达式大括号中的代码就是调用String类的length方法,符合方法引用的场景
          list.stream().map(String::length).forEach(System.out::println);
  
      }
  }
  
  ```

- 小结:

  ```java
  1.首先分析Lambda表达式大括号中代码(是否就是调用另一个方法\代码和另一个方法一模一样)
  2.如果是,就可以使用方法引用替换Lambda表达式
  3.确定引用的方法是什么类型(构造方法,静态方法,没有参数的成员方法,有参数的成员方法)
  4.根据方法引用的格式去应用方法
      构造方法: 类名::new
      静态方法: 类名::方法名
      没有参数的成员方法: 类名::方法名
      有参数的成员方法: 对象名::方法名
  ```

  

## 3.3 Base64   

#### Base64概述

- Base64是jdk8提出的一个新特性,可以用来进行按照一定规则编码和解码

#### Base64编码和解码的相关方法

- 编码的步骤:

  - 获取编码器
  - 调用方法进行编码

- 解码步骤:

  - 获取解码器
  - 调用方法进行解码

- Base64工具类提供了一套静态方法获取下面三种BASE64编解码器：

  - **基本：**输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
  - **URL：**输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
  - **MIME：**输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。

- 获取编码器和解码器的方法

  ```java
  static Base64.Decoder getDecoder() 基本型 base64 解码器。
  static Base64.Encoder getEncoder() 基本型 base64 编码器。
  
  static Base64.Decoder getMimeDecoder() Mime型 base64 解码器。
  static Base64.Encoder getMimeEncoder() Mime型 base64 编码器。
  
  static Base64.Decoder getUrlDecoder() Url型 base64 解码器。
  static Base64.Encoder getUrlEncoder() Url型 base64 编码器。
  ```

- 编码和解码的方法:

  ```java
  Encoder编码器:  encodeToString(byte[] bys)编码
  Decoder解码器:  decode(String str) 解码
  ```

#### 案例演示

- 基本

```java
public class Test1 {
    public static void main(String[] args) {
        // 使用基本型的编码器和解码器对数据进行编码和解码:
        // 1.获取编码器
        Base64.Encoder encoder = Base64.getEncoder();

        // 2.对字符串进行编码
        String str = "name=中国?password=123456";
        String str1 = encoder.encodeToString(str.getBytes());

        // 3.打印输出编码后的字符串
        System.out.println("编码后的字符串:"+str1);

        // 4.获取解码器
        Base64.Decoder decoder = Base64.getDecoder();

        // 5.对编码后的字符串进行解码
        byte[] bys = decoder.decode(str1);
        String str2 = new String(bys);

        // 6.打印输出解码后的字符串
        System.out.println("解码后的字符串:"+str2);
    }
}
```

- URL

```JAVA
public class Test2 {
    public static void main(String[] args) {

        // 使用URL型的编码器和解码器对数据进行编码和解码:
        // 1.获取编码器
        Base64.Encoder encoder = Base64.getUrlEncoder();

        // 2.对字符串进行编码
        String str = "name=中国?password=123456";
        String str1 = encoder.encodeToString(str.getBytes());

        // 3.打印输出编码后的字符串
        System.out.println("编码后的字符串:"+str1);

        // 4.获取解码器
        Base64.Decoder decoder = Base64.getUrlDecoder();

        // 5.对编码后的字符串进行解码
        byte[] bys = decoder.decode(str1);
        String str2 = new String(bys);

        // 6.打印输出解码后的字符串
        System.out.println("解码后的字符串:"+str2);
    }
}

```

- MIME

```java
public class Test3 {
    public static void main(String[] args) {
        // 使用MIME型的编码器和解码器对数据进行编码和解码:
        // 1.获取编码器
        Base64.Encoder encoder = Base64.getMimeEncoder();

        // 2.对字符串进行编码
        String str = "";
        for (int i = 0; i < 100; i++) {
            str += i;
        }
        System.out.println("编码前的字符串:"+str);

        String str1 = encoder.encodeToString(str.getBytes());

        // 3.打印输出编码后的字符串
        System.out.println("编码后的字符串:"+str1);

        // 4.获取解码器
        Base64.Decoder decoder = Base64.getMimeDecoder();

        // 5.对编码后的字符串进行解码
        byte[] bys = decoder.decode(str1);
        String str2 = new String(bys);

        // 6.打印输出解码后的字符串
        System.out.println("解码后的字符串:"+str2);
    }
}
```

# 第四章 正则表达式

## 4.1 正则表达式的概念及演示

- **概述**: 正则表达式其实就是一个**匹配规则,用来替换之前复杂的if结构判断**

- 在Java中，我们经常需要验证一些字符串，是否符合规则, 例如：校验qq号码是否正确,手机号码是否正确,邮箱是否正确等等。那么如果使用if就会很麻烦, 而正则表达式就是用来验证各种字符串的规则。它内部描述了一些规则，我们可以验证用户输入的字符串是否匹配这个规则。

- 先看一个不使用正则表达式验证的例子：下面的程序让用户输入一个QQ号码，我们要验证：

  - QQ号码必须是5--15位长度
  - 而且必须全部是数字
  - 而且首位不能为0

- 使用if判断方式验证:

  ```java
  public class Test {
      public static void main(String[] args) {
          System.out.println(checkQQ1("12345678"));// true
          System.out.println(checkQQ1("1234"));// false
          System.out.println(checkQQ1("1234a5678"));// false
          System.out.println(checkQQ1("02345678"));// false
      }
  
      public static boolean checkQQ1(String qq) {
          //- QQ号码必须是5--15位长度-->只要长度不是[5,15],就直接返回false结束方法
          if (qq.length() < 5 || qq.length() > 15) {
              return false;
          }
  
          //- 而且必须全部是数字-->只要有任何一位不是数字,就直接返回false结束方法
          for (int i = 0; i < qq.length(); i++) {
              char c = qq.charAt(i);
              if (c < '0' || c > '9'){
                  return false;
              }
          }
  
          //- 而且首位不能为0--->只要首位为0字符,就直接返回false结束方法
          if (qq.charAt(0) == '0'){
              return false;
          }
  
          return true;
      }
  
   
  }
  
  ```

  

- 使用正则表达式验证：

  - `public boolean matches(String regex); 判断此字符串是否匹配给定的正则表达式`

    ```java
    public class Test {
        public static void main(String[] args) {
            System.out.println(checkQQ2("12345678"));// true
            System.out.println(checkQQ2("1234"));// false
            System.out.println(checkQQ2("1234a5678"));// false
            System.out.println(checkQQ2("02345678"));// false
        }
    
        public static boolean checkQQ2(String qq){
            return qq.matches("[1-9]\\d{4,14}");
        }
    }
    
    ```

    

  

## 4.2 正则表达式的基本使用  

#### 4.2.1 正则表达式-字符类

- 语法示例：**[] 表示匹配单个字符   ^ 取反    - 范围**

  1. \[abc\]：代表a或者b，或者c字符中的一个。  

  2. \[^abc\]：代表除a,b,c以外的任何字符。 
  3. [a-z]：代表a-z的所有小写字符中的一个。 左右包含
  4. [A-Z]：代表A-Z的所有大写字符中的一个。
  5. [0-9]：代表0-9之间的某一个数字字符。
  6. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
  7. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。 

- 代码示例：

~~~java
public class Test1_字符类 {
    public static void main(String[] args) {
          /*
            正则表达式-字符类
                - 语法示例：[] 表示匹配单个字符   ^ 取反    - 范围
                  1. [abc]：代表a或者b，或者c字符中的一个。
                  2. [^abc]：代表除a,b,c以外的任何字符。
                  3. [a-z]：代表a-z的所有小写字符中的一个。 左右包含
                  4. [A-Z]：代表A-Z的所有大写字符中的一个。
                  5. [0-9]：代表0-9之间的某一个数字字符。
                  6. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
                  7. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。
         */
        // 需求:
        // 1.验证字符串是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
        System.out.println("had".matches("h[aeiou]d"));// true
        System.out.println("hbd".matches("h[aeiou]d"));// false
        System.out.println("h1d".matches("h[aeiou]d"));// false
        System.out.println("haa".matches("h[aeiou]d"));// false
        System.out.println("haod".matches("h[aeiou]d"));// false
        System.out.println("---------");

        // 2.验证字符串是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
        System.out.println("had".matches("h[^aeiou]d"));// false
        System.out.println("hbd".matches("h[^aeiou]d"));// true
        System.out.println("h1d".matches("h[^aeiou]d"));// true
        System.out.println("haa".matches("h[^aeiou]d"));// false
        System.out.println("haod".matches("h[^aeiou]d"));// false
        System.out.println("---------");

        // 3.验证字符串是否a-z的任何一个小写字符开头，后跟ad
        System.out.println("had".matches("[a-z]ad"));// true
        System.out.println("hbd".matches("[a-z]ad"));// false
        System.out.println("h1d".matches("[a-z]ad"));// false
        System.out.println("haa".matches("[a-z]ad"));// false
        System.out.println("haod".matches("[a-z]ad"));// false
        System.out.println("---------");

        // 4.验证字符串是否以a-d或者m-p之间某个字符开头，后跟ad
        System.out.println("aad".matches("[a-dm-p]ad"));// true
        System.out.println("had".matches("[a-dm-p]ad"));// false
        System.out.println("hbd".matches("[a-dm-p]ad"));// false
        System.out.println("h1d".matches("[a-dm-p]ad"));// false
        System.out.println("haa".matches("[a-dm-p]ad"));// false
        System.out.println("haod".matches("[a-dm-p]ad"));// false
        System.out.println("---------");
    }
}

~~~

#### 4.2.2 正则表达式-逻辑运算符

- 语法示例：
  1. &&：并且
  2. |    ：或者

- 代码示例：

~~~java
public class Test2_逻辑运算符 {
    public static void main(String[] args) {
          /*
            1. &&：并且
            2. | ：或者
         */
        // 需求:
        //1.要求字符串是小写辅音字符开头，后跟ad  除了a,e,i,o,u之外,其他的都是辅音字母
        System.out.println("bad".matches("[a-z&&[^aeiou]]ad"));// true
        System.out.println("aad".matches("[a-z&&[^aeiou]]ad"));// false
        System.out.println("4ad".matches("[a-z&&[^aeiou]]ad"));// false
        System.out.println("----------");

        //2.要求字符串是aeiou中的某个字符开头，后跟ad
        System.out.println("aad".matches("[a|e|i|o|u]ad"));// true
        System.out.println("bad".matches("[a|e|i|o|u]ad"));// false
        System.out.println("2ad".matches("[a|e|i|o|u]ad"));// false
    }
}

~~~



#### 4.2.3 正则表达式-预定义字符

- 语法示例：
  1. "." ： 匹配任何字符。如果要表示一个字符点,那么就得使用`\\.`
  2. "\d"：任何数字[0-9]的简写；
  3. "\D"：任何非数字\[^0-9\]的简写；
  4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写 
  5. "\S"： 非空白字符：\[^\s\] 的简写
  6. "\w"：单词字符：[a-zA-Z_0-9]的简写
  7. "\W"：非单词字符：\[^\w\]

- 代码示例：

~~~java
public class Test3_预定义字符 {
    public static void main(String[] args) {
        /*
            正则表达式-预定义字符
                - 语法示例：
                  1. "." ： 匹配任何字符。如果要表示一个字符点,那么就得使用\.
                  2. "\d"：任何数字[0-9]的简写；
                  3. "\D"：任何非数字[^0-9]的简写；
                  4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写
                  5. "\S"： 非空白字符：[^\s] 的简写
                  6. "\w"：单词字符：[a-zA-Z_0-9]的简写
                  7. "\W"：非单词字符：[^\w]
         */
        // 需求:
        // 1.验证字符串是否是3位数字
        System.out.println("123".matches("[1-9]\\d\\d"));// true
        System.out.println("023".matches("[1-9]\\d\\d"));// false
        System.out.println("a23".matches("[1-9]\\d\\d"));// false
        System.out.println("1234".matches("[1-9]\\d\\d"));// false
        System.out.println("--------");

        // 2.验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
        System.out.println("13868686668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// true
        System.out.println("17868686668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("27868686668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("1586868666".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("--------");

        // 3.验证字符串是否以h开头，以d结尾，中间是任何字符
        System.out.println("had".matches("h.d"));// true
        System.out.println("h%d".matches("h.d"));// true
        System.out.println("h.d".matches("h.d"));// true
        System.out.println("h d".matches("h.d"));// true
        System.out.println("hd".matches("h.d"));// false
        System.out.println("--------");


        // 4.验证str是否是：h.d
        System.out.println("had".matches("h\\.d"));// false
        System.out.println("h%d".matches("h\\.d"));// false
        System.out.println("h.d".matches("h\\.d"));// true
        System.out.println("h d".matches("h\\.d"));// false
        System.out.println("hd".matches("h\\.d"));// false
        System.out.println("--------");
    }
}

~~~

#### 4.2.4 正则表达式-数量词

- 语法示例：
  1. X? : 0次或1次
  2. X* : 0次到多次
  3. X+ : 1次或多次
  4. X{n} : 恰好n次
  5. X{n,} : 至少n次,包含n
  6. X{n,m}: n到m次(n和m都是包含的)

- 代码示例：

~~~java
public class Test4_数量词 {
    public static void main(String[] args) {
         /*
            正则表达式-数量词
            - 语法示例：
              1. X? : 0次或1次
              2. X* : 0次到多次
              3. X+ : 1次或多次
              4. X{n} : 恰好n次
              5. X{n,} : 至少n次
              6. X{n,m}: n到m次(n和m都是包含的)
         */
        // 需求:
        // 1.验证字符串是否是3位数字
        System.out.println("123".matches("[1-9]\\d{2}"));// true
        System.out.println("023".matches("[1-9]\\d{2}"));// false
        System.out.println("a23".matches("[1-9]\\d{2}"));// false
        System.out.println("1234".matches("[1-9]\\d{2}"));// false
        System.out.println("--------");

        // 2.验证str是否是多位数字
        System.out.println("123".matches("[1-9]\\d*"));// true
        System.out.println("023".matches("[1-9]\\d*"));// false
        System.out.println("a23".matches("[1-9]\\d*"));// false
        System.out.println("1234".matches("[1-9]\\d*"));// true
        System.out.println("--------");

        // 3.验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
        System.out.println("13868686668".matches("1[358]\\d{9}"));// true
        System.out.println("17868686668".matches("1[358]\\d{9}"));// false
        System.out.println("27868686668".matches("1[358]\\d{9}"));// false
        System.out.println("1586868666".matches("1[358]\\d{9}"));// false
        System.out.println("--------");

        // 4.验证qq号码：1).5--15位；2).全部是数字;3).第一位不是0

        System.out.println("12345678".matches("[1-9]\\d{4,14}"));// true
        System.out.println("1234".matches("[1-9]\\d{4,14}"));// false
        System.out.println("1234a5678".matches("[1-9]\\d{4,14}"));// false
        System.out.println("02345678".matches("[1-9]\\d{4,14}"));// false
    }
}

~~~

#### 4.2.5 正则表达式-分组括号( )

~~~java
public class Test5_分组括号 {
    public static void main(String[] args) {
          /*
            分组括号: ()
            使用:格式相同的就分为一组
         */
        String str = "DG8FV-B9TKY-FRT9J-99899-XPQ4G";
        System.out.println(str.matches("([A-Z0-9]{5}-){4}[A-Z0-9]{5}"));// true

        // 叠词aabb格式: 高高兴兴,快快乐乐,开开心心...
        // \\1表示第一组  \\2表示第二组
        System.out.println("高高兴兴".matches("(.)\\1(.)\\2"));// true
        System.out.println("分组括号".matches("(.)\\1(.)\\2"));// false

        // 叠词aabbcc格式: 呵呵哈哈嘿嘿,...
        System.out.println("呵呵哈哈嘿嘿".matches("(.)\\1(.)\\2(.)\\3"));// true
        System.out.println("分组括号相同".matches("(.)\\1(.)\\2(.)\\3"));// false

        // 叠词abab格式: 开心开心,高兴高兴,哟西哟西,...
        System.out.println("开心开心".matches("(..)\\1"));// true
        System.out.println("高高兴兴".matches("(..)\\1"));// false
        System.out.println("分组括号".matches("(..)\\1"));// false
    }
}

~~~



## 4.3 String中正则表达式的使用

#### 4.3.1 String的split方法中使用正则表达式

- String类的split()方法原型：

  ```java
  public String[] split(String regex)//参数regex就是一个正则表达式。可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
  ```

- 代码示例：

  ```java
  public class Test1_split {
      public static void main(String[] args) {
        String str1 = "itheima-itcast-java-php";
          String[] arr1 = str1.split("-");// 就是一个字符串-
          for (String s : arr1) {
              System.out.println("s:"+s);
          }
  
          System.out.println("-----------");
  
          String str2 = "itheima.itcast.java.php";
          String[] arr2 = str2.split("\\.");
          for (String s : arr2) {
              System.out.println("s:"+s);
          }
      }
  }
  
  ```

  

#### 4.3.2 String类的replaceAll方法中使用正则表达式

- String类的replaceAll()方法原型：

~~~java
public String replaceAll(String regex,String newStr)//参数regex就是一个正则表达式。可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。
~~~

- 代码示例：

  ```java
  public class Test2_replaceAll {
      public static void main(String[] args) {
        String message = "我草,你他妈的,我靠,你妹的,我日";
          String msg = message.replaceAll("草|他妈的|靠|妹的|日", "***");
          System.out.println("msg:" + msg);
  
      }
  }
  
  ```

# 第五章 Junit单元测试

## 5.1 Junit单元测试

#### Junit的概念

- 概述 : Junit是Java语言编写的第三方单元测试框架(工具类)
- 作用 : 用来做“单元测试”——针对某个普通方法，可以像main()方法一样独立运行，它专门用于测试某个方法。

#### Junit的使用步骤

- 1.在模块下创建lib文件夹,把Junit的jar包复制到lib文件夹中

- 2.选中Junit的jar包,右键选中 add as Library,把JUnit4的jar包添加到classPath中

- 3.在测试方法上面写上@Test注解

- 4.执行测试方法 

  ```java
  public class Demo1 {
  
      @Test
      public void show1(){
          System.out.println("show1方法执行...");
      }
  
      @Test
      public void show2(){
          System.out.println("show2方法执行...");
      }
  }
  ```

#### 执行测试方法

- 1.选中方法名--->右键--->选中执行             只执行选中的测试方法
- 2.选中类名----->右键--->选中执行             执行该类中所有的测试方法
- 3.选中模块---- ->右键--->选中all tests 执行   执行该模块中所有的测试方法 

- 如何查看测试结果
  * 绿色：表示测试通过
  * 红色：表示测试失败，有问题



## 5.2 Junit单元测试的注意事项

- 1.测试方法的权限修饰符一定是public
- 2.测试方法的返回值类型一定是void
- 3.测试方法一定没有参数
- 4.测试方法 的声明之上一定要使用@Test注解



## 5.3 Junit其他注解

* @Before：用来修饰方法，该方法会在每一个测试方法执行之前执行一次。
* @After：用来修饰方法，该方法会在每一个测试方法执行之后执行一次。
* @BeforeClass：用来修饰静态方法，该方法会在所有测试方法之前执行一次，而且只执行一次。
* @AfterClass：用来修饰静态方法，该方法会在所有测试方法之后执行一次，而且只执行一次。

```java
public class Demo2_其他注解 {
    /*
        - @Before：用来修饰方法，该方法会在每一个测试方法执行之前执行一次。
        - @After：用来修饰方法，该方法会在每一个测试方法执行之后执行一次。
        - @BeforeClass：用来修饰静态方法，该方法会在所有测试方法之前执行一次，而且只执行一次。
        - @AfterClass：用来修饰静态方法，该方法会在所有测试方法之后执行一次，而且只执行一次。
     */
    @BeforeClass
    public static void bc(){
        System.out.println("bc方法执行了");
    }


    @Before
    public void b1(){
        System.out.println("b1方法执行了");
    }

    @Test
    public void test1(){
        System.out.println("test1方法执行了");
    }

    @Test
    public void test2(){
        System.out.println("test2方法执行了");
    }

    @After
    public void a1(){
        System.out.println("a1方法执行了");
    }

    @AfterClass
    public static void ac(){
        System.out.println("ac方法执行了");
    }

}

```





# 总结

```java
必须练习:
	1.单例设计模式
    2.多例设计模式
    3.定义和使用枚举
    4.工厂设计模式
    5.有时间的话分析分析正则表达式,写点简单的正则表达---目的是为了能看懂正则表达式
      String类中使用正则表达式--->matches,split,replaceAll
        
- 能够说出单例设计模式的好处
  保证使用该模式设计的类只有1个对象产生
  步骤:
	1.将构造方法私有化
    2.在类的内部创建该类的唯一对象
    3.提供公共静态方法用来获取该类的唯一对象
        
- 能够说出多例模式的好处
  保证使用该模式设计的类只有固定数量对象产生
  步骤:
	1.将构造方法私有化
    2.在类的内部创建该类固定数量的对象
    3.提供公共静态方法用来获取该类中创建的任意对象 
        
- 能够定义枚举
  格式:
		public enum 枚举名{
            枚举值,枚举值,...
        }
  使用: 枚举名.枚举值
      
- 能够使用工厂模式编写java程序
   定义一个类,提供一个静态方法,在静态方法中创建类的对象并返回
 
 - 能够理解正则表达式的作用
    作为匹配规则,替换复杂的if判断操作
        
- 能够使用正则表达式的字符类
   [] 表示匹配单个字符,^表示取反,-表示范围
    	1. [abc]：代表a或者b，或者c字符中的一个。
        2. [^abc]：代表除a,b,c以外的任何字符。
        3. [a-z]：代表a-z的所有小写字符中的一个。 左右包含
        4. [A-Z]：代表A-Z的所有大写字符中的一个。
        5. [0-9]：代表0-9之间的某一个数字字符。
        6. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
        7. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。     
- 能够使用正则表达式的逻辑运算符
   && 并且
   |  或者
        
- 能够使用正则表达式的预定义字符类
   		1. "." ： 匹配任何字符。如果要表示一个字符点,那么就得使用\.
        2. "\d"：任何数字[0-9]的简写；
        3. "\D"：任何非数字[^0-9]的简写；
        4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写
        5. "\S"： 非空白字符：[^\s] 的简写
        6. "\w"：单词字符：[a-zA-Z_0-9]的简写
        7. "\W"：非单词字符：[^\w]
        
- 能够使用正则表达式的数量词
   		1. X? : 0次或1次
        2. X* : 0次到多次
        3. X+ : 1次或多次
        4. X{n} : 恰好n次
        5. X{n,} : 至少n次
        6. X{n,m}: n到m次(n和m都是包含的)  
        
- 能够使用正则表达式的分组
     ()
- 能够在String的split方法中使用正则表达式
   String[] split(String regex);
   boolean matches(String regex);
   String replaceAll(String regex,String newStr)
```

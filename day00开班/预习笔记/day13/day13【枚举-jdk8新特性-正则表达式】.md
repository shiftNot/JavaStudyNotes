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

# 第四章 枚举

## 知识点--概述与引入

### 目标

理解枚举的定义与使用

### 路径

- 介绍
- 作用
- 应用场景
- 定义格式
- 使用格式


### 讲解

#### 4.1.1 介绍

枚举即列举，本质是一个类，用于列举属于该事物有限分类。例如:性别，方向，季度等

#### 4.1.2 作用

一个类，拥有固定的对象个数，可以利用枚举定义，并通过枚举的格式列举所有对象方便使用。

#### 4.1.3  应用场景

swtich语句、方法参数。

#### 4.1.4 定义格式

```java
public enum 枚举名 {
    //枚举值,枚举值,...; //枚举值要求在第一行，一般全大写，如果有多个字符使用下划线分割。
    //成员变量
    //构造方法
    //成员方法
}
```

#### 4.1.5使用格式

```java
枚举名.枚举值
```



需求:使用字符串演示根据红绿灯决定操作的过程，及可能产生的问题。

```java

enum Light {
    RED, YELLOW, GREEN;
}

public class Test_01枚举入门 {
    public static void main(String[] args) {
        //method1("荭");
        //使用枚举改进
        method2(Light.RED);


    }

    public static void method2(Light light) {
        switch (light) {
            case RED:
                System.out.println("红灯停");
                break;
            case YELLOW:
                System.out.println("黄灯停");
                break;
            case GREEN:
                System.out.println("绿灯停");
                break;
            default:
                System.out.println("啥也不是");
        }
    }

    public static void method1(String light) {
        switch (light) {
            case "红":
                System.out.println("红灯停");
                break;
            case "黄":
                System.out.println("黄灯停");
                break;
            case "绿":
                System.out.println("绿灯停");
                break;
            default:
                System.out.println("啥也不是");
        }
    }

}
```


### 小结

```

```

## 知识点--枚举类本质

### 目标

理解枚举的原理

### 路径

- 枚举的本质
- 演示枚举本质

#### 4.2.1 枚举的本质

枚举的本质就是一个类，同样可以拥有类中其他成员内容(构造方法、成员方法)。

枚举中每个枚举值的定义，本质是一个静态常量，代表该事物的一个对象或分类。

每个枚举值必须在类中的第一行定义，否则编译报错。

#### 4.2.2 演示枚举本质

需求:通过枚举和类分别演示对于性别枚举定义。

```java
public class Test_02枚举的本质 {
    public static void main(String[] args) {
        System.out.println(Sex.BOY);
        Sex.BOY.method();
        System.out.println(Sex2.BOY);
        Sex2.BOY.method();
    }
}
```

```java
enum Sex {
    BOY("男孩"), GIRL("女孩");
    private String title;

    private Sex(String title) {
        this.title = title;
    }

    public  void method() {
        System.out.println("method......");
    }

    @Override
    public String toString() {
        return "Sex{" +
                "title='" + title + '\'' +
                '}';
    }
}
```

```java
// 枚举的本质是一个类，我们刚才定义的Sex枚举相当于下面的类
public class Sex implements Enumeration {

    public static final Sex GIRL = new Sex("BOY");
    public static final Sex BOY = new Sex("GIRL");
    
    private String title;

    private Sex(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean hasMoreElements() {
        return false;
    }

    @Override
    public Object nextElement() {
        return null;
    }
}
```


### 小结

```

```



## 知识点--枚举实现单例

### 目标

了解枚举实现单例

### 路径

- 概述
- 演示枚举实现单例

### 讲解

#### 4.3.1 概述

- 枚举实现单例设计模式能避免多线程同步问题，自动支持序列化机制，防止反序列化创建新的对象，绝对防止多次实例化。
- Effective Java的作者Josh Bloch提倡的使用方式.

#### 4.3.2 演示枚举实现单例设计模式

需求:演示单例设计模式枚举的定义与使用

//枚举单例设计模式

```java
 public  class Test_03枚举实现单例 {
    public static void main(String[] args) {
        SingletonDemo s1 = SingletonDemo.ONE;
        SingletonDemo s2 = SingletonDemo.ONE;
        System.out.println(s1==s2);
    }
}

enum  SingletonDemo{
     ONE;
}
```

//测试类

```

```



### 小结

```

```

# 第五章JDK8新特性

## 知识点 5.1 概述

### 目标

了解JDK8中有哪些常见新特新

### 路径

- 新特性介绍

### 讲解

#### 5.1.1概述

在JDK8中更新了很多新特性，较为常见的有意向内容。

Lambda表达式【已学习过】、默认方法【已学习过】、Stream  【已学习过】、方法引用、Base64。

### 小结

```

```

## 知识点 5.2 方法引用

### 目标

学会使用方法引用

### 路径

- 概述
- 入门体验
- 方法引用的使用
- 演示方法引用的使用

### 讲解

#### 5.2.1概述

​		方法引用是一种用方法替代Lambda的方式，需要和Lambda表达式配合使用。

​		编写Lambda表达式时，要做的事情(方法逻辑、构造方法、实例化对象)已有方法完成，就可以直接引用已有方法，不用再写Lambda表达式。

​		方法引用使得java类的代码看起来紧凑而简洁，避免很多复杂的重复代码。

#### 5.2.2方法引用的入门体验

```java
public class Demo {
    public static void main(String[] args) {
        //Lambda实现多线程
        new Thread(() -> {
            System.out.println("线程运行");
        }).start();
        //方法引用
        new Thread(Demo::show).start();
    }

    public static void show() {
        System.out.println("线程运行");
    }
}
```

#### 5.2.3方法引用应用场景

①构造器引用：语法是Class::new或Class<T>::new。
②静态方法引用：语法是Class::static_method。
③特定类的任意对象的方法引用：语法是Class::method
④特定对象的方法引用：语法是instance::method		

#### 5.1.4演示方法引用的使用

需求:演示方法引用的使用。

//测试类代码

```java
public class Test_01方法引用 {
    public static void main(String[] args) {
        //应用场景
        // method1();
        //语法
        method2();

    }

    public static void method2() {
        //①构造器引用：语法是Class::new或Class<T>::new。
        Car car = Car.create(Car::new);
        //②静态方法引用：语法是Class::static_method。
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        //③特定类的任意对象的方法引用：语法是Class::method
        cars.forEach(Car::repair);
        //④特定对象的方法引用：语法是instance::method
        cars.forEach(car::follow);
    }

    public static void method1() {
        new Thread(() -> {
            System.out.println("输出内容");
        }).start();
        new Thread(Test_01方法引用::print);
    }

    public static void print() {
        System.out.println("输出内容");
    }
}
```

//汽车类

```java
class Car {
    //Supplier是jdk1.8的接口，这里和lambda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
```



### 小结

```

```

## 知识点 5.2 Base64

### 目标

理解Base64加密

### 路径

- Base64概述
- Base64内嵌类和方法描述
- 演示Base64编解码的使用

### 讲解

#### 5.3.1概述

Java8中，Base64编码成为Java类库的标准库,内置了 Base64 编码的编码器和解码器。

Base64是网络上最常见的用于传输8Bit字1，Base64工具类提供了一套静态方法获取下面三种BASE64编解码器。 

```
Basic：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
URL：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
MIME：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。
```

Base64中有两个内嵌类，分别是Encode(编码)和Decoder(解码)，通过获取这两个类的子类对象，进行对应的编码和解码操作。

编码和解码操作需要保持对应，怎么样编码，就需要怎么样解码。

#### 5.3.2Base64API介绍

 `static class Base64.Encode`编码器:使用 Base64 算法来编码字节数据

```
获取编码器对象
	static Base64.Encoder getEncoder()返回一个基本型base64算法的Encoder对象
	static Base64.Encoder getMimeEncoder()返回一个MIME型base64算法的Encoder对象
	static Base64.Encoder getMimeEncoder(int lineLength,byte[] lineSeparator)返回一个(指定行长度和行分隔符)MIME型base64算法的Encoder对象
	static Base64.Encoder getUrlEncoder()返回一个URL和文件名安全型base64算法的Encoder对象
编码方法:
	String encodeToString(byte[] src) 将字节内容编码，得到一个字符串数据
	其他有兴趣自学
```

`static class Base64.Decoder`解码器:使用 Base64 算法来解码字节数据。

```
获取解码器对象
	static Base64.Decoder getDecoder()返回一个基本型base64算法的Decoder对象
	static Base64.Decoder getMimeDecoder()返回一个MIME型base64算法的Decoder对象
	static Base64.Decoder getUrlDecoder()返回一个URL和文件名安全型base64算法的Decoder对象
解码方法
	byte[] decode(String src) 将字节内容解码，得到一个字符串数据
	其他有兴趣自学
```

> **注意：**Base64 类的很多方法从 **java.lang.Object** 类继承。

#### 5.3.3演示Base64编解码的使用

需求:分别使用"itheima?中国"、"itheima?java"、"123...100"演示三种编解码。

```java
public class Test {
    public static void main(String[] args) {
        //基本编解码
        Base64.Encoder enco1 = Base64.getEncoder();
        String enco1Str = enco1.encodeToString("itheima?中国".getBytes());
        System.out.println(enco1Str);
        Base64.Decoder deco1 = Base64.getDecoder();
        byte[] decoBys1 = deco1.decode(enco1Str.getBytes());
        System.out.println(new String(decoBys1, 0, decoBys1.length));
        System.out.println("--------");
        //URL编解码
        Base64.Encoder enco2 = Base64.getUrlEncoder();
        String enco2Str = enco2.encodeToString("itheima?java".getBytes());
        System.out.println(enco2Str);
        Base64.Decoder deco2 = Base64.getUrlDecoder();
        byte[] deco2Bys = deco2.decode(enco2Str);
        System.out.println(new String(deco2Bys, 0, deco2Bys.length));
        System.out.println("--------");
        //MIME编解码
        Base64.Encoder enco3 = Base64.getMimeEncoder();
        String s = "";
        for (int i = 1; i <= 100; i++) {
            s += i;
        }
        String enco3Str = enco3.encodeToString(s.getBytes());
        System.out.println(enco3Str);
        Base64.Decoder deco3 = Base64.getMimeDecoder();
        byte[] deco3Bys = deco3.decode(enco3Str);
        System.out.println(new String(deco3Bys, 0, deco3Bys.length));
    }
}
```

### 小结

```

```

#   第六章 正则表达式

## 知识点--理解及演示

### 目标

- 理解正则表达式的作用

### 路径

- 概述
- 演示正则表达式

### 讲解

#### 6.1.1概述

在Java中，有时需求对字符串进行一些格式上的验证, 如果使用多层if语句判断会非常复杂且。

正则表达式内部描述了用来验证各种字符串的规则，用来验证指定的字符串是否匹配某个规则。

例如：年龄必须是2位的数字、用户名必须是8位长度而且只能包含大小写字母、数字等。

#### 6.1.2演示正则表达式

需求:分别使用if语句和正在表达式，对用户输入一个QQ号码做验证操作。要求同时符合一下三个规则才算通过验证。

```
规则1:QQ号码必须是5--15位长度
规则2:而且必须全部是数字
规则3:而且首位不能为0
```

//测试类代码

~~~java
public class Test_01正则入门 {
    public static void main(String[] args) {
        System.out.println("输入字符串");
        String qq = new Scanner(System.in).nextLine();
        //普通方式验证
        System.out.println(checkQQ(qq));
        //正则表达式验证
        System.out.println(checkQQ2(qq));
    }
    //普通方式验证
    public static boolean checkQQ(String qq) {
        if (qq.length() < 5 || qq.length() > 15)
            return false;
        if (qq.charAt(0) == '0')
            return false;
        for (int i = 0; i < qq.length(); i++) {
            if (qq.charAt(i) < '0' || qq.charAt(i) > '9')
                return false;
        }

        return true;
    }
    //正则表达式验证
    public static boolean checkQQ2(String qq) {
        return qq.matches("[1-9]\\d(4-14)");
    }
}
~~~

> 使用正则，需要先定义String类型的变量regex存储了一个"正则表达式 "，这个正则表达式用来描述将要匹配的规则。
>
> matches()方法是String类的一个方法，用于接收一个正则表达式，并将"本对象"与参数"正则表达式"进行匹配。
>
> 如果本对象符合正则表达式的规则，则返回true，否则返回false。

### 小结

```

```

## 知识点--基本使用规则 

### 目标

- 学会定义正则表达式


### 路径

- 字符类
- 演示字符类在正则表达式中的使用
- 逻辑运算符
- 演示逻辑运算符在正则表达式中的使用
- 预定义字符
- 演示预定义字符在正则表达式中的使用
- 数量词
- 演示数量词在正则表达式中的使用
- 分组
- 演示分组在正则表达式中的使用

### 讲解

#### 6.2.1 字符类

1. [abc]：代表a或者b，或者c字符中的一个。

 2. [^abc]：代表除a,b,c以外的任何字符。
 3. [a-z]：代表a-z的所有小写字符中的一个。
 4. [A-Z]：代表A-Z的所有大写字符中的一个。
 5. [0-9]：代表0-9之间的某一个数字字符。
 6. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
 7. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。 

#### 6.2.2 演示字符类在正则表达式中的使用

需求:按照如下要求，使用正则表达式，完成字符串内容的验证。

```
1. 验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
2. 验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
3. 验证str是否a-z的任何一个小写字符开头，后跟ad
4. 验证str是否以a-d或者m-p之间某个字符开头，后跟ad
```

//测试类代码

~~~java
public class Demo {
	public static void main(String[] args) {
        String str = "ead";
        String regex = "";

        //1. 验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
        regex = "h[aeiou]d";
        System.out.println(str.matches(regex));
        //2. 验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
        regex = "h[^aeiou]d";
        System.out.println(str.matches(regex));
        //3. 验证str是否a-z的任何一个小写字符开头，后跟ad
        regex = "[a-z]ad";
        System.out.println(str.matches(regex));
        //4. 验证str是否以a-d或者m-p之间某个字符开头，后跟ad
        regex = "[a-dm-p]ad";
        System.out.println(str.matches(regex));
	}
}

~~~

#### 6.2.3 正则表达式-逻辑运算符

1. &&：并且
2. |    ：或者

#### 6.2.4 演示逻辑运算符在正则表达式中的使用

需求:按照如下要求，使用正则表达式，完成字符串内容的验证。

```
1. 验证字符串是小写辅音字符开头，后跟ad  除了a,e,i,o,u之外,其他的都是辅音字母
2. 验证字符串是aeiou中的某个字符开头，后跟ad
```

//测试类代码

~~~java
public class Demo {
	public static void main(String[] args) {
        String str = "had";
        String regex = "";

        //1. 验证字符串是小写辅音(非a,e,i,o,u)字符开头，后跟ad。
        regex = "[[a-z]&&[^aeiou]]ad";//"[a-z&&[^aeiou]]ad"
        System.out.println(str.matches(regex));
        //2. 验证字符串是aeiou中的某个字符开头，后跟ad。
        regex = "[a|e|i|o|u]ad";//这里的|可以不加
        System.out.println(str.matches(regex));
	}
}
~~~

#### 6.2.5 正则表达式-预定义字符

1. "." ： 匹配任何字符。如果要表示一个字符点,那么就得使用\\.
2. "\d"：任何数字[0-9]的简写；
3. "\D"：任何非数字\[^0-9\]的简写；
4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写
5. "\S"： 非空白字符：\[^\s\] 的简写
6. "\w"：单词字符：[a-zA-Z_0-9]的简写
7. "\W"：非单词字符：\[^\w\]

#### 6.2.6 演示预定义字符在正则表达式中的使用

需求:按照如下要求，使用正则表达式，完成字符串内容的验证。

```
1. 验证str是否3位数字
2. 验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
3. 验证字符串是否以h开头，以d结尾，中间是任何字符
4. 验证str是否是：had.
```

//测试类代码

~~~java
public class Demo {
	public static void main(String[] args) {
        String str = "";
        String regex = "";

        //1. 验证str是否3位数字
        str = "258";
        regex = "\\d\\d\\d";
        System.out.println(str.matches(regex));
        //2. 验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
        str = "13513153355";
        regex = "1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d";
        System.out.println(str.matches(regex));
        //3. 验证字符串是否以h开头，以d结尾，中间是任何字符
        str = "had";
        regex = "h.d";
        System.out.println(str.matches(regex));
        //4. 验证str是否是：had.。.代表'.'符号，因为.在正则中被预定义为"任意字符"，不能直接使用
        str = "had.";
        regex = "had\\.";
        System.out.println(str.matches(regex));
		
	}
}
~~~

#### 6.2.7 正则表达式-数量词

1. X? : 0次或1次
2. X* : 0次到多次
3. X+ : 1次或多次
4. X{n} : 恰好n次
5. X{n,} : 至少n次
6. X{n,m}: n到m次(n和m都是包含的)

#### 6.2.8 演示数量词在正则表达式中的使用

需求:按照如下要求，使用正则表达式，完成字符串内容的验证。

```
1. 验证str是否是三位数字
2. 验证str是否是多位数字
3. 验证str是否是手机号
```

//测试类代码

~~~java
public class Demo {
	public static void main(String[] args) {
        String str = "";
        String regex = "";

        //1. 验证str是否是三位数字
        str = "012";
        regex = "\\d{3}";
        System.out.println(str.matches(regex));
        //2. 验证str是否是多位数字
        str = "88932054782342";
        regex = "\\d+";
        System.out.println(str.matches(regex));
        //3. 验证str是否是手机号
        str = "13813183388";
        regex = "1[358]\\d{9}";
        System.out.println(str.matches(regex));
	}
}

~~~

#### 6.2.9 正则表达式-分组

():将一系列操作作为一个整体来理解。

#### 6.2.10 演示分组在正则表达式中的使用

需求:按照如下要求，使用正则表达式，完成字符串内容的验证。

```
1.使用正则表达式，完成"DG8FV-B9TKY-FRT9J-99899-XPQ4G"序列号字符串内容的验证
2. 验证小数：要求匹配：3、3.0、3.14、+3.14、-3.0   
```

//测试类代码

~~~java
public class Demo {
	public static void main(String[] args) {
		String str = "";
        String regex = "";

        //1.使用正则表达式，完成"DG8FV-B9TKY-FRT9J-99899-XPQ4G"序列号字符串内容的验证
        str = "DG8FV-B9TKY-FRT9J-99899-XPQ4G";
        regex = "([A-Z0-9]{5}-){4}[A-Z0-9]{5}";
        System.out.println(str.matches(regex));
        
        //2. 验证小数：要求匹配：3、3.0、3.14、+3.14、-3.0
        str = "-0.3";
        regex = "[+-]?\\d+(([\\.]{0})|([\\.]{1}\\d))";
        System.out.println(str.matches(regex));
	}
}

~~~

### 小结

```

```



## 知识点--String类中的应用

### 目标

- 掌握String类中两个还有正则表达式方法的使用


### 路径

- String中含正则表达式的方法
- 演示split方法的使用
- 演示replaceAll方法的使用

### 讲解

#### 6.3.1 String中含正则表达式的方法

```java
public String[] split(String regex)//将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
public String replaceAll(String regex,String newStr)//将当前字符串中匹配regex正则表达式的字符串替换为newStr。
```

#### 6.3.2演示split方法的使用

需求:使用String中的split方法，将字符串"18  4 567       99     56""以间隔进行分割

//测试类代码

~~~java
public class SplitDemoTest {
    public static void main(String[] args) {
        //定义要切割的字符串
        String str = "18  4 567       99     56";
        //定义要切割的规则
        String regex = " +";
        //执行字符串的切割操作
        System.out.println(str.split(regex).length);
        System.out.println("=======================");
    }
}
~~~

#### 6.3.2演示replaceAll方法的使用

需求:使用String中的split方法，将"jfdk432jfdk2jk24354j47jk5l31324"中的数字使用*进行替换

//测试类代码

~~~java
public class ReplaceAllDemoTest {
    public static void main(String[] args) {

        //定义要进行替换的字符串
        String str2 = "jfdk432jfdk2jk24354j47jk5l31324";
        //定义要替换的规则
        String regex2 = "\\d+";
        //将符合规则的内容替换为星号
        System.out.println(str2.replaceAll(regex2, "*"));
    }
}
~~~

### 小结 
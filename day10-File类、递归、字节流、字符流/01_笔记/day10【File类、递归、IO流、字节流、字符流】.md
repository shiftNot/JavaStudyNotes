

# day10【File类、递归、IO流、字节流、字符流】

## 今日内容

- File类---------->重点掌握

  - 概述
  - 构造方法
  - 成员方法

- 递归---------->重点掌握

  - 递归的概述
  - 递归的使用
    - 什么时候递归
    - 什么时候结束递归

- IO流的概述和分类

  - 概述
  - 分类

- 字节流---------->重点掌握

  - 字节输入流:  读字节数据
  - 字节输出流:  写字节数据

- 字符流---------->重点掌握

  - 字符输入流: 读字符数据
  - 字符输出流: 写字符数据
  
  

# 第一章 File类

## 1.1 File类的概述和构造方法

#### File类的概述

`java.io.File` 类是用来表示文件或者文件夹路径，可以用于对文件和文件夹的创建、查找和删除等操作。

#### File类的构造方法

- `public File(String pathname) ` ：通过将给定的**路径名字符串**转换为抽象路径名来创建新的 File实例。  
- `public File(String parent, String child) ` ：从**父路径名字符串和子路径名字符串**创建新的 File实例。
- `public File(File parent, String child)` ：从**父抽象路径名和子路径名字符串**创建新的 File实例。  
- 注意: 
  - **创建File对象时,如果传入的文件或者文件夹路径不存在,依然不影响File对象的创建**


- 构造举例，代码如下：

  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 8:42
   */
  public class Test {
      public static void main(String[] args) {
          //- public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
          File f1 = new File("G:\\szitheima117\\day10\\aaa\\a.txt");// 表示文件路径
          File f2 = new File("G:\\szitheima117\\day10\\aaa");// 表示文件夹路径
          System.out.println("f1:" + f1);
          System.out.println("f2:" + f2);
  
          //- public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
          File f3 = new File("G:\\szitheima117\\day10\\aaa","a.txt");
          System.out.println("f3:"+f3);
  
          //- public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
          File f4 = new File(f2,"a.txt");
          System.out.println("f4:"+f4);
  
          //- 注意: 创建File对象时,如果传入的文件或者文件夹路径不存在,依然不影响File对象的创建
          File f5 = new File("G:\\szitheima117\\day10\\aaa\\b.txt");
          System.out.println("f5:"+f5);
      }
  }
  
  ```
  
  

## 1.2 File类常用方法

#### 绝对路径和相对路径

- **绝对路径**：从盘符开始的路径，这是一个完整的路径。

- **相对路径**：**相对于项目目录的路径**，这是一个便捷的路径，**开发中经常使用**。

- 案例:

  - 例如:  你在中粮商务公园2栋608教室,你对象在中粮商务公园楼下,对象问你在哪?
    - 绝对路径:中国广东省深圳市宝安区留仙二路中粮商务公园2栋608教室
    - 相对路径: 2栋608教室
  - 程序中例如:
    - 绝对路径: G:\szitheima117\day10\aaa\a.txt
    - 相对路径: day10\aaa\a.txt
  
  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 8:57
   */
  public class Test {
      public static void main(String[] args) {
          // 创建一个File对象表示aaa\a.txt文件的路径
          // 绝对路径
          File f1 = new File("G:\\szitheima117\\day10\\aaa\\a.txt");
          // 相对路径
          File f2 = new File("day10\\aaa\\a.txt");
      }
  }
  
  ```



#### 获取功能的方法

- `public String getAbsolutePath() ` ：返回此File的绝对路径名字符串。

- ` public String getPath() ` ：将此File转换为路径名字符串。 **构造路径**

- `public String getName()`  ：返回由此File表示的文件或目录的名称。  

- `public long length()`  ：返回由此File表示的文件的长度。 **不能获取目录的长度。**

  方法演示，代码如下：

  ```java
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 9:02
   */
  public class Test1_获取功能的方法 {
      public static void main(String[] args) {
          // 创建File对象
          File f1 = new File("G:\\szitheima117\\day10\\aaa\\a.txt");
          File f2 = new File("day10\\aaa\\a.txt");
  
          //- public String getAbsolutePath() ：返回此File的绝对路径名字符串。
          System.out.println("f1表示的文件的绝对路径:"+f1.getAbsolutePath());
          System.out.println("f2表示的文件的绝对路径:"+f2.getAbsolutePath());
  
  
          //- public String getPath() ：将此File转换为路径名字符串。 构造路径
          System.out.println("f1的构造路径:"+f1.getPath());
          System.out.println("f2的构造路径:"+f2.getPath());
  
          System.out.println("----------------------------------");
  
          // 创建一个File对象,表示文件路径
          File f3 = new File("day10\\aaa\\a.txt");
          // 创建一个File对象,表示文件夹路径
          File f4 = new File("day10\\aaa");
  
          //- public String getName()  ：返回由此File表示的文件或目录的名称。
          System.out.println("f3表示的文件的名称:"+f3.getName());
          System.out.println("f4表示的文件夹的名称:"+f4.getName());
  
          //- public long length()  ：返回由此File表示的文件的字节大小。 不能获取文件夹的字节大小。
          System.out.println("f3表示的文件的字节大小:"+f3.length());// 7
          System.out.println("f4表示的文件夹的字节大小:"+f4.length());// 0,不能获取文件夹的字节大小
      }
  }
  
  ```
  
  

#### 判断功能的方法

- `public boolean exists()` ：此File表示的文件或目录是否实际存在。

- `public boolean isDirectory()` ：此File表示的是否为目录。

- `public boolean isFile()` ：此File表示的是否为文件。

- 注意: 如果File对象表示的路径不存在,以上三个方法的返回值都是false

  方法演示，代码如下：
  
  ```java
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 9:12
   */
  public class Test2_判断功能的方法 {
      public static void main(String[] args) {
          // 创建一个File对象,表示文件的路径
          File f1 = new File("day10\\aaa\\a.txt");
          // 创建一个File对象,表示文件夹的路径
          File f2 = new File("day10\\aaa");
          // 创建一个File对象,表示不存在的路径
          File f3 = new File("day10\\abc");
  
          //- public boolean exists() ：此File表示的文件或目录是否实际存在。
          System.out.println("f1表示的文件是否真实存在:"+f1.exists()); // true
          System.out.println("f2表示的文件夹是否真实存在:"+f2.exists());// true
          System.out.println("f3表示的路径是否真实存在:"+f3.exists());// false
          System.out.println("-----------------");
  
          //- public boolean isDirectory() ：此File表示的是否为目录。
          System.out.println("f1是否是一个文件夹:"+f1.isDirectory());// false
          System.out.println("f2是否是一个文件夹:"+f2.isDirectory());// true
          System.out.println("f3是否是一个文件夹:"+f3.isDirectory());// false
          System.out.println("-----------------");
  
          //- public boolean isFile() ：此File表示的是否为文件。
          System.out.println("f1是否是一个文件:"+f1.isFile());// true
          System.out.println("f2是否是一个文件:"+f2.isFile());// false
          System.out.println("f3是否是一个文件:"+f3.isFile());// false
          // 注意: 如果File对象表示的路径不存在,以上三个方法的返回值都是false
  
      }
  }
  
  ```
  
  
  
  ​	

#### 创建删除功能的方法

- `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。 

- `public boolean delete()` ： **删除文件,或者删除空文件夹, 不能删除非空文件夹**

- `public boolean mkdir()` ：创建由此File表示的目录。

- `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。

  方法演示，代码如下：
  
  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 9:17
   */
  public class Test3_创建删除功能的方法 {
      public static void main(String[] args) throws Exception{
          //- public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
          // 创建一个File对象,表示文件路径--->真实存在
          File f1 = new File("day10\\aaa\\a.txt");
          // 创建一个File对象,表示文件路径--->不真实存在
          File f2 = new File("day10\\aaa\\b.txt");
          // 创建f1表示的文件
          boolean res1 = f1.createNewFile();
          // 创建f2表示的文件
          boolean res2 = f2.createNewFile();
          System.out.println("res1:"+res1);// res1:false
          System.out.println("res2:"+res2);// res2:true
          System.out.println("------------------------");
  
  
          //- public boolean delete() ： 删除文件,或者删除空文件夹, 不能删除非空文件夹
          // 创建一个File对象,表示文件路径
          File f3 = new File("day10\\aaa\\b.txt");
          // 创建一个File对象,表示文件夹路径
          File f4 = new File("day10\\aaa");
          // 创建一个File对象,表示文件夹路径
          File f5 = new File("day10\\aaa\\bbb");
          System.out.println(f3.delete());// true
          System.out.println(f4.delete());// false
          System.out.println(f5.delete());// true
          System.out.println("------------------------");
  
  
          //- public boolean mkdir() ：创建由此File表示的目录。
          // 创建一个File对象,表示day10\\aaa\\bbb
          File f6 = new File("day10\\aaa\\bbb");
          f6.mkdir();
  
          // 创建一个File对象,表示day10\\aaa\\ccc\\ddd\\eee\\fff
          File f7 = new File("day10\\aaa\\ccc\\ddd\\eee\\fff");
          //f7.mkdir();// 创建不出fff文件夹
  
          //- public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
          f7.mkdirs();// 创建出fff文件夹
  
      }
  }
  
  ```
  
  



####  遍历目录方法

- `public String[] list()` ：获取File目录中的所有子文件或子目录的名称。


- `public File[] listFiles()` ：获取File目录中的所有子文件或子目录的路径。

- **注意: 循环遍历返回的数组之前,建议做非空判断,避免空指针异常**

  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 9:38
   */
  public class Test4_遍历目录的方法 {
      public static void main(String[] args) {
          // 创建一个File对象,表示day10\\aaa文件夹
          File f = new File("day10\\aaa");
  
          //- public String[] list() ：获取File目录中的所有子文件或子目录的名称。
          String[] arr1 = f.list();
          for (String name : arr1) {
              System.out.println("name:" + name);
          }
          System.out.println("-------------------");
  
          //- public File[] listFiles() ：获取File目录中的所有子文件或子目录的路径。
          File[] arr2 = f.listFiles();
          for (File file : arr2) {
              System.out.println("file:" + file);
          }
  
          System.out.println("-------------------");
          // 注意:循环遍历返回的数组之前,建议做非空判断,避免空指针异常
          File f2 = new File("G:\\System Volume Information");
          File[] arr3 = f2.listFiles();
          System.out.println("arr3:"+arr3);// arr3: null
          // 报空指针异常
          /*for (File file : arr3) {
              System.out.println("file:"+file);
          }*/
          if (arr3 != null){
              for (File file : arr3) {
                  System.out.println("file:"+file);
              }
          }
      }
  }
  
  ```
  
  



# 第二章 递归

## 2.1 递归的概述

- 概述:

  - 生活中的递归:  放羊-->赚钱-->盖房子-->娶媳妇-->生娃-->放羊-->赚钱-->盖房子-->娶媳妇-->生娃-->放羊...
  - 程序中的递归:  **方法自己调用自己**
  - **注意:**
    - 1.递归没有出口,就会报栈内存溢出错误StackOverflowError
    - 2.出口不能太晚了,否则也会报栈内存溢出错误StackOverflowError

- 案例

  ```java
  package com.itheima.demo4_递归的概述;
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 9:50
   */
  public class Test {
      static int count = 0;
  
      public static void main(String[] args) {
          /*
              程序中的递归:  方法自己调用自己
              注意:
                  1.递归一定要有出口,否则会报栈内存溢出错误StackOverflowError
                  2.递归的出口不能太晚,否则会报栈内存溢出错误StackOverflowError
           */
          method();
      }
  
      public static void method() {
        count++;
          if (count == 100) {
              return;// 结束方法\递归
          }
  
          System.out.println("HelloWorld:" + count);
          // 在method方法中调用method方法自己
          method();
      }
  }
  
  ```
  
  

## 2.2 递归累和 

### 需求

- 定义一个方法,使用递归计算1 ~ n的累加和

### 分析

- 定义一个方法
- 什么时候开始递归---->找规律
  - 规律:
    - 1的累加和 = 1
    - 2的累加和 = 2 + 1
    - 3的累加和 = 3 + 2 + 1
    - 4的累加和 = 4 + 3 + 2 + 1
    - 5的累加和 = 5 +  4 + 3 + 2 + 1
    - ...
    - n的累加和 = n + (n-1)的累加和
- 什么时候结束递归
  - 计算到1的累加和就结束递归

### 实现

```java
public class Test1_计算n的累加和 {
    public static void main(String[] args) {
        System.out.println(getSum(5));// 15
    }

    /**
     * 计算n的累加和
     * @param n
     * @return 和
     */
    public static int getSum(int n) {
        // 出口
        if (n == 1) {
            return 1;
        }

        // 规律
        return n + getSum(n - 1);
    }
}

```



#### 代码执行图解

![](img/day08_01_递归累和.jpg)

## 2.3 递归求阶乘

### 需求

- 计算n的阶乘

### 分析

- **阶乘**：所有小于及等于该数的正整数的积。

```java
n的阶乘：n! = n * (n-1) *...* 3 * 2 * 1 
```

n的阶乘 = n * (n - 1)的阶乘，所以可以把阶乘的操作定义成一个方法，递归调用。

```
推理得出：n! = n * (n-1)!
```

### 实现

```java
/**
 * @Author PengZhiLin
 * @Date 2021/7/4 10:14
 */
public class Test2_计算n的阶乘 {
    public static void main(String[] args) {
        System.out.println(jieCheng(5));// 120
    }

    /**
     * 计算n的阶乘
     *
     * @param n
     * @return 阶乘
     */
    public static int jieCheng(int n) {
        // 出口
        if (n == 1){
            return 1;
        }

        // 规律
        return n * jieCheng(n - 1);
    }
}

```





## 2.4 文件搜索

### 需求

-  输出day10目录中的所有.java文件的绝对路径。

### 分析

1.  定义一个方法,使用递归完成查找
2.  获取该文件夹路径下的所有子文件和子文件夹
3.  循环遍历所有的子文件和子文件夹
4.  判断遍历出来的是否是文件,并且是否是.java结尾的文件,如果是,就打印输出
5.  判断遍历出来的是否是文件夹,如果是递归

###  实现

```java

/**
 * @Author PengZhiLin
 * @Date 2021/7/4 10:17
 */
public class Test3_文件搜索 {
    public static void main(String[] args) {
        // 需求:输出day10目录中的所有.java文件的绝对路径。
        File f = new File("day10");
        searchJavaFile(f);
    }

    //1. 定义一个方法,使用递归完成查找
    public static void searchJavaFile(File dirPath) {
        //2. 获取该文件夹路径下的所有子文件和子文件夹
        File[] arr = dirPath.listFiles();

        //3. 循环遍历所有的子文件和子文件夹
       if (arr != null){
            for (File file : arr) {
                //4. 判断遍历出来的是否是文件,并且是否是.java结尾的文件,如果是,就打印输出
                if (file.isFile() && file.getName().endsWith(".java")) {
                    System.out.println("file:" + file.getAbsolutePath());
                }

                //5. 判断遍历出来的是否是文件夹,如果是递归
                if (file.isDirectory()){
                    searchJavaFile(file);
                }
            }
        }

    }
}

```

# 第三章 IO概述和分类

#### IO的概述

- I : Input       输入   从其他存储设备读数据到内存中
- O : Output  输出   从内存中写数据到其他存储设备

![](img/1_io.jpg)

#### IO的分类

- **按类型分:**
  - 字节流: 以字节为基本单位进行读写数据
    - 字节输入流: 以字节为基本单位进行读数据
    - 字节输出流: 以字节为基本单位进行写数据
  - 字符流: 以字符为基本单位进行读写数据
    - 字符输入流: 以字符为基本单位进行读数据
    - 字符输出流: 以字符为基本单位进行写数据
- 按流向分:
  - 输入流: 读数据
    - 字节输入流: 以字节为基本单位进行读数据
    - 字符输入流: 以字符为基本单位进行读数据
  - 输出流: 写数据
    - 字节输出流: 以字节为基本单位进行写数据
    - 字符输出流: 以字符为基本单位进行写数据

#### IO的顶层父类

- 字节输入流: 顶层父类是InputStream抽象类,常见子类FileInputStream
- 字节输出流: 顶层父类是OutputStream抽象类,常见子类FileOutputStream
- 字符输入流: 顶层父类是Reader抽象类,常见子类FileReader
- 字符输出流: 顶层父类是Writer抽象类,常见子类FileWriter

#### 注意事项

- utf8编码一个中文占3个字节,gbk编码一个中文占2个字节
- 如果存储和解析的编码不一致就会乱码
- idea默认编码是utf8



# 第四章 字节流

## 4.1 字节输出流【OutputStream】

#### OutputStream类的概述

- 概述: `java.io.OutputStream `**抽象类是表示字节输出流的所有类的父类**

- 作用:
  - 将指定的字节信息写出到目的地文件中。
  - 它定义了所有字节输出流的基本共性功能方法。(所有字节输出流的类都继承了OutputStream)

#### OutputStream类的常用方法

- `public void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。    
- `public abstract void write(int b)` ：写出一个字节数据到目的地文件中。
- `public void write(byte[] b)`：将 b.length字节写出到目的地文件中。  
- `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。  

> 小贴士：
>
> close方法，当完成流的操作时，必须调用此方法，释放系统资源。



## 4.2 FileOutputStream类

- 概述:`java.io.FileOutputStream`类继承OutputStream类,所以该类也是一个字节输出流,可以用来写字节数据到目的地文件中

- 构造方法:

  - `public FileOutputStream(File file); 创建字节输出流对象,通过File参数指定目的地文件路径;`

  - `public FileOutputStream(String path); 创建字节输出流对象,通过String参数指定目的地文件路径;`

  - **注意:**

    - 如果指定的文件存在,就会清空该文件中的数据
    - 如果指定的文件不存在,就会创建一个新的空文件

  - 案例:

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 11:01
     */
    public class Test1 {
        public static void main(String[] args) throws FileNotFoundException {
            //- public FileOutputStream(File file); 创建字节输出流对象,通过File参数指定目的地文件路径;
            // 创建字节输出流对象,关联目的地文件路径(bbb\\a.txt)
            File f = new File("day10\\bbb\\a.txt");
            FileOutputStream fos1 = new FileOutputStream(f);
    
            //- public FileOutputStream(String path); 创建字节输出流对象,通过String参数指定目的地文件路径;
            FileOutputStream fos2 = new FileOutputStream("day10\\bbb\\b.txt");
    
            // 目的地文件路径不存在
            FileOutputStream fos3 = new FileOutputStream("day10\\bbb\\c.txt");
    
    
            // 注意:
            // 1.如果目的地文件存在,就会清空文件中的数据
            // 2.如果目的地文件不存在,就会创建一个新的空文件
    
        }
    }
    
    ```

    

- 写出数据的方法
  - 写一个字节:  `public void write(int b)` ：写出一个字节数据到目的地文件中。

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 11:09
     */
    public class Test1_写一个字节数据 {
        public static void main(String[] args) throws Exception {
            // 写一个字节:  public void write(int b) ：写出一个字节数据到目的地文件中。
            // 1.创建一个字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day10\\bbb\\d.txt");
    
            // 2.写一个字节数据
            fos.write(97);
            fos.write('9');
            fos.write('7');
    
            // 3.关闭流,释放资源
            fos.close();
        }
    }
    文件中的数据:
    a97
    ```
    
    
    
  - 写字节数组: `public void write(byte[] b)` ：将 b.length字节写出到目的地文件中。

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 11:16
     */
    public class Test2_写一个字节数组 {
        public static void main(String[] args) throws Exception{
            // 写字节数组: public void write(byte[] b) ：将 b.length字节写出到目的地文件中。
            // 1.创建一个字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day10\\bbb\\e.txt");
    
            // 2.写字节数组
            byte[] bys = {97,98,99,100,49,50,51};
            fos.write(bys);
    
            // 3.关闭流,释放资源
            fos.close();
        }
    }
    文件中的数据:
    abcd123
    ```
    
    
    
  - 写指定长度字节数组: `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。  

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 11:16
     */
    public class Test3_写指定长度的字节数组 {
        public static void main(String[] args) throws Exception{
            // 写指定长度字节数组: public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
            // 1.创建一个字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day10\\bbb\\f.txt");
    
            // 2.写字节数组----->abcd
            byte[] bys = {97,98,99,100,49,50,51};
            fos.write(bys,0,4);
    
            // 3.关闭流,释放资源
            fos.close();
        }
    }
    文件中的数据:
    abcd
    ```
    
    
    
  - 追加续写---->创建字节输出流对象的时候,不要清空源文件中的数据

    - `public FileOutputStream(File file,boolean append); 创建字节输出流对象,通过File参数指定目的地文件路径;`
    - `public FileOutputStream(String path,boolean append); 创建字节输出流对象,通过String参数指定目的地文件路径;`
    - **注意:**
      - 如果指定的文件存在,并且第二个参数为true,就不会清空源文件中的数据,如果第二个参数为false,就会清空
      - 如果指定的文件不存在,就会创建一个新的空文件

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 11:26
     */
    public class Test4_追加续写 {
        public static void main(String[] args)throws Exception {
            // 1.创建字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day10\\bbb\\g.txt",true);
            // 2.写字节数组----->abcd
            byte[] bys = {97,98,99,100,49,50,51};
            fos.write(bys,0,4);
            // 3.关闭流,释放资源
            fos.close();
        }
    }
    文件中原有的数据是: 123
    执行该程序之后文件中的数据是:123abcd
    ```

    

  - 写出换行
    - 回车符`\r`和换行符`\n` ：
      - 回车符：回到一行的开头（return）。
      - 换行符：下一行（newline）。
      
    - 系统中的换行：
      - Windows系统里，每行结尾是 `回车+换行` ，即`\r\n`；
      - Unix系统里，每行结尾只有 `换行` ，即`\n`；
      - Mac系统里，每行结尾是 `回车` ，即`\r`。从 Mac OS X开始与Linux统一。
      
      ```java
      /**
       * @Author PengZhiLin
       * @Date 2021/7/4 11:32
       */
      public class Test5_写出换行 {
          public static void main(String[] args) throws Exception {
              /*
                 看这风景美如画
                 本想吟诗赠天下
                 奈何本人没文化
                 一句我操浪好大
               */
              // 1.创建字节输出流对象,关联目的地文件路径
              FileOutputStream fos = new FileOutputStream("day10\\bbb\\h.txt");
      
              // 2.写字节数据
              fos.write("看这风景美如画".getBytes());
              // 写换行
              fos.write("\r\n".getBytes());
      
              fos.write("本想吟诗赠天下".getBytes());
              // 写换行
              fos.write("\r\n".getBytes());
      
              fos.write("奈何本人没文化".getBytes());
              // 写换行
              fos.write("\r\n".getBytes());
      
              fos.write("一句我操浪好大".getBytes());
      
              // 3.关闭流,释放资源
              fos.close();
      
      
          }
      }
      
      ```
      
      





## 4.3 字节输入流【InputStream】

#### InputStream类的概述

`java.io.InputStream `抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入流的基本共性功能方法。

#### InputStream类的常用方法

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。    
- `public abstract int read()`： 读一个字节,返回这个字节的数据。 
- `public int read(byte[] b)`： 读一个字节数组长度个字节,把读取到的字节数据存储到数组中,返回读取到的字节个数

> 小贴士：
>
> close方法，当完成流的操作时，必须调用此方法，释放系统资源。



## 4.4 FileInputStream类

- 概述:`java.io.FileInputStream`类继承InputStream类,所以是一个字节输入流,可以用来读字节数据到内存中

- 构造方法:

  - `public FileInputStream(File file); 创建字节输入流对象,通过File类型参数指定数据源文件路径;`

  - `public FileInputStream(String path); 创建字节输入流对象,通过String类型参数指定数据源文件路径;`

  - **注意:**

    - 如果指定的数据源文件不存在,就会报文件找不到异常FileNotFoundException

  - 案例:

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 12:02
     */
    public class Test {
        public static void main(String[] args) throws Exception {
            //- public FileInputStream(File file); 创建字节输入流对象,通过File类型参数指定数据源文件路径;
            //- public FileInputStream(String path); 创建字节输入流对象,通过String类型参数指定数据源文件路径;
            //- 注意: 如果指定的数据源文件不存在,就会报文件找不到异常FileNotFoundException
            // 文件存在:
            // 创建字节输入流对象,关联数据源文件路径
            FileInputStream fis1 = new FileInputStream(new File("day10\\ccc\\a.txt"));
            FileInputStream fis2 = new FileInputStream("day10\\ccc\\a.txt");
    
            // 文件不存在: 报文件找不到异常FileNotFoundException
            // 创建字节输入流对象,关联数据源文件路径
            FileInputStream fis3 = new FileInputStream("day10\\ccc\\b.txt");// 报文件找不到异常
        }
    }
    
    ```

    

- 读取数据方法:

  - 读一个字节:`public int read()`： 读一个字节,读到文件的末尾返回-1。

    - 不使用循环读

      ```java
      /**
       * @Author PengZhiLin
       * @Date 2021/7/4 12:09
       */
      public class Test1_读一个字节 {
          public static void main(String[] args) throws Exception{
              // 读一个字节:public int read()： 读一个字节,读到文件的末尾返回-1。
              // 1.创建字节输入流对象,关联数据源文件路径
              FileInputStream fis = new FileInputStream("day10\\ccc\\a.txt");
      
              // 2.读一个字节
              int b1 = fis.read();
              System.out.println("b1:"+b1);// b1:97
      
              int b2 = fis.read();
              System.out.println("b2:"+b2);// b2:98
      
              int b3 = fis.read();
              System.out.println("b3:"+b3);// b3:99
      
              int b4 = fis.read();
              System.out.println("b4:"+b4);// b4:100
      
              int b5 = fis.read();
              System.out.println("b5:"+b5);// b5:101
      
              int b6 = fis.read();
              System.out.println("b6:"+b6);// b6:-1
      
              // 3.关闭流,释放资源
              fis.close();
      
          }
      }
      
      ```

      

    - 使用循环读

      ```java
      
      /**
       * @Author PengZhiLin
       * @Date 2021/7/4 12:09
       */
      public class Test2_循环读一个字节 {
          public static void main(String[] args) throws Exception{
              // 读一个字节:public int read()： 读一个字节,读到文件的末尾返回-1。
              // 1.创建字节输入流对象,关联数据源文件路径
              FileInputStream fis = new FileInputStream("day10\\ccc\\a.txt");
      
              // 2.读一个字节
             /* int b1 = fis.read();
              System.out.println("b1:"+b1);// b1:97
      
              int b2 = fis.read();
              System.out.println("b2:"+b2);// b2:98
      
              int b3 = fis.read();
              System.out.println("b3:"+b3);// b3:99
      
              int b4 = fis.read();
              System.out.println("b4:"+b4);// b4:100
      
              int b5 = fis.read();
              System.out.println("b5:"+b5);// b5:101
      
              int b6 = fis.read();
              System.out.println("b6:"+b6);// b6:-1  读到文件的末尾了*/
      
              // 定义一个int类型的变量,用来存储读取到的字节数据
              int b;
      
              // 由于读取的次数不确定,所以使用while循环
              // fis读一个字节,把读取到的这个字节赋值给b,再拿b与-1进行比较
              while ( (b = fis.read()) != -1){
                  System.out.println("b:"+b);
              }
      
      
              // 3.关闭流,释放资源
              fis.close();
      
          }
      }
      
      ```

      

  - 读一个字节数组: `public int read(byte[] b)`： 读一个字节数组,读到的字节数据存储在byte数组中,返回读取到的字节个数,如果读取到文件的末尾,就返回-1

    - 不使用循环读
    
      ```java
    
      /**
     * @Author PengZhiLin
       * @Date 2021/7/4 12:22
     */
      public class Test1_读一个字节数组 {
          public static void main(String[] args) throws Exception{
              // 读一个字节数组: public int read(byte[] b)： 读一个字节数组,读到的字节数据存储在byte数组中,返回读取到的字节个数,如果读取到文件的末尾,就返回-1
              // 1.创建字节输入流对象,关联数据源文件路径
              FileInputStream fis = new FileInputStream("day10\\ccc\\a.txt");
      
              // 2.读一个字节数组
              byte[] bys = new byte[2];
      
              int len1 = fis.read(bys);
              System.out.println("len1:"+len1);// len1: 2
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[97, 98]
      
              int len2 = fis.read(bys);
              System.out.println("len2:"+len2);// len2: 2
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[99, 100]
      
              int len3 = fis.read(bys);
              System.out.println("len3:"+len3);// len3: 1
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[101, 100]
      
              int len4 = fis.read(bys);
              System.out.println("len4:"+len4);// len4: -1
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[101, 100]
      
              // 3.关闭流,释放资源
              fis.close();
      
          }
      }
      
      ```
    
      
    
    - 使用循环读
    
      ```java
      
      /**
       * @Author PengZhiLin
       * @Date 2021/7/4 12:22
       */
      public class Test2_读一个字节数组 {
          public static void main(String[] args) throws Exception{
              // 读一个字节数组: public int read(byte[] b)： 读一个字节数组,读到的字节数据存储在byte数组中,返回读取到的字节个数,如果读取到文件的末尾,就返回-1
              // 1.创建字节输入流对象,关联数据源文件路径
              FileInputStream fis = new FileInputStream("day10\\ccc\\a.txt");
      
              // 2.读一个字节数组
             /* byte[] bys = new byte[2];
      
              int len1 = fis.read(bys);
              System.out.println("len1:"+len1);// len1: 2
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[97, 98]
      
              int len2 = fis.read(bys);
              System.out.println("len2:"+len2);// len2: 2
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[99, 100]
      
              int len3 = fis.read(bys);
              System.out.println("len3:"+len3);// len3: 1
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[101, 100]
      
              int len4 = fis.read(bys);
              System.out.println("len4:"+len4);// len4: -1
              System.out.println("bys:"+ Arrays.toString(bys));// bys:[101, 100]*/
      
              // 定义一个int类型的变量,用来存储读取到的字节数据
              byte[] bys = new byte[2];
      
              // 定义一个int类型的变量,用来存储读取到的字节个数
              int len;
              // 由于循环读多少次是未知的,所以使用while循环
              while ( (len = fis.read(bys)) != -1){
                  System.out.println(new String(bys, 0, len));
              }
      
              // 3.关闭流,释放资源
              fis.close();
      
          }
      }
      
      ```
    
      
    
    
    
    

## 4.5 拷贝图片练习

### 需求

- 使用字节流拷贝一张图片

### 分析

![1588696319583](img\1588696319583.png)

```java
一次读写一个字节拷贝文件:
1.创建字节输入流对象,关联数据源文件路径
2.创建字节输出流对象,关联目的地文件路径
3.定义一个int变量,用来存储读取到的字节数据
4.循环读字节数据
5.写出数据
6.关闭流,释放资源
    
一次读写一个字节数组拷贝文件:
1.创建字节输入流对象,关联数据源文件路径
2.创建字节输出流对象,关联目的地文件路径
3.定义一个int变量,用来存储读取到的字节个数
3.定义一个byte数组,用来存储读取到的字节数据
4.循环读字节数据
5.写出数据
6.关闭流,释放资源
```

### 实现

复制图片文件，代码使用演示：

```java

/**
 * @Author PengZhiLin
 * @Date 2021/7/4 14:37
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ccc\\hb.jpg");

        //2.创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\ccc\\hbCopy1.jpg");

        //3.定义一个int变量,用来存储读取到的字节数据
        int b;

        //4.循环读字节数据
        while ((b = fis.read()) != -1) {
            //5.写出数据
            fos.write(b);
        }

        //6.关闭流,释放资源
        fos.close();
        fis.close();
        System.out.println("拷贝完成!");
    }
}

```

```java
/**
 * @Author PengZhiLin
 * @Date 2021/7/4 14:37
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        //1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ccc\\hb.jpg");

        //2.创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\ccc\\hbCopy2.jpg");

        //3.定义一个int变量,用来存储读取到的字节个数
        int len;
        //3.定义一个byte数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        //4.循环读字节数据
        while ((len = fis.read(bys)) != -1) {
            //5.写出数据
            fos.write(bys,0,len);
        }

        //6.关闭流,释放资源
        fos.close();
        fis.close();
        System.out.println("拷贝完成!");
    }
}

```





# 第五章 字符流

## 5.1 字节流读文本文件的问题

当使用字节流读取文本文件时，可能会有一个小问题。就是遇到中文字符时，可能不会显示完整的字符，那是因为一个中文字符可能占用多个字节存储。所以Java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件。

```java
/**
 * @Author PengZhiLin
 * @Date 2021/7/4 14:54
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 需求:把day10\ddd\a.txt文件中的每个字符读取处理,打印输出
        // 1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ddd\\a.txt");

        // 2.定义一个int类型的变量,用来存储字节数据
        int b;

        // 3.循环读取字节数据
        while ((b = fis.read()) != -1) {
            // 4.在循环中,打印输出
            System.out.println((char)b);// 乱码
        }

        // 5.关闭流,释放资源
        fis.close();

    }
}

```





## 5.2 字符输入流【Reader】

#### 字符输入流Reader类的概述

`java.io.Reader`抽象类是表示用于读取字符流的所有类的超类，可以读取字符信息到内存中。它定义了字符输入流的基本共性功能方法。

#### 字符输入流Reader类的常用方法

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源。    
- `public int read()`： 从输入流读取一个字符,读取文件的末尾返回-1。 
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中,返回读取到的字符个数,读取到文件的末尾返回-1 。



## 5.3 FileReader类

- 概述: `java.io.FileReader`类继承Reader类,所以也是一个字符输入流,可以用来读字符数据到内存中.

- 构造方法:

  - `public FileReader(File file); 创建字符输入流对象,通过File类型参数指定数据源文件路径;`

  - `public FileReader(String path); 创建字符输入流对象,通过String类型参数指定数据源文件路径;`

  - 注意:

    - 如果指定的文件路径不存在,就会报文件找不到异常FileNotFoundException

  - 案例:

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:09
     */
    public class Test {
        public static void main(String[] args) throws Exception{
            // 文件存在:
            // 创建FileReader字符输入流对象
            FileReader fr1 = new FileReader("day10\\ddd\\a.txt");
    
            // 文件不存在: 报文件找不到异常FileNotFoundException
            // 创建FileReader字符输入流对象
            FileReader fr2 = new FileReader("day10\\ddd\\b.txt");
        }
    }
    
    ```

    

- 读数据的方法

  - 读一个字符:`public int read()`： 从输入流读取一个字符,读取文件的末尾返回-1。

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:11
     */
    public class Test1 {
        public static void main(String[] args) throws Exception {
          //读一个字符:public int read()： 从输入流读取一个字符,读取文件的末尾返回-1。
            // 1.创建字符输入流对象,关联数据源文件路径
            FileReader fr = new FileReader("day10\\ddd\\a.txt");
    
            // 2.读一个字符
            /*int c1 = fr.read();
            System.out.println("c1:" + (char) c1);// a
    
            int c2 = fr.read();
            System.out.println("c2:" + (char) c2);// b
    
            int c3 = fr.read();
            System.out.println("c3:" + (char) c3);// 中
    
            int c4 = fr.read();
            System.out.println("c4:" + (char) c4);// 国
    
            int c5 = fr.read();
            System.out.println("c5:" + (char) c5);// c
    
            int c6 = fr.read();
            System.out.println("c6:" + c6);// -1*/
            // 定义一个int变量,用来存储读取到的字符数据
            int c;
            // 循环读数据
            while ((c = fr.read()) != -1) {
                System.out.println("c:" + (char) c);
            }
            
            // 3.关闭流,释放资源
            fr.close();
    
        }
    }
    
    ```
    
    
    
  - 读一个字符数组:`public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中,返回读取到的字符个数,读取到文件的末尾返回-1 。
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:33
     */
    public class Test {
        public static void main(String[] args) throws Exception {
            // 读一个字符数组:public int read(char[] cbuf)： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中,返回读取到的字符个数,读取到文件的末尾返回-1 。
            // 1.创建字符输入流对象,关联数据源文件路径
            FileReader fr = new FileReader("day10\\ddd\\a.txt");
    
            // 2.读字符数组
            /*char[] chs = new char[2];
            int len1 = fr.read(chs);
            System.out.println("len1:"+len1);// len1: 2
            System.out.println(new String(chs,0,len1));// ab
    
            int len2 = fr.read(chs);
            System.out.println("len2:"+len2);// len2: 2
            System.out.println(new String(chs,0,len2));// 中国
    
            int len3 = fr.read(chs);
            System.out.println("len3:"+len3);// len3: 1
            System.out.println(new String(chs,0,len3));// c
    
            int len4 = fr.read(chs);
            System.out.println("len4:"+len4);// len4: -1*/
    
            // 定义一个char类型的数组,用来存储读取到的字符数据
            char[] chs = new char[2];
    
            // 定义一个int变量,用来存储读取到的字符个数
            int len;
            // 循环
            while ((len = fr.read(chs)) != -1) {
                System.out.println(new String(chs,0,len));
            }
    
    
            // 3.关闭流,释放资源
            fr.close();
    
        }
    }
    ```
    
    



## 5.4 字符输出流【Writer】

#### 字符输出流Writer类的概述

`java.io.Writer `**抽象类**是表示用于写出字符流的所有类的超类，**将指定的字符信息写出到目的地**。它定义了字符输出流的基本共性功能方法。

#### 字符输出流Writer类的常用方法

- `public abstract void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  
- `public abstract void flush() ` ：刷新此输出流并强制任何缓冲的输出字符被写出。  
- `public void write(int c)` ：写出一个字符。
- `public void write(char[] cbuf)`：将 b.length字符从指定的字符数组写出此输出流。  
- `public abstract void write(char[] b, int off, int len)` ：从指定的字符数组写出 len字符，从偏移量 off开始输出到此输出流。  
- `public void write(String str)` ：写出一个字符串。
- `public void write(String str,int off,int len)` ：写出一个字符串的一部分。



## 5.5 FileWriter类

- 概述: `java.io.FileWriter类`继承Writer类,所以也是一个字符输出流,可以用来写字符数据到目的地文件中

- 构造方法:

  - `public FileWriter(File file); 创建字符输出流对象,通过File参数指定目的地文件路径;`

  - `public FileWriter(String path); 创建字符输出流对象,通过String参数指定目的地文件路径;`

    - **注意:**
      - 如果指定的文件存在,就会清空该文件中的数据
      - 如果指定的文件不存在,就会创建一个新的空文件

  - `public FileWriter(File file,boolean append); 创建字符输出流对象,通过File参数指定目的地文件路径;`

  - `public FileWriter(String path,boolean append); 创建字符输出流对象,通过String参数指定目的地文件路径;`

    - **注意:**
      - 如果指定的文件存在,并且第二个参数为true,就不会清空源文件中的数据,如果第二个参数为false,就会清空
      - 如果指定的文件不存在,就会创建一个新的空文件

  - 案例:

    ```java
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:53
     */
    public class Test {
        public static void main(String[] args) throws Exception{
            // 创建字符输出流对象,关联目的地文件路径
            //FileWriter fw1 = new FileWriter("day10\\eee\\a.txt");// 文件存在就会清空文件中的数据
            //FileWriter fw2 = new FileWriter("day10\\eee\\b.txt");// 文件不存在就会创建新的文件
            // 参数为true就不会清空文件中的数据,为false就会清空
            //FileWriter fw3 = new FileWriter("day10\\eee\\a.txt",true);
            //FileWriter fw4 = new FileWriter("day10\\eee\\a.txt",false);
        }
    }
    
    ```

    

- 写出数据:
  - **写一个字符**: `public void write(int c)` ：写出一个字符。
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:58
     */
    public class Test1_写一个字符 {
        public static void main(String[] args) throws Exception{
            // 写一个字符: public void write(int c) ：写出一个字符。
            // 1.创建字符输出流对象,关联目的地文件路径
            FileWriter fw = new FileWriter("day10\\eee\\c.txt");
            
            // 2.写一个字符
            fw.write(97);// 写的是a字符
            fw.write('9');// 写的是9字符
            fw.write('7');// 写的是7字符
    
            // 3.关闭流,释放资源
            fw.close();
    
        }
    }
    文件中的数据:  a97
    ```
    
    
    
  - 写字符数组:`public void write(char[] cbuf)`：将 b.length字符从指定的字符数组写出此输出流。  
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:58
     */
    public class Test2_写一个字符数组 {
        public static void main(String[] args) throws Exception{
            // 写字符数组:public void write(char[] cbuf)：将 b.length字符从指定的字符数组写出此输出流。
            // 1.创建字符输出流对象,关联目的地文件路径
            FileWriter fw = new FileWriter("day10\\eee\\d.txt");
    
            // 2.写一个字符数组
            char[] chs = {'a','b','c','d','1','2','3'};
            fw.write(chs);
    
            // 3.关闭流,释放资源
            fw.close();
    
        }
    }
    文件中的数据:  abcd123
    ```
    
    
    
  - **写指定长度字符数组**: `public abstract void write(char[] b, int off, int len)` ：从指定的字符数组写出 len字符，从偏移量 off开始输出到此输出流。  
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:58
     */
    public class Test3_写指定范围的字符数组数据 {
        public static void main(String[] args) throws Exception{
            // 写指定范围字符数组: public abstract void write(char[] b, int off, int len) ：从指定的字符数组写出 len字符，从偏移量 off开始输出到此输出流。
            // 1.创建字符输出流对象,关联目的地文件路径
            FileWriter fw = new FileWriter("day10\\eee\\e.txt");
    
            // 2.写一个字符数组--->abcd
            char[] chs = {'a','b','c','d','1','2','3'};
            fw.write(chs,0,4);
    
            // 3.关闭流,释放资源
            fw.close();
    
        }
    }
    文件中的数据:  abcd
    ```
    
    
    
  - 写字符串:`public void write(String str)` ：写出一个字符串。
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:58
     */
    public class Test4_写一个字符串 {
        public static void main(String[] args) throws Exception{
            // 写字符串:public void write(String str) ：写出一个字符串。
            // 1.创建字符输出流对象,关联目的地文件路径
            FileWriter fw = new FileWriter("day10\\eee\\f.txt");
    
            // 2.写一个字符串
            fw.write("看这风景美如画");
            fw.write("\r\n");
    
            fw.write("本想吟诗赠天下");
            fw.write("\r\n");
    
            fw.write("奈何本人没文化");
            fw.write("\r\n");
    
            fw.write("一句我操浪好大");
    
            // 3.关闭流,释放资源
            fw.close();
    
        }
    }
    文件中的数据:
    看这风景美如画
    本想吟诗赠天下
    奈何本人没文化
    一句我操浪好大
    ```
    
    
    
  - 写指定长度字符串: `public void write(String str,int off,int len)` ：写出一个字符串的一部分。
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 15:58
     */
    public class Test5_写指定范围的字符串 {
        public static void main(String[] args) throws Exception{
            // 写指定长度字符串: public void write(String str,int off,int len) ：写出一个字符串的一部分。
            // 1.创建字符输出流对象,关联目的地文件路径
            FileWriter fw = new FileWriter("day10\\eee\\g.txt");
    
            // 2.写指定范围的字符串---->黑马程序员
            String str = "itheima黑马程序员itcast";
            fw.write(str,7,5);
    
    
            // 3.关闭流,释放资源
            fw.close();
    
        }
    }
    文件中的数据:黑马程序员
    ```
    
    
  
- 关闭和刷新

  - `public abstract void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  

  - `public abstract void flush() ` ：刷新此输出流并强制任何缓冲的输出字符被写出。  

  - 区别:

    - 关闭:  关闭流之前会刷新,关闭之后流就不能再使用了

    - 刷新: 刷新之后流还可以继续使用

      ```java
      /**
       * @Author PengZhiLin
       * @Date 2021/7/4 16:13
       */
      public class Test {
          public static void main(String[] args) throws Exception {
              //- public abstract void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
              //- public abstract void flush() ：刷新此输出流并强制任何缓冲的输出字符被写出。
              // 1.创建字符输出流对象,关联目的地文件路径
              FileWriter fw = new FileWriter("day10\\eee\\h.txt");
      
              // 2.写出字符数据
              fw.write('刷');
              // 刷新一下
              fw.flush();
              // 写数据
              fw.write('新');
              fw.flush();
      
              // 写数据
              fw.write('关');
              // 关闭流
              fw.close();
              // 写数据
              fw.write('闭');// 报IOException异常,流已经关闭了
              // 关闭流
      		fw.close();
      
          }
      }
      文件中的数据:刷新关
      ```
      
      

# 总结

```java
必须练习:
	1.一次读写一个字节拷贝文件
    2.一次读写一个字节数组拷贝文件
    3.一次读写一个字符拷贝文本文件
    4.一次读写一个字符数组拷贝文本文件
    以上4个案例必须写5遍----> 20遍---->脱离笔记,能够自己独立写出来
        
    5.追加续写
    6.搜索指定类型的文件--->递归,File类


- 能够说出File对象的创建方式
    public File(String pathname);
    public File(String parent,String child);
    public File(File parent,String child);

- 能够使用File类常用方法
    public String getAbsolutePath() ：返回此File的绝对路径名字符串。
    public String getPath() ：获取构造路径(构造方法中传入的路径)
    public String getName()  ：返回由此File表示的文件或目录的名称。
    public long length()  ：返回由此File表示的文件的字节大小。 不能获取目录的字节大小
    
    public boolean exists() ：此File表示的文件或目录是否实际存在。
    public boolean isDirectory() ：此File表示的是否为目录。
    public boolean isFile() ：此File表示的是否为文件。
    
    public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
    public boolean delete() ：删除由此File表示的文件或目录。注意,只能删除空文件夹
    public boolean mkdir() ：创建由此File表示的目录。
    public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
    
    public String[] list() ：获取File目录中的所有子文件或子目录的名称。
	public File[] listFiles() ：获取File目录中的所有子文件或子目录的路径。
    
- 能够辨别相对路径和绝对路径
    相对路径: 相对于项目路径而言的路径
    绝对路径: 以盘符开始的完整路径
        
- 能够遍历文件夹
    listFiles()
        
- 能够解释递归的含义
    方法自己调用自己
    规律--出口
        
- 能够使用递归的方式计算5的阶乘
    public static int jieCheng(int n){
        if(n == 1){return 1;}
        return n * jieCheng(n-1);
    } 
- 能够说出使用递归会内存溢出隐患的原因
    递归没有出口,或者递归的出口太晚了,造成方法没有弹栈,栈就满了
    
- 能够说出IO流的分类和功能
   字节流:以字节为基本单位进行读写数据
   字符流:以字符为基本单位进行读写数据
       
- 能够使用字节输出流写出数据到文件
   FileOutputStream:
		write(int b);----常用  写一个字节
 		write(byte[] bys,int off,int len);----常用 写一个字节数组
            
- 能够使用字节输入流读取数据到程序
   FileInputStream:
		int read(); 读一个字节
        int read(byte[] bys);读一个字节数组
            
- 能够理解读取数据int read(byte[] bys)方法的原理
   读取数组长度个字节数据存储到字节数组中,返回读取到的字节个数,如果不够数组长度个字节数据,那么有多少个就读多少个
            
- 能够使用字节流完成文件的复制
    查看笔记思路
    一次读写一个字节拷贝文件
    一次读写一个字节数组拷贝文件
            
- 能够使用FileWriter写数据的5个方法
   write(int len);---- 常用   写一个字符
   write(char[] chs,int off,int len)---- 常用  写一个字符数组         
   
   write(char[] chs);  
   write(String str);
   write(String str,int off,int len)
 
- 能够使用FileReader读数据一次一个字符
     int  read() 读一个字符
- 能够使用FileReader读数据一次一个字符数组
     int  read(char[] chs) 读一个字符数组
       
- 能够说出FileWriter中关闭和刷新方法的区别
      关闭: 关闭流,刷新缓冲区,流不能再使用
      刷新: 刷新缓冲区,流可以继续使用
          
- 能够使用FileWriter写数据实现换行和追加写
    public  FileWriter(String path,boolean append)
    public  FileWriter(File path,boolean append)  
          回车换行--->"\r\n"
          

```

# 统计文件夹的字节大小

```java
 /**
     * 统计文件夹的字节大小
     * @param path
     * @return
     */
    public static long getSize(File path) {
        // 获取所有的子文件\子文件夹
        File[] files = path.listFiles();
        // 定义一个变量,用来记录文件夹的字节大小
        long len = 0;
        if (files != null) {
            // 循环遍历
            for (File file : files) {
                if (file.isFile()) {
                    // 如果是文件,就计算字节大小,并累加
                    len += file.length();
                }
                if (file.isDirectory()) {
                    // 如果是文件夹,就递归计算文件夹的字节大小,并和之前的文件夹字节大小累加
                    len += getSize(file);
                }
            }
        }
        // 返回文件夹的字节大小
        return len;
    }
```



# 删除非空文件夹

```java
  /**
     * 删除非空文件夹
     *
     * @param f
     */
    public static void delete(File f) {
        // 获取所有的子文件\子文件夹
        File[] arr = f.listFiles();
        if (arr.length != -1) {
            // 循环遍历
            for (File file : arr) {
                if (file.isFile()) {
                    // 如果是文件,就删除
                    file.delete();
                }
                if (file.isDirectory()) {
                    // 如果是文件夹,就递归删除
                    delete(file);
                }
            }
        }
        // 最后结束方法之前,删除当前文件夹
        f.delete();
    }

  
```


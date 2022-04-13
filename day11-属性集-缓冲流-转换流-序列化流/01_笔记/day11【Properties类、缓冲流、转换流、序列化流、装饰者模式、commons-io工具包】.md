# day11【Properties类、缓冲流、转换流、序列化流、装饰者模式、commons-io工具包】

## 今日内容

- IO异常处理----->重点掌握
  - jdk7前处理方式
  - jdk7的处理方式
- Properties类----->重点掌握
  - 加载配置文件中的数据
- 高级流
  - 缓冲流----->重点掌握
    - 字节缓冲流
    - 字符缓冲流
  - 转换流----->重点掌握
    - 转换输入流
    - 转换输出流
  - 序列化流
  - 反序列化流
  - 打印流
- 装饰者模式----->重点掌握
- commons-io工具包----->重点掌握

# 第一章 IO资源的处理

## 1.1  JDK7前处理

之前的入门练习，我们一直把异常抛出，而实际开发中并不能这样处理，建议使用`try...catch...finally` 代码块，处理异常部分，代码使用演示：

```java

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author PengZhiLin
 * @Date 2021/7/4 19:12
 */
public class Test {
    public static void main(String[] args) {
        // 一次读写一个字节数组拷贝文件:
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1.创建字节输入流对象,关联数据源文件路径
            fis = new FileInputStream("day11\\aaa\\hb.jpg");

            // 2.创建字节输出流对象,关联目的地文件路径
            fos = new FileOutputStream("day11\\aaa\\hbCopy1.jpg");

            // 3.定义一个字节数组,用来存储读取到的字节数据
            byte[] bys = new byte[8192];

            // 3.定义一个int类型的变量,用来存储读取到的字节个数
            int len;

            // 4.循环读取字节数据
            while ((len = fis.read(bys)) != -1) {
                // 5.写出字节数据
                fos.write(bys, 0, len);
            }

        } catch (Exception e) {
            System.out.println("异常的信息:" + e.getMessage());
        } finally {
            // 6.关闭流,释放资源
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

```





## 1.2 JDK7的处理

还可以使用JDK7优化后的`try-with-resource` 语句，该语句确保了每个资源在语句结束时自动关闭。所谓的资源（resource）是指在程序完成后，必须关闭的对象。

格式：

```java
try(创建流对象的语句,使用分号隔开){
    // 可能有异常的代码
}catch(异常类型 变量名){
    // 处理异常的代码或者打印异常的信息
}
```

代码使用演示：

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author PengZhiLin
 * @Date 2021/7/4 19:26
 */
public class Test {
    public static void main(String[] args) {
        try(
                // 1.创建字节输入流对象,关联数据源文件路径
                FileInputStream fis = new FileInputStream("day11\\aaa\\hb.jpg");

                // 2.创建字节输出流对象,关联目的地文件路径
                FileOutputStream fos = new FileOutputStream("day11\\aaa\\hbCopy2.jpg");
        ){
            // 3.定义一个字节数组,用来存储读取到的字节数据
            byte[] bys = new byte[8192];

            // 3.定义一个int类型的变量,用来存储读取到的字节个数
            int len;

            // 4.循环读取字节数据
            while ((len = fis.read(bys)) != -1) {
                // 5.写出字节数据
                fos.write(bys, 0, len);
            }

            // 6.关闭流,释放资源
            //fos.close();
            //fis.close();
        }catch (Exception e){
            System.out.println("异常的信息:"+e.getMessage());
        }
    }
}

```



# 第二章 属性集

## 2.1 Properties类

- 概述: 

  - Properties类继承Hashtable,而Hashtable实现了Map接口,所以Properties本质其实就是一个Map集合,可以使用Map接口中的所有方法,但一般不把Properties当成Map集合使用
  - **Properties也是一个属性集,可以用来加载文件中的数据(键值对的形式存储), 并且Properties属性集中每个键及其对应值都是一个字符串。** 

- 构造方法

  - `public Properties()创建一个空的属性集对象`

- 存储方法

  ```java
  public Object setProperty(String key, String value) 保存一对属性。  
  public String getProperty(String key)  使用此属性列表中指定的键搜索属性值。
  public Set<String> stringPropertyNames() 所有键的名称的集合。
  ```

  ```java
  import java.util.Properties;
  import java.util.Set;
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/4 19:36
   */
  public class Test {
      public static void main(String[] args) {
          // 1.创建Properties对象
          Properties pro = new Properties();
  
          // 2.往Properties对象中添加键值对
          pro.setProperty("k1", "v1");
          pro.setProperty("k2", "v2");
          pro.setProperty("k3", "v3");
          pro.setProperty("k4", "v4");
  
          // 3.获取Properties对象中所有的键
          Set<String> keys = pro.stringPropertyNames();
  
          // 4.循环遍历所有的键
          for (String key : keys) {
              // 5.在循环中,根据键获取值
              String value = pro.getProperty(key);
              System.out.println(key+","+value);
          }
      }
  }
  
  ```
  
  
  
- **与流相关的方法**

  - `public void load(InputStream is);加载配置文件中的键值对,存储到Properties对象中`

  - `public void load(Reader r);加载配置文件中的键值对,存储到Properties对象中`

  - 注意:

    - 如果文件中没有中文,就使用第一个load方法
    - 如果文件中有中文,就使用第二个load方法
    - 开发中配置文件一般没有中文

  - 案例:

    ```java
    username=zhangsan
    password=123456
    ```
    
    ```java
    import java.io.FileInputStream;
    import java.io.FileReader;
    import java.util.Properties;
    import java.util.Set;
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 19:45
     */
    public class Test1 {
        public static void main(String[] args) throws Exception {
            // 需求:加载a.txt文件中的键值对数据
            // 1.创建Properties对象
            Properties pro = new Properties();
    
            // 2.加载a.txt文件中的键值对,存储到Properties对象中
            pro.load(new FileInputStream("day11\\aaa\\a.txt"));
            //pro.load(new FileReader("day11\\aaa\\a.txt"));
    
            // 3.获取Properties对象中所有的键
            Set<String> keys = pro.stringPropertyNames();
    
            // 4.循环遍历所有的键
            for (String key : keys) {
                // 5.根据键找值
                String value = pro.getProperty(key);
                System.out.println(key+","+value);
            }
        }
    }
    
    ```
    
    ```java
    driverClassName=com.mysql.jdbc.Driver
    url=jdbc:mysql://localhost:3306/db1
    username=root
    password=123456
    ```
    
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 19:45
     */
    public class Test2 {
        public static void main(String[] args) throws Exception {
            // 需求:加载a.txt文件中的键值对数据
            // 1.创建Properties对象
            Properties pro = new Properties();
    
            // 2.加载a.txt文件中的键值对,存储到Properties对象中
            pro.load(new FileInputStream("day11\\aaa\\db.properties"));
    
            // 3.获取Properties对象中所有的键
            Set<String> keys = pro.stringPropertyNames();
    
            // 4.循环遍历所有的键
            for (String key : keys) {
                // 5.根据键找值
                String value = pro.getProperty(key);
                System.out.println(key+","+value);
            }
        }
    }
    
    ```
    
    





# 第三章 缓冲流

昨天学习了基本的一些流，作为IO流的入门，今天我们要见识一些更强大的流。比如能够高效读写的缓冲流，能够转换编码的转换流，能够持久化存储对象的序列化流等等。这些功能更为强大的流，都是在基本的流对象基础之上创建而来的，就像穿上铠甲的武士一样，相当于是对基本流对象的一种增强。

## 3.1 缓冲流

缓冲流,也叫高效流，是对4个基本的`FileXxx` 流的增强，所以也是4个流，按照数据类型分类：

* **字节缓冲流**：`BufferedInputStream`，`BufferedOutputStream` 
* **字符缓冲流**：`BufferedReader`，`BufferedWriter`

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。



## 3.2 字节缓冲流

- 构造方法

  - BufferedInputStream类:   `public BufferedInputStream(InputStream is);`
  - BufferedOutputStream类: `public BufferedOutputStream(OutputStream os);`

- 拷贝文件效率测试

  - 注意: 字节缓冲流没有特有的功能,读和写的功能都来自于他们的父类(InputStream , OutputStream)

  - 普通字节流一次读写一个字节拷贝文件

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 20:13
     */
  public class Test1_普通字节流一次读写一个字节拷贝文件 {
        public static void main(String[] args) throws Exception {
            // 0.获取当前系统时间距离标准基准时间的毫秒值
            long start = System.currentTimeMillis();
    
            // 1.创建字节输入流对象,关联数据源文件路径
          FileInputStream fis = new FileInputStream("day11\\bbb\\jdk9.exe");
    
            // 2.创建字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day11\\bbb\\jdk9Copy1.exe");
    
            // 3.定义一个int类型变量,用来存储读取到的字节数据
            int b;
    
            // 4.循环读取字节数据
            while ((b = fis.read()) != -1) {
                // 5.写出字节数据
                fos.write(b);
            }
    
            // 6.关闭流,释放资源
            fos.close();
            fis.close();
    
            // 7.获取当前系统时间距离标准基准时间的毫秒值
            long end = System.currentTimeMillis();
            System.out.println("总共花了:" + (end - start) + "毫秒");// 大概十几分钟
    
        }
    }
    
    ```
    
  - 字节缓冲流一次读写一个字节拷贝文件
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 20:13
     */
    public class Test2_字节缓冲流一次读写一个字节拷贝文件 {
        public static void main(String[] args) throws Exception {
            // 0.获取当前系统时间距离标准基准时间的毫秒值
            long start = System.currentTimeMillis();
    
            // 1.创建字节输入流对象,关联数据源文件路径
            FileInputStream fis = new FileInputStream("day11\\bbb\\jdk9.exe");
            BufferedInputStream bis = new BufferedInputStream(fis);
    
            // 2.创建字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day11\\bbb\\jdk9Copy2.exe");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
    
            // 3.定义一个int类型变量,用来存储读取到的字节数据
            int b;
    
            // 4.循环读取字节数据
            while ((b = bis.read()) != -1) {
                // 5.写出字节数据
                bos.write(b);
            }
    
            // 6.关闭流,释放资源
            bos.close();
            bis.close();
    
            // 7.获取当前系统时间距离标准基准时间的毫秒值
            long end = System.currentTimeMillis();
            System.out.println("总共花了:" + (end - start) + "毫秒");// 大概27秒
    
        }
    }
    
    ```
    
  - 字节缓冲流一次读写一个字节数组拷贝文件
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/4 20:13
     */
    public class Test3_字节缓冲流一次读写一个字节数组拷贝文件 {
        public static void main(String[] args) throws Exception {
            // 0.获取当前系统时间距离标准基准时间的毫秒值
            long start = System.currentTimeMillis();
    
            // 1.创建字节输入流对象,关联数据源文件路径
            FileInputStream fis = new FileInputStream("day11\\bbb\\jdk9.exe");
            BufferedInputStream bis = new BufferedInputStream(fis);
    
            // 2.创建字节输出流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day11\\bbb\\jdk9Copy3.exe");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
    
            // 3.定义一个byte数组,用来存储读取到的字节数据
            byte[] bys = new byte[8192];
            // 3.定义一个int类型变量,用来存储读取到的字节个数
            int len;
    
            // 4.循环读取字节数据
            while ((len = bis.read(bys)) != -1) {
                // 5.写出字节数据
                bos.write(bys,0,len);
            }
    
            // 6.关闭流,释放资源
            bos.close();
            bis.close();
    
            // 7.获取当前系统时间距离标准基准时间的毫秒值
            long end = System.currentTimeMillis();
            System.out.println("总共花了:" + (end - start) + "毫秒");// 大概3秒
    
        }
    }
    
    ```
    
    



## 3.3 缓冲流读写效率高的基本原理

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

![image-20210331101909243](img\image-20210331101909243.png)



## 3.4 字符缓冲流

- 字符缓冲流的构造方法

  - BufferedReader类: `public BufferedReader(Reader r);创建一个字符缓冲输入流对象`
  - BufferedWriter类: `public BufferedWriter(Writer w);创建一个字符缓冲输出流对象`

- 字符缓冲流的特有方法

  - BufferedReader类继承Reader类,所以也拥有了Reader类中的所有方法,但自己还有特有的方法:

    - `public String readLine(); 读取一行数据,读取到文件的末尾返回null`

      ```java
      文件中的数据:
      看这风景美如画
      本想吟诗赠天下
      奈何本人没文化
      一句我操浪好大
      
      
      /**
       * @Author PengZhiLin
       * @Date 2021/7/8 10:43
       */
      public class Test1_BufferedReader类 {
          public static void main(String[] args) throws Exception{
              // public String readLine(); 读取一行数据,读取到文件的末尾返回null
              // 1.创建BufferedReader对象,关联数据源文件路径
              FileReader fr = new FileReader("day11\\ccc\\a.txt");
              BufferedReader br = new BufferedReader(fr);
      
              // 2.读一行字符串数据
              //System.out.println(br.readLine());
              //System.out.println(br.readLine());
              //System.out.println(br.readLine());
              //System.out.println(br.readLine());
              //System.out.println(br.readLine());// null
              // 定义一个String类型的变量,用来存储读取到的行数据
              String line;
      
              // 循环读
              while ( (line = br.readLine()) != null){
                  System.out.println(line);
              }
      
              // 3.关闭流,释放资源
              br.close();
      
          }
      }
      
      ```
      
      
    
  - BufferedWriter类继承Writer类,所以也拥有了Writer类中的所有方法,但自己还有特有的方法:
  
    - `public void newLine(); 根据系统写一个行分隔符`
  
      ```java
      
      /**
       * @Author PengZhiLin
       * @Date 2021/7/8 10:48
       */
      public class Test2_BufferedWriter类 {
          public static void main(String[] args) throws Exception{
              // public void newLine(); 根据系统写一个行分隔符
              // 1.创建BufferedWriter对象,关联目的地文件路径
              FileWriter fw = new FileWriter("day11\\ccc\\b.txt");
              BufferedWriter bw = new BufferedWriter(fw);
      
              // 2.写行数据
              bw.write("看这风景美如画");
              bw.newLine();
      
              bw.write("本想吟诗赠天下");
              bw.newLine();
      
              bw.write("奈何本人没文化");
              bw.newLine();
      
              bw.write("一句我操浪好大");
      
              // 3.关闭流,释放资源
              bw.close();
      
          }
      }
      
      ```
      



## 3.5 文本排序

### 需求

请将文本信息恢复顺序。

```
3.侍中、侍郎郭攸之、费祎、董允等，此皆良实，志虑忠纯，是以先帝简拔以遗陛下。愚以为宫中之事，事无大小，悉以咨之，然后施行，必得裨补阙漏，有所广益。
8.愿陛下托臣以讨贼兴复之效，不效，则治臣之罪，以告先帝之灵。若无兴德之言，则责攸之、祎、允等之慢，以彰其咎；陛下亦宜自谋，以咨诹善道，察纳雅言，深追先帝遗诏，臣不胜受恩感激。
4.将军向宠，性行淑均，晓畅军事，试用之于昔日，先帝称之曰能，是以众议举宠为督。愚以为营中之事，悉以咨之，必能使行阵和睦，优劣得所。
2.宫中府中，俱为一体，陟罚臧否，不宜异同。若有作奸犯科及为忠善者，宜付有司论其刑赏，以昭陛下平明之理，不宜偏私，使内外异法也。
1.先帝创业未半而中道崩殂，今天下三分，益州疲弊，此诚危急存亡之秋也。然侍卫之臣不懈于内，忠志之士忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气，不宜妄自菲薄，引喻失义，以塞忠谏之路也。
9.今当远离，临表涕零，不知所言。
6.臣本布衣，躬耕于南阳，苟全性命于乱世，不求闻达于诸侯。先帝不以臣卑鄙，猥自枉屈，三顾臣于草庐之中，咨臣以当世之事，由是感激，遂许先帝以驱驰。后值倾覆，受任于败军之际，奉命于危难之间，尔来二十有一年矣。
7.先帝知臣谨慎，故临崩寄臣以大事也。受命以来，夙夜忧叹，恐付托不效，以伤先帝之明，故五月渡泸，深入不毛。今南方已定，兵甲已足，当奖率三军，北定中原，庶竭驽钝，攘除奸凶，兴复汉室，还于旧都。此臣所以报先帝而忠陛下之职分也。至于斟酌损益，进尽忠言，则攸之、祎、允之任也。
5.亲贤臣，远小人，此先汉所以兴隆也；亲小人，远贤臣，此后汉所以倾颓也。先帝在时，每与臣论此事，未尝不叹息痛恨于桓、灵也。侍中、尚书、长史、参军，此悉贞良死节之臣，愿陛下亲之信之，则汉室之隆，可计日而待也。
```

### 分析

```java
// 1.创建字符缓冲输入流对象,关联数据源文件路径
// 2.创建List集合,限制集合元素类型为String
// 3.定义一个String类型的变量,用来存储读取到的行数据
// 4.循环读行数据
// 5.在循环中,把读到的行数据,存储到List集合中
// 6.关闭流,释放资源
// 7.对集合中的行数据进行排序
// 8.创建字符缓冲输出流对象,关联目的地文件路径
// 9.循环遍历排好序的集合
// 10.把遍历出来的行数据写到目的地文件中
// 11.关闭流,释放资源
```



### 实现

```java

/**
 * @Author PengZhiLin
 * @Date 2021/7/8 10:56
 */
public class Test3_文本恢复顺序 {
    public static void main(String[] args) throws Exception {
        // 1.创建字符缓冲输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day11\\ccc\\csb.txt");
        BufferedReader br = new BufferedReader(fr);

        // 2.创建List集合,限制集合元素类型为String
        ArrayList<String> list = new ArrayList<>();


        // 3.定义一个String类型的变量,用来存储读取到的行数据
        String line;

        // 4.循环读行数据
        while ((line = br.readLine()) != null) {
            // 5.在循环中,把读到的行数据,存储到List集合中
            list.add(line);
        }
        // 6.关闭流,释放资源
        br.close();

        // 7.对集合中的行数据进行排序
        Collections.sort(list);

        // 8.创建字符缓冲输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day11\\ccc\\csb.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        // 9.循环遍历排好序的集合
        for (String s : list) {
            // 10.把遍历出来的行数据写到目的地文件中
            bw.write(s);
            bw.newLine();
        }
        // 10.关闭流,释放资源
        bw.close();

    }
}

```



# 第四章 转换流

## 4.1 字符编码和字符集

#### 字符编码的概述

计算机中储存的信息都是用二进制数表示的，而我们在屏幕上看到的数字、英文、标点符号、汉字等字符是二进制数转换之后的结果。按照某种规则，将字符存储到计算机中，称为**编码** 。反之，将存储在计算机中的二进制数按照某种规则解析显示出来，称为**解码** 。比如说，按照A规则存储，同样按照A规则解析，那么就能显示正确的文本f符号。反之，按照A规则存储，再按照B规则解析，就会导致乱码现象。

* **字符编码`Character Encoding`** : 就是一套自然语言的**字符与二进制数之间的对应规则**。

#### 字符集的概述

* **字符集 `Charset`**：也叫编码表。是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等。

计算机要准确的存储和识别各种字符集符号，需要进行字符编码，**一套字符集必然至少有一套字符编码**。常见字符集有ASCII字符集、GBK字符集、Unicode字符集等。![](img/1_charset.jpg)

可见，当指定了**编码**，它所对应的**字符集**自然就指定了，所以**编码**才是我们最终要关心的。

* **ASCII字符集** ：
  * ASCII（American Standard Code for Information Interchange，美国信息交换标准代码）是基于拉丁字母的一套电脑编码系统，用于显示现代英语，主要包括控制字符（回车键、退格、换行键等）和可显示字符（英文大小写字符、阿拉伯数字和西文符号）。
  * 基本的ASCII字符集，使用7位（bits）表示一个字符，共128字符。ASCII的扩展字符集使用8位（bits）表示一个字符，共256字符，方便支持**欧洲常用字符**。
* **ISO-8859-1字符集**：
  * 拉丁码表，别名Latin-1，用于**显示欧洲使用的语言，包括荷兰、丹麦、德语、意大利语、西班牙语等。**
  * ISO-5559-1使用单字节编码，兼容ASCII编码。
* **GBxxx字符集**：
  * GB就是国标的意思，是为了显示中文而设计的一套字符集。
  * **GB2312**：简体中文码表。一个小于127的字符的意义与原来相同。但两个大于127的字符连在一起时，就表示一个汉字，这样大约可以组合了**包含7000多个简体汉字**，此外数学符号、罗马希腊的字母、日文的假名们都编进去了，连在ASCII里本来就有的数字、标点、字母都统统重新编了两个字节长的编码，这就是常说的"全角"字符，而原来在127号以下的那些就叫"半角"字符了。
  * **GBK**：最常用的中文码表。是在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了**21003个汉字**，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等。
  * **GB18030**：最新的中文码表。**收录汉字70244个，**采用多字节编码，每个字可以由1个、2个或4个字节组成。支持中国国**内少数民族的文字，同时支持繁体汉字以及日韩汉字等。**
* **Unicode字符集** ：
  * Unicode编码系统为表达任意语言的任意字符而设计，是业界的一种标准，也**称为统一码、标准万国码。**
  * 它最多使用4个字节的数字来表达每个字母、符号，或者文字。有三种编码方案，UTF-8、UTF-16和UTF-32。**最为常用的UTF-8编码。**
  * UTF-8编码，可以用来表示Unicode标准中任何字符，它是电子邮件、网页及其他存储或传送文字的应用中，优先采用的编码。互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码。所以，我们开发Web应用，也要使用UTF-8编码。它使用一至四个字节为每个字符编码，编码规则：
    1. 128个US-ASCII字符，只需一个字节编码。
    2. 拉丁文等字符，需要二个字节编码。 
    3. 大部分常用字（含中文），使用三个字节编码。
    4. 其他极少使用的Unicode辅助字符，使用四字节编码。

## 4.2 编码引出的问题

- FileReader读取utf8编码的文件,中文不会乱码---->idea默认是utf8

- FileReader读取gbk编码的文件,中文就会乱码

  ```java
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 11:35
   */
  public class Test1 {
      public static void main(String[] args) throws Exception{
          // 1.创建字符输入流对象,关联数据源文件路径
          FileReader fr = new FileReader("day11\\ddd\\utf8.txt");
  
          // 2.定义一个int变量,用来存储读取到的字符数据
          int c;
  
          // 3.循环读字符数据
          while ((c = fr.read()) != -1){
              System.out.println((char)c);// 不乱码---中国
          }
  
          // 4.关闭流,释放资源
          fr.close();
  
      }
  }
  
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 11:35
   */
  public class Test2 {
      public static void main(String[] args) throws Exception{
          // 1.创建字符输入流对象,关联数据源文件路径
          FileReader fr = new FileReader("day11\\ddd\\gbk.txt");
  
          // 2.定义一个int变量,用来存储读取到的字符数据
          int c;
  
          // 3.循环读字符数据
          while ((c = fr.read()) != -1){
              System.out.println((char)c);// 乱码
          }
  
          // 4.关闭流,释放资源
          fr.close();
  
      }
  }
  
  ```
  
  





## 4.3 InputStreamReader类  

- 概述:  java.io.InputStreamReader类继承Reader类,所以也是字符输入流,可以用来读字符数据

- 构造方法:

  - `public InputStreamReader(InputStream is);创建一个转换输入流对象,使用平台默认字符编码`
- `public InputStreamReader(InputStream is,String charsetName);创建一个转换输入流对象,指定字符编码`  ------>掌握
  
- 作用:

  - 1.可以将字节输入流转换为字符输入流
  - 2.可以指定编码读数据
  
- 指定编码读取

  - 读gbk编码文件

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 11:51
     */
    public class Test1_读gbk编码文件 {
        public static void main(String[] args) throws Exception{
            // 1.创建转换输入流对象,关联数据源文件路径,指定gbk编码
            FileInputStream fis = new FileInputStream("day11\\ddd\\gbk.txt");
            InputStreamReader isr = new InputStreamReader(fis,"gbk");
    
            // 2.定义一个int变量,用来存储读取到的字符数据
            int c;
    
            // 3.循环读字符数据
            while ((c = isr.read()) != -1){
                System.out.println((char)c);
            }
    
            // 4.关闭流,释放资源
            isr.close();
    
        }
    }
    
    ```
    
    
    
  - 读utf8编码文件
  
    ```java
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 11:51
     */
    public class Test2_读utf8编码文件 {
        public static void main(String[] args) throws Exception{
            // 1.创建转换输入流对象,关联数据源文件路径,指定gbk编码
            FileInputStream fis = new FileInputStream("day11\\ddd\\utf8.txt");
            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
    
            // 2.定义一个int变量,用来存储读取到的字符数据
            int c;
    
            // 3.循环读字符数据
            while ((c = isr.read()) != -1){
                System.out.println((char)c);
            }
    
            // 4.关闭流,释放资源
            isr.close();
    
        }
    }
    
    ```
    
    

## 4.4 OutputStreamWriter类

- 概述:  java.io.OutputStreamWriter类继承Writer类,所以也是字符输出流,可以用来写字符数据

- 作用:

  - 1.可以将字节输出流转换为字符输出流
  - 2.可以指定编码写数据

- 构造方法:

  - `public OutputStreamWriter(OutputStream os);创建转换输出流对象,使用平台默认字符编码`
  - `public OutputStreamWriter(OutputStream os,String charsetName);创建转换输出流对象,指定字符编码` ------>掌握,常用

- 指定编码写数据

  - 指定gbk编码写出数据

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 11:59
     */
    public class Test1_指定gbk编码写数据 {
        public static void main(String[] args) throws Exception{
            // 1.创建转换输出流对象,关联目的地文件路径,指定gbk编码
            FileOutputStream fos = new FileOutputStream("day11\\ddd\\gbk1.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
    
            // 2.写数据
            osw.write("中国你好!");
    
            // 3.关闭流,释放资源
            osw.close();
    
        }
    }
    
    ```
    
    
    
  - 指定utf8编码写出数据
  
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 11:59
     */
    public class Test2_指定utf8编码写数据 {
        public static void main(String[] args) throws Exception{
            // 1.创建转换输出流对象,关联目的地文件路径,指定gbk编码
            FileOutputStream fos = new FileOutputStream("day11\\ddd\\utf8_2.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
    
            // 2.写数据
            osw.write("中国你好!");
    
            // 3.关闭流,释放资源
            osw.close();
    
        }
    }
    
    ```
    
    



## 4.5 转换文件编码

### 需求

- 将GBK编码的文本文件，转换为UTF-8编码的文本文件。

### 分析

1. 指定GBK编码的转换流，读取文本文件。
2. 使用UTF-8编码的转换流，写出文本文件。

### 实现

```java
/**
 * @Author PengZhiLin
 * @Date 2021/7/8 12:04
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 1.创建转换输入流对象,关联数据源文件路径,指定gbk编码
        FileInputStream fis = new FileInputStream("day11\\ddd\\gbk.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gbk");

        // 2.创建转换输出流对象,关联目的地文件路径,指定utf8编码
        FileOutputStream fos = new FileOutputStream("day11\\ddd\\gbk_utf8.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");

        // 3.定义一个int变量,用来存储读取到的字符数据
        int c;

        // 4.循环读字符数据
        while ((c = isr.read()) != -1) {
            // 5.在循环中,写字符数据
            osw.write(c);
        }

        // 6.关闭流,释放资源
        osw.close();
        isr.close();

    }
}

```



# 第五章 序列化

## 5.1 序列化和反序列化的概念

Java 提供了一种对象**序列化**的机制。用一个字节序列可以表示一个对象，该字节序列包含该`对象的数据`、`对象的类型`和`对象中存储的属性`等信息。字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息。 

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行**反序列化**。`对象的数据`、`对象的类型`和`对象中存储的数据`信息，都可以用来在内存中创建对象。看图理解序列化： ![](img/3_xuliehua.jpg)



## 5.2 ObjectOutputStream类

- 概述: java.io.ObjectOutputStream类继承OutputStream,所以是一个字节输出流,可以用来**写出字节数据**,并且**可以写对象**

- 构造方法

  - `public ObjectOutputStream(OutputStream out);创建序列化流对象,传入字节输出流`

- 序列化操作---->写对象到文件中,变成字节数据

  - `public void wirteObject(Object obj);写一个对象(序列化操作)`

- 注意:  **被序列化的对象所属的类一定要实现Serializable接口(标记接口)**

- 案例:

  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 12:21
   */
  public class Person implements Serializable {
      String name;
      int age;
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  
  ```
  
  
  
  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 12:22
   */
  public class Test {
      public static void main(String[] args) throws Exception{
          // 1.创建序列化流对象,关联目的地文件路径
          FileOutputStream fos = new FileOutputStream("day11\\eee\\person.txt");
          ObjectOutputStream oos = new ObjectOutputStream(fos);
  
          // 2.创建Person对象
          Person p = new Person("张三",18);
  
          // 3.序列化Person对象
          oos.writeObject(p);
  
          // 4.关闭流,释放资源
          oos.close();
      }
  }
  
  ```
  
  



## 5.3 ObjectInputStream类

- 概述: java.io.ObjectInputStream类继承InputStream,所以是一个字节输入流,可以用来**读字节数据**,并且**可以读对象**

- 构造方法

  - `public ObjectInputStream(InputStream in);创建反序列化流对象,传入字节输入流`

- 反序列化操作

  - `public Object readObject();重构一个对象`

- 案例:

  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 12:27
   */
  public class Test {
      public static void main(String[] args) throws Exception{
          // 1.创建反序列化流对象,关联数据源文件路径
          FileInputStream fis = new FileInputStream("day11\\eee\\person.txt");
          ObjectInputStream ois = new ObjectInputStream(fis);
  
          // 2.重构对象
          Person p = (Person) ois.readObject();
  
          // 3.关闭流,释放资源
          ois.close();
          System.out.println(p);
      }
  }
  
  ```
  
  



## 5.4 序列化和反序列化注意事项

- 序列化的注意事项

  - 被序列化的对象所属的类一定要实现Serializable接口(标记接口)

  - 被序列化的对象所有的属性也是要可以被序列化的

  - 如果序列化对象的属性不想被序列化,那么该属性就需要使用transient关键字修饰,表示瞬态

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:32
     */
    public class Pet implements Serializable {
        String name;
    
        public Pet(String name) {
            this.name = name;
        }
    
        @Override
        public String toString() {
            return "Pet{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    
    ```
    
    
    
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:31
     */
    //- 被序列化的对象所属的类一定要实现Serializable接口(标记接口)
    public class Student implements Serializable {
        String name;// 姓名
        // - 如果序列化对象的属性不想被序列化,那么该属性就需要使用transient关键字修饰,表示瞬态
        transient int age;// 年龄
        // - 被序列化的对象所有的属性也是要可以被序列化的---->Pet类实现序列化接口
        Pet pet;// 宠物
    
    
        public Student(String name, int age, Pet pet) {
            this.name = name;
            this.age = age;
            this.pet = pet;
        }
    
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", pet=" + pet +
                    '}';
        }
    }
    
    ```
    
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:31
     */
    public class Test1 {
        public static void main(String[] args) throws Exception{
            // 1.创建Student对象,创建Pet对象
            Pet p = new Pet("阿财");
            Student stu = new Student("张三", 18, p);
    
            // 2.创建序列化流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day11\\eee\\student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
    
            // 3.序列化Student对象
            oos.writeObject(stu);
    
            // 4.关闭流,释放资源
            oos.close();
    
        }
    }
    
    ```
    
    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:37
     */
    public class Test2 {
        public static void main(String[] args) throws Exception{
            // 1.创建反序列化流对象,关联数据源文件路径
            FileInputStream fis = new FileInputStream("day11\\eee\\student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
    
            // 2.重构对象
            Student stu = (Student) ois.readObject();
            System.out.println(stu);
    
            // 3.关闭流,释放资源
            ois.close();
    
        }
    }
    
    ```
    
    
  
- 反序列化的注意事项

  - 1.如果要反序列化成功,一定要能够找到该类的class文件,否则反序列化会失败

  - 2.如果能找到该类的class文件,但序列化后又修改了类,这个时候也会反序列化失败-->解决加版本号

    ```java
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:31
     */
    public class Student implements Serializable {
        // 版本号
        static final long serialVersionUID = 2L;
    
        String name;// 姓名
        int age;// 年龄
        String sex;// 性别
    
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:31
     */
    public class Test1 {
        public static void main(String[] args) throws Exception{
            // 1.创建Student对象
            Student stu = new Student("张三", 18);
    
            // 2.创建序列化流对象,关联目的地文件路径
            FileOutputStream fos = new FileOutputStream("day11\\eee\\student1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
    
            // 3.序列化Student对象
            oos.writeObject(stu);
    
            // 4.关闭流,释放资源
            oos.close();
    
        }
    }
    
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 14:37
     */
    public class Test2 {
        public static void main(String[] args) throws Exception{
            // 1.创建反序列化流对象,关联数据源文件路径
            FileInputStream fis = new FileInputStream("day11\\eee\\student1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
    
            // 2.重构对象
            Student stu = (Student) ois.readObject();
            System.out.println(stu);
    
            // 3.关闭流,释放资源
            ois.close();
    
        }
    }
    
    ```
    
    
  
  

## 5.5 序列化集合

### 需求

1. 将存有多个自定义对象的集合序列化操作，保存到`list.txt`文件中。
2. 反序列化`list.txt` ，并遍历集合，打印对象信息。

### 实现

- Person类

  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 12:21
   */
  public class Person implements Serializable {
      String name;
      int age;
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  
  ```
  
  
  
- 序列化

  ```java
  
  import com.itheima.bean.Person;
  
  import java.io.FileOutputStream;
  import java.io.ObjectOutputStream;
  import java.util.ArrayList;
  
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 14:57
   */
  public class Test1 {
      public static void main(String[] args) throws Exception{
          // 1.创建ArrayList集合,限制集合元素类型为Person类型
          ArrayList<Person> list = new ArrayList<>();
  
          // 2.创建多个Person对象,并添加到集合中
          Person p1 = new Person("张三1",18);
          Person p2 = new Person("张三2",28);
          Person p3 = new Person("张三3",38);
          Person p4 = new Person("张三4",48);
          Person p5 = new Person("张三5",58);
          list.add(p1);
          list.add(p2);
          list.add(p3);
          list.add(p4);
          list.add(p5);
  
          // 3.创建序列化流对象,关联目的地文件路径
          FileOutputStream fos = new FileOutputStream("day11\\eee\\list.txt");
          ObjectOutputStream oos = new ObjectOutputStream(fos);
  
          // 4.序列化集合对象
          oos.writeObject(list);
  
          // 5.关闭流,释放资源
          oos.close();
  
      }
  }
  
  ```
  
  
  
- 反序列化

  ```java
  /**
   * @Author PengZhiLin
   * @Date 2021/7/8 15:00
   */
  public class Test2 {
      public static void main(String[] args) throws Exception{
          // 1.创建反序列化流对象,关联数据源文件路径
          FileInputStream fis = new FileInputStream("day11\\eee\\list.txt");
          ObjectInputStream ois = new ObjectInputStream(fis);
  
          // 2.重构对象
          ArrayList<Person> list = (ArrayList<Person>) ois.readObject();
  
          // 3.关闭流,释放资源
          ois.close();
  
          // 4.打印集合
          for (Person p : list) {
              System.out.println(p);
          }
      }
  }
  
  ```
  
  

#  第六章 打印流

- 概述: java.io.PrintStream类继承OutputStream,也是一个字节输出流,可以用来写出字节数据

- 作用: **可以方便打印输出各种类型的数据**

- 使用:

  - 构造方法: 

    - `public PrintStream(String fileName);创建一个打印流对象,通过参数关联目的地文件路径`

  - 成员方法:

    - `public void print(任意类型);打印任意类型的数据到目的地文件中,打印完不换行`
    - `public void println(任意类型);打印任意类型的数据到目的地文件中,打印完换行`

  - 案例:

    ```java
    import java.io.PrintStream;
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 15:08
     */
    public class Test1 {
        public static void main(String[] args) throws Exception{
            // 1.创建打印流对象,关联目的地文件路径
            PrintStream ps = new PrintStream("day11\\fff\\a.txt");
    
            // 2.打印各种类型的数据到目的地文件中
            ps.print(97);
            ps.print(true);
            ps.print(3.14);
            ps.print('a');
    
            // 换行
            ps.println();
            
            ps.println(97);
            ps.println(true);
            ps.println(3.14);
            ps.println('a');
    
            // 3.关闭流,释放资源
            ps.close();
    
        }
    }
    ```
    
    ```java
    import java.io.PrintStream;
    
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 15:08
     */
    public class Test2 {
        public static void main(String[] args) throws Exception{
            // System类中的PrintStream默认打印到控制台
            System.out.println("HelloWorld!-----1");
    
            PrintStream ps = System.out;
            ps.println("HelloWorld!-----2");
    
            System.out.println("---------------");
            // 改变系统中PrintStream打印流的目的地
            PrintStream ps1 = new PrintStream("day11\\fff\\b.txt");
            System.setOut(ps1);
            System.out.println("HelloWorld!-----3");
    
    
        }
    }
    
    ```
    
    



# 第七章 装饰设计模式

#### 装饰模式概述

在我们今天所学的缓冲流中涉及到java的一种设计模式，叫做装饰模式，我们来认识并学习一下这个设计模式。

**装饰模式指的是在不改变原类, 不使用继承的基础上，动态地扩展一个对象的功能。**

**装饰模式遵循原则:**

1. 装饰类和被装饰类必须实现相同的接口
2. 在装饰类中必须传入被装饰类的引用
3. 在装饰类中对需要扩展的方法进行扩展
4. 在装饰类中对不需要扩展的方法调用被装饰类中的同名方法

#### 案例演示

##### 准备环境:

1. 编写一个Star接口, 提供sing 和 dance抽象方法
2. 编写一个LiuDeHua类,实现Star接口,重写抽象方法

```java
public interface Star {
    public void sing();
    public void dance();
}
```

```java
public class LiuDeHua implements Star {
    @Override
    public void sing() {
        System.out.println("刘德华在唱忘情水...");
    }
    @Override
    public void dance() {
        System.out.println("刘德华在跳街舞...");
    }
}
```

##### 需求:

​	在不改变原类,不继承重写的基础上对LiuDeHua类的sing方法进行扩展,dace方法不扩展

##### 实现步骤:

```java
/**
 * @Author PengZhiLin
 * @Date 2021/7/8 15:35
 */
// 装饰类
// 1.装饰类和被装饰类必须实现相同的接口
public class LiuDeHuaWrapper implements Star{

    // 2.在装饰类中必须传入被装饰类的引用
    LiuDeHua ldh;

    public LiuDeHuaWrapper(LiuDeHua ldh) {
        this.ldh = ldh;
    }

    @Override
    public void sing() {
        // 需要增强
        // 3.在装饰类中对需要扩展的方法进行扩展
        System.out.println("刘德华在唱忘情水...");
        System.out.println("刘德华在唱冰雨...");
        System.out.println("刘德华在唱练习...");
        System.out.println("刘德华在唱爱你一万年...");
    }

    @Override
    public void dance() {
        // 不需要增强
        // 4.在装饰类中对不需要扩展的方法调用被装饰类中同名的方法
        ldh.dance();
    }
}

```

```java

/**
 * @Author PengZhiLin
 * @Date 2021/7/8 15:29
 */
public class Test {
    public static void main(String[] args) {
        // 创建LiuDeHua对象
        LiuDeHua ldh = new LiuDeHua();
        //ldh.sing();
        //ldh.dance();

        // 得到增强的刘德华对象
        LiuDeHuaWrapper ldhw = new LiuDeHuaWrapper(ldh);
        ldhw.sing();
        ldhw.dance();

    }
}

```





# 第八章 commons-io工具包

#### commons-io工具包的概述

commons-io是apache开源基金组织提供的一组有关IO操作的类库，可以挺提高IO功能开发的效率。commons-io工具包提供了很多有关io操作的类，见下表：

| 包                                  | 功能描述                                     |
| ----------------------------------- | :------------------------------------------- |
| org.apache.commons.io               | 有关Streams、Readers、Writers、Files的工具类 |
| org.apache.commons.io.input         | 输入流相关的实现类，包含Reader和InputStream  |
| org.apache.commons.io.output        | 输出流相关的实现类，包含Writer和OutputStream |
| org.apache.commons.io.serialization | 序列化相关的类                               |

#### commons-io工具包的使用  

步骤：

1. 下载commons-io相关jar包；http://commons.apache.org/proper/commons-io/
2. 把commons-io-2.7.jar包复制到指定的Module的lib目录中
3. 将commons-io-2.7.jar加入到classpath路径中----选中jar包 , 右键add as library, 确认

#### commons-io工具包中的常用类

- commons-io提供了一个工具类  org.apache.commons.io.IOUtils，封装了大量IO读写操作的代码。其中有两个常用方法：

> 1. public static int copy(InputStream in, OutputStream out)； 把input输入流中的内容拷贝到output输出流中，返回拷贝的字节个数(适合文件大小为2GB以下)
> 2. public static long copyLarge(InputStream in, OutputStream out)；把input输入流中的内容拷贝到output输出流中，返回拷贝的字节个数(适合文件大小为2GB以上)

文件复制案例演示：

~~~java
/**
 * @Author PengZhiLin
 * @Date 2021/7/8 16:19
 */
public class Test1_IOUtils {
    public static void main(String[] args) throws Exception{
        // 创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\aaa\\hb.jpg");
        // 创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\fff\\hbCopy1.jpg");
        // 使用IOUtils调用copy方法进行拷贝
        IOUtils.copy(fis,fos);
        // 释放资源
        fos.close();
        fis.close();

    }
}

~~~

- commons-io还提供了一个工具类org.apache.commons.io.FileUtils，封装了一些对文件操作的方法：

> 1. public static void copyFileToDirectory(final File srcFile, final File destFile) //复制文件到另外一个目录下。
> 2. public static void copyDirectoryToDirectory( File file1 ,File file2 );//复制file1目录到file2位置。

案例演示：

~~~java
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Author PengZhiLin
 * @Date 2021/7/8 16:23
 */
public class Test2_FileUtils {
    public static void main(String[] args) throws Exception{
        File f1 = new File("day11\\aaa\\hb.jpg");
        File f2 = new File("day11\\fff");
        FileUtils.copyFileToDirectory(f1,f2);
    }
}

~~~

```java

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Author PengZhiLin
 * @Date 2021/7/8 16:23
 */
public class Test3_FileUtils {
    public static void main(String[] args) throws Exception{
        File f1 = new File("day11\\aaa");
        File f2 = new File("day11\\fff");
        FileUtils.copyDirectoryToDirectory(f1,f2);
    }
}

```



# 总结

```java
必须练习:
	1.IO异常的处理----jdk7前,jdk7
    2.属性集-->加载配置文件数据,然后遍历
    3.字节缓冲流高效拷贝文件; 字符缓冲流恢复文本顺序
    4.转换流:  转换文件编码的案例
    5.装饰者设计模式
    6.commons-io--->拷贝文件,拷贝文件夹

- 能够使用Properties的load方法加载文件中配置信息
   public Properties() :创建一个空的属性列表。
   public void load(InputStream inStream)： 从字节输入流中读取键值对。
   public void load(Reader reader) 从字符输入流中读取键值对。
    
   public Set<String> stringPropertyNames() ：所有键的名称的集合。
   public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
   public Object setProperty(String key, String value) ： 保存一对属性。  
 

 
- 能够使用字节缓冲流读取数据到程序
    BufferedInputStream: public BufferedInputStream(InputStream is);
	使用InputStream中的读数据方法
    
- 能够使用字节缓冲流写出数据到文件
    BufferedOutputStream: public BufferedOutputStream(OutputStream os);
	使用OutputStream中的写数据方法 
        
- 能够明确字符缓冲流的作用和基本用法
    BufferedReader: 
			public BufferedReader(Reader r);
			public String readLine();
	BufferedWriter:
			public BufferedWriter(Writer w);
			public void newLine();

- 能够使用缓冲流的特殊功能
   字节缓冲流: 提高读写效率
   字符缓冲流: 读一行,根据系统自动写行分隔符
       
- 能够阐述编码表的意义
    定义了字符和二进制数对应的规则
       
- 能够使用转换流读取指定编码的文本文件
    InputStreamReader: public InputStreamReader(InputStream is,String charset)
       
- 能够使用转换流写入指定编码的文本文件
    OutputStreamWriter: public  OutputStreamWriter(OutputStream os,String charset)
        
- 能够使用序列化流写出对象到文件
    ObjectOutputStream: public ObjectOutputStream(OutputStream os);
						public void writeObject(Object obj);
- 能够使用反序列化流读取文件到程序中
    ObjectInputStream: public ObjectInputStream(InputStream is);
					   public Object readObject();
- 能够理解装饰模式的实现步骤
    1.装饰类和被装饰类需要实现同一个接口
    2.装饰类中需要接收被装饰类的引用
    3.在装饰类中对需要扩展的方法进行扩展
    4.在装饰类中对不需要扩展的方法调用被装饰类中同名的方法
    
- 能够使用commons-io工具包
 1.下载jar包
 2.拷贝jar包到模块下
 3.把jar包添加到classpath路径下
 4.使用工具类调用方法
    
```

# 扩展-写数据到配置文件中

- 需求: 修改配置文件中k3这个键对应的值为value3

- 文件:

  ```java
  k1=v1
  k2=v2
  k3=v3
  k4=v4
  ```

- 分析:

  - 创建Properties对象
  - 调用load方法加载配置文件中的键值对数据
  - 获取所有的键
  - 循环遍历所有的键
  - 在循环中,判断遍历出来的键是否是k3,如果是就修改值为value3
  - 把Properties对象中所有的键值对写回配置文件中

- 实现

  - `public void store(OutputStream os,String comments) 把Properties对象中的键值对通过输出流写回配置文件中`

  - `public void store(Writer w,String comments) 把Properties对象中的键值对通过输出流写回配置文件中`

    ```java
    /**
     * @Author PengZhiLin
     * @Date 2021/7/8 16:44
     */
    public class Test {
        public static void main(String[] args) throws Exception {
            //- 创建Properties对象
            Properties pro = new Properties();
    
            //- 调用load方法加载配置文件中的键值对数据
            pro.load(new FileInputStream("day11\\ggg\\a.properties"));
    
            //- 获取所有的键
            Set<String> keys = pro.stringPropertyNames();
    
            //- 循环遍历所有的键
            for (String key : keys) {
                //- 在循环中,判断遍历出来的键是否是k3,如果是就修改值为value3
                if ("k3".equals(key)){
                    pro.setProperty(key,"value3");
                    //pro.setProperty(key,"中文");
                }
            }
    
            //- 把Properties对象中所有的键值对写回配置文件中
            pro.store(new FileOutputStream("day11\\ggg\\a.properties"),"itheima");
        //pro.store(new FileWriter("day11\\ggg\\a.properties"),"itheima");
        }
  }
    
    ```
    
    
  
  






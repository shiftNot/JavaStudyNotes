# day11【IO异常处理、属性集、缓冲流、转换流、序列化流、打印流、装饰者模式、commons-io工具包】

# 今日内容

- IO异常的处理
  - try--catch--finally
  - try--with--resouce
- Properties类
  - 构造方法
  - 常用方法
- 缓冲流
  - 字节缓冲流
  - 字符缓冲流
- 转换流
  - 字符编码与字符集
  - 转换输入流
  - 转换输出流
- 序列化流
  - 序列化流
  - 反序列化流
- 打印流
- 装饰者模式
- commons-io工具包

# 教学目标

- [ ] 能够使用属性集的load方法加载文件中配置信息
- [ ] 能够使用字节缓冲流读取数据到程序
- [ ] 能够使用字节缓冲流写出数据到文件
- [ ] 能够明确字符缓冲流的作用和基本用法
- [ ] 能够使用缓冲流的特殊功能
- [ ] 能够阐述编码表的意义
- [ ] 能够使用转换流读取指定编码的文本文件
- [ ] 能够使用转换流写入指定编码的文本文件
- [ ] 能够使用序列化流写出对象到文件
- [ ] 能够使用反序列化流读取文件到程序中
- [ ] 能够理解装饰模式的实现步骤
- [ ] 能够使用commons-io工具包

# 第一章 IO异常的处理

## 知识点-- IO异常的处理

### 目标

- 知道如何处理IO中的异常

### 路径

- 概述
- 演示jdk1.7之前的处理方式
- 演示jdk1.7之后的处理方式

### 讲解

#### 1.1概述

实际开发中，建议使用`try...catch...finally` 代码块，处理IO中的异常部分，其中finally用来确保关闭资源。

但是在JDK1.7提供了优化后的`try-with-resource` 语句，该语句确保了每个资源在语句结束时关闭。所谓的资源（resource）是指在程序完成后，必须关闭的对象。

格式：

```
try (创建流对象语句，如果多个,使用分号隔开) {
	// 操作
} catch (IOException e) {
	e.printStackTrace();
}
```

#### 1.2演示两种异常处理方式

需求:通过字符输出流演示IO中的两种异常处理方式

//测试类代码

```java  
public class Test {
    public static void main(String[] args) {
        //方式1:try...catch...finally
        method1();
        //方式2:try-with-resource
        method2();
    }

    public static void method2() {
        try (FileWriter fw = new FileWriter("day11_01IO异常处理\\a2.txt")) {
            fw.write("黑马程序员");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method1() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("day11_01IO异常处理\\a1.txt");
            fw.write("黑马程序员");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 小结

```

```

# 第二章 属性集

## 知识点-- 属性集基本使用

### 目标

- 学会使用属性集的基本操作


### 路径

- 概述
- 构造方法
- 常用方法介绍
- 演示属性集的基本使用

### 讲解

#### 2.1概述

`java.util.Properties` 继承于Hashtable，表示一个持久的属性集。
它使用键值结构存储数据，每个键及其对应值都是一个字符串。
该类被许多Java类使用，比如获取系统属性时，System.getProperties()就是返回Properties对象。

#### 2.2 构造方法

- `public Properties()` :创建一个空的属性列表。

#### 2.3 常用方法

- `public Object setProperty(String key, String value)`: 保存一对属性。  
- `public String getProperty(String key) `:使用此属性列表中指定的键搜索属性值。
- `public Set<String> stringPropertyNames() `:所有键的名称的集合。

#### 2.4演示属性集的基本使用

需求：演示属性集构造方法和常用方法

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建属性集对象
        Properties p = new Properties();
        //添加数据
        p.setProperty("姓名", "张三");
        p.setProperty("身高", "1.80");
        p.setProperty("年龄", "26");
        //获取所有键的集合
        Set<String> keys = p.stringPropertyNames();
        //通过循环获取所有键，展示所有键值对
        for (String key : keys) {
            String value = p.getProperty(key);
            System.out.println("key=" + key + "---value=" + value);
        }
    }
}
```

小结

```

```

## 知识点-- 属性集的IO流操作

### 目标

- 学会使用属性集中的流操作


### 路径

- 概述
- 常用方法
- 演示属性集与流相关的方法

### 讲解

#### 2.2.1 概述

通过流对象，可以关联到某文件上，针对键值对在属性集与文本之间做存取键值对数据的操作。

存储或读取的文本内容格式：键=值(每行一对数据)

```
例如:
filename=a.txt
length=209385038
location=D:\a.txt
```

#### 2.2.2常用方法

- `public void load(InputStream inStream)`： 从字节输入流中读取键值对。 
- `public void load(Reader reader)`:从字符输入流中读取键值对。 
- `public void store(OutputStream out,String comments)`：用字节输出流写出键值对
- `public void store(Writer writer,String comments)`:用字符输出流写出键值对。 

#### 2.2.3 演示属性集与流相关的方法

需求：使用属性集的字符流形式，将“name=张三”从b1文件取出，并存储到b2文本文件。

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //创建属性集对象
        Properties p = new Properties();
        //创建字节输入流
        Reader r = new FileReader("day11_02属性集\\b1.txt");
        //创建字节输出流
        Writer w = new FileWriter("day11_02属性集\\b2.txt");
        //从b1文件将键值对数据加载到属性集对象中
        p.load(r);
        // System.out.println("name="+p.getProperty("name"));
        p.store(w, "name");
        //关闭输入流
        r.close();
        //关闭输出流
        w.close();
    }
}
```

> 小贴士：文本中的数据，必须是键值对形式，可以使用空格、等号、冒号等符号分隔。

### 小结

```

```



# 第三章 缓冲流

## 知识点 -- 概述

### 目标

- 了解什么是缓冲流


### 路径

- 概述
- 分类

### 讲解

#### 3.2.1概述

缓冲流能够进行高效读写,也叫高效流，是对4个基本的`FileXxx` 流的包装和增强，所以也是4个流

缓冲流基本原理，是在创建流对象时，创建内置默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，提高读写的效率。

查询API，可以发现缓冲流读写方法与基本的流一致，可以通过计算操作时间判断不同流的使用效率。

#### 3.2.2分类

- 字节缓冲流：BufferedInputStream，BufferedOutputStream 
- 字符缓冲流：BufferedReader，BufferedWriter

### 小结

```

```

## 知识点 -- 字节缓冲流

### 目标

- 学会使用字节缓冲流


### 路径

- 构造方法
- 演示不同流的拷贝效率

### 讲解

#### 3.2.1构造方法

- `public BufferedInputStream(InputStream in)`:创建一个 新的字节缓冲输入流。 
- `public BufferedOutputStream(OutputStream out)`： 创建一个新的字节缓冲输出流。

#### 3.2.2演示不同流的拷贝效率

需求:分别通过普通字节流和缓冲字节流，以单个读取，数组读取测试读写一个5M图片效率上的差别。

//基本流代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //普通流单个字节读写
        method1();//21173毫秒
        //普通流数组读写
        method2();//8毫秒
        //缓冲流单个字节读写
        method3();//40毫秒
        //缓冲流数组读写
        method4();//
    }

    public static void method4() throws IOException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //获取缓冲字节流对象
        FileInputStream fis = new FileInputStream("day11_03缓冲流\\image.jpg");
        FileOutputStream fos = new FileOutputStream("day11_03缓冲流\\image_copy04.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 缓冲流数组读写
        int len = -1;
        byte[] bys = new byte[1 * 1024];
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //计算所用时间
        long useTime = endTime - startTime;
        System.out.println("本次拷贝总共用了" + useTime + "毫秒");
    }

    public static void method3() throws IOException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //获取缓冲字节流对象
        FileInputStream fis = new FileInputStream("day11_03缓冲流\\image.jpg");
        FileOutputStream fos = new FileOutputStream("day11_03缓冲流\\image_copy03.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 缓冲流单个字节读写
        int b = -1;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bis.close();
        bos.close();
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //计算所用时间
        long useTime = endTime - startTime;
        System.out.println("本次拷贝总共用了" + useTime + "毫秒");
    }

    public static void method2() throws IOException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //获取基本的字节流对象
        FileInputStream fis = new FileInputStream("day11_03缓冲流\\image.jpg");
        FileOutputStream fos = new FileOutputStream("day11_03缓冲流\\image_copy02.jpg");
        // 普通流数组读写
        int len = -1;
        byte[] bys = new byte[1 * 1024];
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }
        fis.close();
        fos.close();
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //计算所用时间
        long useTime = endTime - startTime;
        System.out.println("本次拷贝总共用了" + useTime + "毫秒");
    }

    public static void method1() throws IOException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //获取基本的字节流对象
        FileInputStream fis = new FileInputStream("day11_03缓冲流\\image.jpg");
        FileOutputStream fos = new FileOutputStream("day11_03缓冲流\\image_copy01.jpg");
        //基本流单个字节读取
        int b = -1;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //计算所用时间
        long useTime = endTime - startTime;
        System.out.println("本次拷贝总共用了" + useTime + "毫秒");
    }
}
```

### 小结

```

```

## 知识点 -- 字符缓冲流

### 目标

- 学会使用字符缓冲流


### 路径

- 构造方法
- 特有方法
- 演示特有方法的使用

### 讲解
#### 3.3.1构造方法

* `public BufferedReader(Reader in)`:创建一个 新的缓冲输入流。 
* `public BufferedWriter(Writer out)`： 创建一个新的缓冲输出流。

#### 3.3.2特有方法

BufferedReader类：`public String readLine()`: 读一行文字，读取不到内容，返回null。 

BufferedWriter：`public void newLine()`: 写一行行分隔符,由系统属性定义符号。

#### 3.3.2演示特有方法的使用

需求：将黑马程序员每个字逐行写入文本，再文件中一次读取一行内容。

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //将黑马程序员写入到文本中
        method1();
        //从文件中按行读取
        method2();
    }

    public static void method2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day11_03缓冲流\\a.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void method1() throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter("day11_03缓冲流\\a.txt"));
        br.write("黑");
        br.newLine();
        br.write("马");
        br.newLine();
        br.write("程");
        br.newLine();
        br.write("序");
        br.newLine();
        br.write("员");
        br.newLine();
        br.close();
    }
}
```

### 小结

```

```

## 案例 - 3.4 练习: 文本排序

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

1. 逐行读取文本信息。
2. 解析文本信息到集合中。
3. 遍历集合，按顺序，写出文本信息。

### 实现

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //定义缓冲字符输入流
        BufferedReader br = new BufferedReader(new FileReader("day11_03缓冲流\\sort.txt"));
        //定义map集合
        HashMap<String, String> hm = new HashMap<>();
        //按行读取数据，将序号与内容解析后，并将数据存储到map集合
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] strs = line.split("\\.");
            String key = strs[0];
            String value = strs[1];
            hm.put(key, value);
        }
        //关闭输入流
        br.close();
        //获取键列的集合，并对键列做排序
        Set<String> set = hm.keySet();
        //创建缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("day11_03缓冲流\\newsort.txt"));
        //将文本内容按照排序后的顺序重新存储
        for (String key : set) {
            String cotent = key + "." + hm.get(key);
            bw.write(cotent);
            bw.newLine();
        }
        bw.close();
    }
}
```

# 第四章 转换流

## 知识点 -- 字符编码和字符集

### 目标

- 学会使用转换流


### 路径

- 概述
- 字符编码
- 字符集
- 演示乱码的问题

### 讲解

#### 4.1.1 概述

转换流能够进行转换编码，同一个系统中，输出输入流没有指定编码时，默认使用系统定义的编码。

不同的系统，进行读取，可能会出现编码不同而导致的乱码问题。

如何保证拷贝到的内容正确，是转换流可以解决的问题。需要理解编码和读写的数据之间的关系。

#### 4.1.2字符编码

字符编码`Character Encoding` : 就是一套自然语言的字符与二进制数之间的对应规则。

计算机中的信息都是以二进制数储存，我们看到的数字、英文、标点、汉字等字符是二进制数转换之后的结果。

编码(字符-->二进制数):按照指定规则，将字符用对应数值存储到计算机中，称为编码 。

解码(二进制数-->字符):将计算机中的二进制数按照指定规则解析出来，称为解码 。

比如说，按照A规则存储，同样按照A规则解析，那么就能显示正确的文本符号。反之，按照A规则存储，再按照B规则解析，就会导致乱码现象。

#### 4.1.3字符集

**字符集 `Charset`**：也叫编码表。是一个系统支持的所有**字符的集合**，包括各国家文字、标点、图形、数字等。

计算机要准确的存储和识别各种字符集符号，需要进行字符编码，一套字符集至少有一套字符编码。常见字符集有ASCII字符集、GBK字符集、Unicode字符集等。

![](./day11-imgs/1_charset.jpg)

即指定了**编码**，对应的字符集就指定了，所以**编码**才是我们最终要关心的。

**ASCII字符集**:

- ASCII（American Standard Code for Information Interchange，美国信息交换标准代码）是基于拉丁字母的一套电脑编码系统，用于显示现代英语，主要包括控制字符（回车键、退格、换行键等）和可显示字符（英文大小写字符、阿拉伯数字和西文符号）。
- 基本的ASCII字符集，使用7位（bits）表示一个字符，**共128字符**。ASCII的扩展字符集使用8位（bits）表示一个字符，**共256字符，方便支持欧洲常用字符。**

**ISO-8859-1字符集**：

- 拉丁码表，别名Latin-1，用于显示欧洲使用的语言，包括荷兰、丹麦、德语、意大利语、西班牙语等。
- ISO-5559-1使用单字节编码，兼容ASCII编码。

**GBxxx字符集**：

- GB就是国标的意思，是为了显示中文而设计的一套字符集。
- **GB2312**：简体中文码表。一个小于127的字符的意义与原来相同。但两个大于127的字符连在一起时，就表示一个汉字，这样大约可以组合了**包含7000多个简体汉字**，此外数学符号、罗马希腊的字母、日文的假名们都编进去了，连在ASCII里本来就有的数字、标点、字母都统统重新编了两个字节长的编码，这就是常说的"全角"字符，而原来在127号以下的那些就叫"半角"字符了。
- **GBK：最常用的中文码表**。是在GB2312标准基础上的扩展规范，使用了双字节编码方案，**共收录了21003个汉字**，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等。
- **GB18030****：最新的中文码表。收录汉字70244个**，采用多字节编码，每个字可以由1个、2个或4个字节组成。支持中国国内少数民族的文字，同时支持繁体汉字以及日韩汉字等。

**Unicode字符集**:

- Unicode编码系统为表达任意语言的任意字符而设计，是业界的一种标准，也称为**统一码、标准万国码。**
- 它最多使用4个字节的数字来表达每个字母、符号，或者文字。有三种编码方案，UTF-8、UTF-16和UTF-32。最为常用的UTF-8编码。
- **UTF-8编码**，可以用来表示Unicode标准中任何字符，它是电子邮件、网页及其他存储或传送文字的应用中，优先采用的编码。互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码。所以，我们开发Web应用，也要使用UTF-8编码。它使用一至四个字节为每个字符编码，编码规则：
  1. 128个US-ASCII字符，只需一个字节编码。
  2. 拉丁文等字符，需要二个字节编码。 
  3. 大部分常用字（含中文），使用三个字节编码。
  4. 其他极少使用的Unicode辅助字符，使用四字节编码。

#### 4.1.4演示乱码的问题

需求：演示IDEA读取windows系统创建的文件中内容，显示到控制台上的乱码问题

```
IDEA的设置，都是默认的`UTF-8`编码，如果是windows中创建的文件，一般默认都是GBK编码， 在IDEA中读取就会出现乱码。
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //创建字符输入流对象
        FileReader fr = new FileReader("day11_04转换流\\GBKcontent.txt");
        //读取数据
        int b = -1;
        while ((b = fr.read()) != -1) {
            System.out.println((char) b);
        }
        //关闭流对象
        fr.close();
    }
}

```

那么如何读取GBK编码的文件呢？ 

#### 4.1.4转换流理解图解

**转换流是字节与字符间的桥梁！**![](./day11-imgs/2_zhuanhuan.jpg)

### 小结

```

```



## 知识点 -- 转换输入流

### 目标

- 学会使用转换输入流


### 路径

- 概述
- 构造方法
- 演示指定编码读取

### 讲解

#### 4.2.1概述

`java.io.InputStreamReader`转换输入流，Reader的子类。是从字节流到字符流的桥梁。

可以指定字符集读取字节将其解码为字符，它的字符集可由名称指定，也可接受平台的默认字符集。

#### 4.2.2构造方法

* `InputStreamReader(InputStream in)`: 创建使用默认字符集的字符输入流。 
* `InputStreamReader(InputStream in, String charsetName)`: 创建指定字符集的字符输入流。

#### 4.2.3演示指定编码读取数据

需求：使用默认编码与指定编码读取系统创建的文件中内容，并显示到控制台

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //使用默认编码表
        method1();
        System.out.println("--------");
        //使用GBK码表读取
        method2();
    }

    public static void method1() throws IOException {
        //创建默认编码格式的转换输入流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day11_04转换流\\GBKcontent.txt"));
        //使用转换输入流独对象读取数据
        int b = -1;
        while ((b = isr.read()) != -1) {
            System.out.println((char) b);
        }
        isr.close();
    }

    public static void method2() throws IOException {
        //创建转换输入流对象，并指定读取时的编码表为BGK
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day11_04转换流\\GBKcontent.txt"), "GBK");
        //使用转换输入流独对象读取数据
        int b = -1;
        while ((b = isr.read()) != -1) {
            System.out.println((char) b);
        }
        isr.close();
    }
}
```

### 小结

```

```




## 知识点 -- 转换输出流

### 目标
- 学会使用转换输出流


### 路径
- 概述
- 构造方法
- 演示指定编码写出数据
- 转换流理解图解

### 讲解

#### 4.3.1概述

`java.io.OutputStreamWriter` 转换输出流，是Writer的子类，是字符流到字节流的桥梁。

可以指定字符集写出字符将其编码为字节。它的字符集可由名称指定，也可接受平台的默认字符集。 

#### 4.3.2构造方法

- `OutputStreamWriter(OutputStream in)`: 创建使用默认字符集的字符流。 
- `OutputStreamWriter(OutputStream in, String charsetName)`: 创建指定字符集的字符流。

#### 4.3.3演示指定编码写出数据

需求：使用默认编码与指定编码将"黑马程序员"写出到文件中。

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //使用默认编码表
        method1();
        //使用指定编码表
        method2();
    }

    public static void method2() throws IOException {
        //定义默认编码的转换输出流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day11_04转换流\\GBKcontent2.txt"),"gbk");
        //写出数据
        osw.write("黑马程序员");
        osw.close();
    }

    public static void method1() throws IOException {
        //定义默认编码的转换输出流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day11_04转换流\\GBKcontent1.txt"));
        //写出数据
        osw.write("黑马程序员");
        osw.close();
    }
}
```



# 第五章 序列化

## 知识点 -- 序列化概述

### 目标

- 理解什么是序列化

### 路径

- 序列化概述

### 讲解

#### 5.1序列化概述



Java 提供了一种对象序列化和反序列化的机制。序列化流能够进行持久化存储对象，序列化中的输出流, 也叫做序列化流.序列化中的输入流,,叫做反序列化流

**序列化**：

该字节序列包含该`对象的数据`、`对象的类型`和`对象中存储的属性`等信息。

字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息。 

**反序列化**：

将该字节序列从文件中读取回来，根据存储的`对象的数据`、`对象的类型`和`对象中存储的数据`重构对象。

![](day11-imgs/3_xuliehua(1).jpg)

### 小结

```

```



## 知识点 -- 序列化流

### 目标

- 学会使用序列化流


### 路径

- 概述
- 构造方法
- 常用方法
- 演示序列化操作

### 讲解

####  5.2.1概述

`java.io.ObjectOutputStream ` 类(序列化流)，将Java对象的原始数据类型写出到文件,实现对象的持久存储。

一个对象要想序列化，必须满足两个条件:

* 类实现java.io.Serializable标记接口，否则会抛出NotSerializableException。
* 属性默认可序列化。如果某属性不想序列化，须注明瞬态transient 关键字修饰。

#### 5.2.2构造方法

* `public ObjectOutputStream(OutputStream out) `： 创建一个指定序列化流对象，需要传入一个字节输出流对象。

#### 5.2.3特有方法

`public final void writeObject (Object obj)` : 将指定的对象以字节方式写出到指定文件中。

#### 5.2.4演示序列化操作

需求：通过如下类演示对象的序列化操作

```java
员工
	属性：姓名，地址，年龄(瞬态属性)
	行为：展示员工信息
```

//员工类代码

```java
public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int age;

    public Employee() {
    }

    public Employee(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
   //省略get/set

    public void show() {
        System.out.println("姓名=" + name + "---address=" + address + "---age=" + age);
    }
}
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //创建员工类对象
        Employee e = new Employee("张三", "上海", 18);
        //创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day11_05序列化流\\Employee.txt"));
        //写出对象数据
        oos.writeObject(e);//java.io.NotSerializableException: com.itheima01_序列化概述与序列化流.Employee
        //关闭流对象
        oos.close();
    }
}
```

### 小结

```

```



## 知识点 --  反序列化流

### 目标

- 学会使用反序列化流


### 路径

- 概述
- 构造方法
- 常用方法
- 演示反序列化操作

### 讲解

#### 5.3.1概述

ObjectInputStream类(反序列化流)，将使用ObjectOutputStream序列化的原始数据恢复为对象。 

如果能找到该对象的class文件，可以调用`ObjectInputStream`读取的方法，进行反序列化操作。

注意:反序列化时，使用的class文件，必须和序列化时用的是同一个。

#### 5.3.2构造方法

* `public ObjectInputStream(InputStream in) `： 创建一个指定反序列化流对象，需要传入一个字节输入流对象。

#### 5.3.3特有方法

- `public final Object readObject ()` : 从指定的路径，读取一个对象的字节数据，并返回该对象。

#### 5.3.4演示反序列化操作

需求：演示员工类的代码进行反序列化操作

//员工类代码

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day11_05序列化流\\Employee.txt"));
        //使用反序列化流的特有方法， 读取字节数据，获取对象
        Object o = ois.readObject();
        //将o强转为Employee类型
        Employee e = (Employee) o;
        e.show();
        //关闭流对象
        ois.close();
    }
}
```

### 小结

```

```



## 知识点 --  反序列化存在的问题与处理

### 目标

- 掌握反序列化的问题处理方法


### 路径

- 反序列化问题
- 演示反序列化操作问题与解决

#### 5.4.1反序列化问题

​		JAVA反序列化对象，如果找不到对应class文件，抛出一个 `ClassNotFoundException` 异常。  

​		JAVA反序列化对象，能找到class文件，但是class文件在序列化对象后发生变化，反序列化操作，抛出一个`InvalidClassException`异常(原因如下)。

```
该类当前序列版本号与从流中读取的类的版本号不匹配。
该类包含未知数据类型
该类的父类没有无参构造，且未序列化。
```

`Serializable` 接口给需要序列化的类，提供了一个序列版本号的静态常量 `serialVersionUID` 。该常量的目的在于验证序列化的对象和对应类是否版本匹配。

#### 5.4.2演示反序列化操作问题

需求：演示反序列化问题与解决办法

//父类代码

```java
public class Fu implements Serializable {
    public Fu(int i) {
    }
}
```

//员工类代码

```java
public class Employee extends  Fu {
    private String name;
    private String address;
    private transient int age;

    public Employee(String name, String address, int age) {
        super(10);
        this.name = name;
        this.address = address;
        this.age = age;
    }
    //省略get/set

    public void show() {
        System.out.println("姓名=" + name + "---address=" + address + "---age=" + age);
    }
}
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeEmployee();
        readEmployee();
    }

    public static void readEmployee() throws IOException, ClassNotFoundException {
        //创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day11_05序列化流\\Employee2.txt"));
        //使用反序列化流的特有方法， 读取字节数据，获取对象
        Object o = ois.readObject();
        //将o强转为Employee类型
        Employee e = (Employee) o;
        e.show();
        //关闭流对象
        ois.close();
    }

    public static void writeEmployee() throws IOException {
        //创建员工类对象
        Employee e = new Employee("张三", "上海", 18);
        //创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day11_05序列化流\\Employee2.txt"));
        //写出对象数据
        oos.writeObject(e);
        //关闭流对象
        oos.close();
    }
}
```

### 小结

```

```



#  第六章 打印流

## 知识点-- PrintStream类

### 目标

学会使用打印流

### 路径

- 概述
- 构造方法
- 演示打印流的使用

### 讲解

#### 6.1概述

`java.io.PrintStream`类，该类能够方便地打印各种数据，是一种便捷的输出方式。

在控制台输出时，`System.out`就是`java.io.PrintStream`类型的，只不过流向是由打印在控制台上。

#### 6.2构造方法

* `public PrintStream(String fileName)  `： 使用指定的文件名创建一个新的打印流。

#### 6.3演示打印流的使用

需求：利用打印流，将数据输出到指定文本文件中。

//测试类代码

```java
public class Test {
    public static void main(String[] args) throws IOException {
        //创建打印流对象
        PrintStream ps = new PrintStream("day11_06PrintStream\\print.txt");
        //输出数据
        ps.println("黑马程序员");
        //关闭资源
        ps.close();
    }
}
```

### 小结

```

```



# 第七章 commons-io工具包

## 知识点--commons-io工具包

### 目标

- 学会使用commons-io工具包


### 路径

- 概述
- 使用步骤
- 常用方法
- 演示读写常用API
- 演示文件常用API

### 讲解

#### 7.1  概述

commons-io是apache开源基金组织提供的一组有关IO操作的类库，可以提高IO功能开发的效率。commons-io工具包提供了很多有关io操作的类，见下表：

| 包                                  | 功能描述                                     |
| ----------------------------------- | :------------------------------------------- |
| org.apache.commons.io               | 有关Streams、Readers、Writers、Files的工具类 |
| org.apache.commons.io.input         | 输入流相关的实现类，包含Reader和InputStream  |
| org.apache.commons.io.output        | 输出流相关的实现类，包含Writer和OutputStream |
| org.apache.commons.io.serialization | 序列化相关的类                               |

#### 7.2 使用步骤

1. 下载commons-io相关jar包:http://commons.apache.org/proper/commons-io/
2. 把commons-io-2.6.jar包复制到指定的Module的lib目录中
3. 将commons-io-2.6.jar加入到classpath中

#### 7.3常用类和方法

commons-io提供的  org.apache.commons.io.IOUtils工具类，封装了对于IO的读写方法。

- public static int copy(InputStream in, OutputStream out) 把输入流中的内容拷贝到输出流中，返回拷贝的字节个数(适合文件大小为2GB以下)
- public static long copyLarge(InputStream in, OutputStream out) 把输入流中的内容拷贝到输出流中，返回拷贝的字节个数(适合文件大小为2GB以上)

commons-io提供的org.apache.commons.io.FileUtils工具类，封装了对于文件的读写方法。

- public static void copyFileToDirectory(final File srcFile, final File destFile) 复制文件到另外一个目录下。
- public static void copyDirectoryToDirectory(File file1 ,File file2 ) 复制file1目录到file2位置。

#### 7.4演示IOUtils读写常用方法

需求：演示IOUtils工具类与FileUtils工具类复制案例

//测试类代码

~~~java
public class Test {
    public static void main(String[] args) throws IOException {
        //IOUtils工具类的使用
        method1();
        //FileUtiles工具类的使用
        method2();
    }

    public static void method2() throws IOException {
        //创建源路径
        File src = new File("day11_08commons-io工具包\\a\\image.jpg");
        //创建目的地目录路径
        File dest = new File("day11_08commons-io工具包\\b");
        //复制文件
        FileUtils.copyFileToDirectory(src,dest);
        File dest2 = new File("day11_08commons-io工具包\\c");
        FileUtils.copyDirectoryToDirectory(dest,dest2);
    }

    public static void method1() throws IOException {
        //创建字节输入流
        FileInputStream fis = new FileInputStream("day11_08commons-io工具包\\a\\image.jpg");
        //创建字节输出流
        FileOutputStream fos = new FileOutputStream("day11_08commons-io工具包\\b\\image_copy1.jpg");
        //复制文件
        IOUtils.copy(fis, fos);
    }
}
~~~

### 小结

```

```

# 第八章 装饰者设计模式

## 知识点-- 装饰者设计模式

### 目标

- 理解什么是装饰者设计模式

### 路径

- 概述
- 案例演示

### 讲解

#### 8.1 概述

装饰模式指的是在不改变原类, 不使用继承的基础上，动态地扩展一个对象的功能。

	装饰模式遵循原则:
		装饰类和被装饰类必须实现相同的接口
		在装饰类中必须传入被装饰类的引用
		在装饰类中对需要扩展的方法进行扩展
		在装饰类中对不需要扩展的方法调用被装饰类中的同名方法

#### 8.2 演示装饰者设计模式

##### 需求:

1. 编写一个Star接口, 提供sing 和 dance抽象方法
2. 编写一个LiuDeHua类,实现Star接口,重写抽象方法
3. 在不改变原类基础上利用装饰者模式对LiuDeHua类的sing方法进行扩展

##### 分析:

1. 编写一个LiuDeHuaWarpper类, 实现Star接口,重写抽象方法
2. 提供LiuDeHuaWarpper类的有参构造, 传入LiuDeHua类对象
3. 在LiuDeHuaWarpper类中对需要增强的sing方法进行增强
4. 在LiuDeHuaWarpper类对不需要增强的方法调用LiuDeHua类中的同名方法

##### 实现

//Star接口

```java
public interface Star {
    public void sing();
    public void dance();
}
```

//LiuDeHua类

```java
public class LiuDeHua implements Star {
    @Override
    public void sing() {
        System.out.println("忘情水...");
    }

    @Override
    public void dance() {
        System.out.println("机械舞...");
    }
}
```

//装饰类代码

```java
public class LiuDeHuaWarpper implements Star {
    //将被装饰的类作为装饰类的成员变量
    private LiuDeHua ldh = null;

    //在创建对象的时候，传入一个被装饰类的实体
    public LiuDeHuaWarpper(LiuDeHua ldh) {
        this.ldh = ldh;
    }

    @Override
    public void sing() {
        ldh.sing();
        //对需要增强的方法，进行扩展
        System.out.println("给我一杯忘情水...");
    }

    @Override
    public void dance() {
        //对不需要增强的方法，保留原操作
        ldh.dance();
    }
}
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建被装饰类的对象
        LiuDeHua ldh = new LiuDeHua();
        //创建装饰类的对象，将被设者类的对象传入
        LiuDeHuaWarpper ldhw = new LiuDeHuaWarpper(ldh);
        //使用装设类的对象调用方法
        ldhw.sing();
        ldhw.dance();
    }
}
```

### 小结

```

```


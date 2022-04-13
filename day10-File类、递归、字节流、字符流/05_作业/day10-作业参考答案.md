# 一  编程题【File类】

### 1.1

请在D盘根目录下创建一个文件：test1.txt(随意录入一些内容)，再创建一个目录：测试目录

​	请编写main()方法，创建以下两个File对象：

​		File file1 = new File(“d:\\test1.txt”;

​		File file2 = new File(“d:\\测试目录”);

​	要求：

​		1. 获取、打印file1和file2的绝对路径；

​		2. 获取、打印file1和file2的文件名和目录名；

​		3. 获取、打印file1和file2的文件大小；

​		4. 分别判断file1和file2是否存在；

		5. 分别判断file1和file2是否是文件？是否是目录？



test1.txt 内容为

```text
hello
```



```java
public class H11 {
    public static void main(String[] args) {
        // 注意 \\ 要写两个，第一个是转义字符，第二个是真正的 \
        // 也可以将 \\ 替换为 /
        File file1 = new File("d:\\test1.txt");
        File file2 = new File("d:\\测试目录");

        // 1. 获取打印file1和file2的绝对路径
        System.out.println("file1 的绝对路径："+file1.getAbsolutePath());
        System.out.println("file2 的绝对路径："+file2.getAbsolutePath());
        // 2. 获取打印file1和file2的文件名和目录名
        System.out.println("file1 文件名："+file1.getName());
        System.out.println("file1 目录名："+file1.getParent()); // parent 为上级目录
        System.out.println("file2 文件名："+file2.getName());
        System.out.println("file2 目录名："+file2.getParent());
        // 3. 获取打印file1和file2的文件大小
        System.out.println("file1 大小："+file1.length());
        System.out.println("file2 大小："+file2.length());
        // 4. 分别判断file1和file2是否存在
        System.out.println("file1 存在吗？"+file1.exists());
        System.out.println("file2 存在吗？"+file2.exists());
        // 5. 分别判断file1和file2是否是文件？是否是目录？
        System.out.printf("file1 是否是文件 %b 是否是目录 %b\n", file1.isFile(), file1.isDirectory());
        System.out.printf("file2 是否是文件 %b 是否是目录 %b\n", file2.isFile(), file2.isDirectory());
    }
}
```





### 1.2

请编写main()方法，创建以下File对象：

​		File file1 = new File(“test.txt”);//相对路径，在项目根目录下

​		File file2 = new File(“一级目录”);

​		File file3 = new File(“目录A/目录B/目录C”);

​	要求：

​		1. 判断file1是否存在？如果不存在，创建这个文件。

​		2. 判断file2是否存在？如果不存在，创建这个目录。

		3. 判断file3是否存在？如果不存在，创建这个多级目录。

```java
public class H12 {
    public static void main(String[] args) throws IOException {
        // 如何查看相对目录相对的哪个呢？
        System.out.println(System.getProperty("user.dir"));


        File file1 = new File("test.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        } else {
            System.out.println(file1.getAbsolutePath()+"已存在...");
        }

        File file2 = new File("一级目录");
        if (!file2.exists()) {
            file2.mkdir();
        } else {
            System.out.println(file2.getAbsolutePath()+"已存在...");
        }

        File file3 = new File("目录A/目录B/目录C");
        if (!file3.exists()) {
            file3.mkdirs();
        } else {
            System.out.println(file3.getAbsolutePath()+"已存在...");
        }
    }
}
```



### 1.3

请在D盘下创建一个目录“多级目录”，下面随意创建一些文件和目录。

​	请编写main()方法，创建以下File对象：

​		File file = new File(“D:\\多级目录”);

​	要求：

​		1. 获取这个file目录下所有的子文件/子目录的File数组

​		2. 遍历这个数组，判断每个File对象是否文件

​			如果是文件，打印：【文件】+ 绝对路径

​			如果是目录，打印：【目录】+ 绝对路径



```java
public class H13 {
    public static void main(String[] args) {
        File file = new File("D:\\多级目录");
        File[] files = file.listFiles();
        // 本题并没有要求遍历任意级别的目录结构，就处理一层即可，后面有递归遍历多层的练习
        for (File f : files) {
            if (f.isFile()) {
                System.out.println("【文件】" + f.getAbsolutePath());
            } else if (f.isDirectory()) {
                System.out.println("【目录】" + f.getAbsolutePath());
            }
        }
    }
}
```



# 二 编程题【递归】

### 2.1

请使用递归计算5的阶乘

```java
public class H21 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static  int factorial(int n){
        // 设置终止条件
        if(n==1){
            return 1;
        }
        // 递归调用
        return n * factorial(n - 1);
    }
}
```



### 2.2

请使用递归计算从1--100的所有数的累加和。

```java
public class H22 {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static int sum(int n) {
        // 设置终止条件
        if (n == 1) {
            return 1;
        }
        // 递归调用
        return n + sum(n - 1);
    }
}
```



### 2.3

请使用递归遍历一个多级目录，打印所有文件的“绝对路径”。

目录结构如下所示

```
d:
	|-a
		|-a.txt
		|-b
			|-b.txt
			|-bb
				|-bb.txt
		|-c
			|-c.txt
```



```java
public class H23 {
    public static void main(String[] args) {
        printFile(new File("d:/a"));
    }

    static void printFile(File fileOrDir) {
        // 是目录
        if (fileOrDir.isDirectory()) {
            // 继续遍历子目录和文件
            for (File f : fileOrDir.listFiles()) {
                printFile(f);
            }
        } 
        // 是文件，打印绝对路径
        else if (fileOrDir.isFile()) {
            System.out.println(fileOrDir.getAbsolutePath());
        }
    }
}
```

输出

```
d:\a\a.txt
d:\a\b\b.txt
d:\a\b\bb\bb.txt
d:\a\c\c.txt
```

# 三 编程题【IO流】

### 3.1 题目一

请使用字节流复制一个文件，一次读、写一个字节。



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //创建输入流
        InputStream is = new FileInputStream("day16/files/file1.txt");

        //创建输出流
        OutputStream os = new FileOutputStream("day16/files/file1_copy.txt");

        //按字节循环读写
        int b;
        while ((b = is.read()) != -1) {
            os.write(b);
        }

        //释放资源
        os.close();
        is.close();
    }
}
```



### 3.2 题目二

请使用字节流复制一个文件，一次读、写一个1K的字节数组。



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //创建输入流
        InputStream is = new FileInputStream("day16/files/file2.txt");

        //创建输出流
        OutputStream os = new FileOutputStream("day16/files/file2_copy.txt");

        //按每千字节循环读写
        byte[] buffer = new byte[1000];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //释放资源
        os.close();
        is.close();
    }
}
```


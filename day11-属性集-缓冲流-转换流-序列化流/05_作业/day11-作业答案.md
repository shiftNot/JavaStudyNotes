# IO流

### 1.1 题目三

1. 请定义一个Student类，属性：姓名、性别、年龄、分数

​      无参、全参构造方法

​      get/set方法

2. 定义测试类，编写main()方法：

​       // 定义一个集合

​       List<Student> stuList = new ArrayList<>();

​       stuList.add(new Student(“张三”,”男”,20,88);

​       stuList.add(new Student(“李四”,”女”,19,99);

3. 遍历这个集合，将每个Student对象中的数据按以下格式写到项目根目录下

​     的student.txt中：

​       张三,男,20,88

​       李四,女,19,99



参考答案

定义学生类

```java
public class Student {

    private String name;    //姓名
    private String gender;  //性别
    private int age;        //年龄
    private int score;      //分数

    //空参构造
    public Student() { }

    //全参构造
    public Student(String name, String gender, int age, int score) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
```



测试类

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        // 定义集合
        List<Student> stuList = new ArrayList<>();

        // 创建两个学生对象并添加到集合中
        stuList.add(new Student("张三", "男", 20, 88));
        stuList.add(new Student("李四", "女", 19, 99));

        // 遍历集合，并将集合中的学生对象信息写入到 student.txt 文件中
        // 声明字符输出流对象
        Writer writer = new FileWriter("day16/files/student.txt");
        for (Student student : stuList) {
            writer.write(
                    student.getName() + "," +
                            student.getGender() + "," +
                            student.getAge() + "," +
                            student.getScore());
            writer.write("\n");
        }

        //释放资源
        writer.close();
    }
}
```





### 1.2 题目四

1. 定义测试类，编写main()方法

2. 读取3.3的student.txt文件，一次读取一个字符，显示到控制台。



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //声明字符输入流对象
        Reader reader = new FileReader("day16/files/student.txt");

        //按字符读取文件并打印在控制台
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char)c); //不要使用 println
        }

        //释放资源
        reader.close();
    }
}
```





# 异常处理

### 2.1 题目一

请使用FileWriter向文件输出：HelloWorld

要求：用JDK7以后的异常处理方式。



参考答案

```java
public class Demo {

    public static void main(String[] args) {
        //声明输出流对象
        try (Writer writer = new FileWriter("day16/files/file3.txt")) {
            //写出 HelloWorld
            writer.write("HelloWorld");
        } catch (IOException e) {
            System.out.println("程序出现异常，异常信息：" + e.getMessage());
        }
    }
}
```



# 属性集

### 3.1 题目一

请编写程序，定义一个Properties对象，存储以下内容：

​           Properties pro = new Properties();

​           pro.setProperty(“品名”,”Iphone11 Pro Max”);

​           pro.setProperty(“颜色”,”暗夜绿”);

​           pro.setProperty(“存储容量”,”256G”);

​           pro.setProperty(“价格”,”10899”);

请将上述内容写入到文件：”test2_1.txt”中



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        // 声明Properties对象
        Properties pro = new Properties();
        // 添加属性
        pro.setProperty("品名", "Iphone11 Pro Max");
        pro.setProperty("颜色", "暗夜绿");
        pro.setProperty("存储容量", "256G");
        pro.setProperty("价格", "10899");

        // 将属性写出到test2_1.txt中
        // 声明输出流对象
        Writer writer = new FileWriter("day16/files/test2_1.txt");
        Set<String> propertyNames = pro.stringPropertyNames();
        for (String propertyName : propertyNames) {
            writer.write(propertyName + "=" + pro.getProperty(propertyName));
            writer.write("\n");
        }

        //释放资源
        writer.close();
    }
}
```



### 3.2 题目二

请编写程序，定义一个Properties对象，将文件”test2_1.txt”的内容读取到Properties对象中，遍历，并打印每个键值对。



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        // 定义properties对象
        Properties pro = new Properties();

        // 声明输入流对象
        // 使用字节输入流可能会出现中文乱码的情况，这里先使用字符输入流
        Reader reader = new FileReader("day16/files/test2_1.txt");

        // 读取文件中的属性
        pro.load(reader);

        // 遍历并打印键值对
        Set<String> propertyNames = pro.stringPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println(propertyName + "=" + pro.get(propertyName));
        }

        //释放资源
        reader.close();
    }
}
```

# 缓冲流

## 4.1 题目一

> 请将D:盘下的一个文件复制到E:盘下，例如：d:\\视频.itcast，复制到E:\\视频.itcast。
> 请使用“字节缓冲流”：BufferedInputStream和BufferedOutputStream实现



参考答案

```java
public class Demo {
    
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:/视频.itcast"));
        //创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/视频.itcast"));
        
        //声明缓冲字节数组
        byte[] buffer = new byte[1024 * 8];
        //声明记录读取长度的变量
        int len;
        
        //循环读写
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        
        //释放资源
        bos.close();
        bis.close();
    }
}
```



## 4.2 题目二

> 请编写main()方法，定义一个存储String的集合：List<String>，并初始化以下数据：
> 			List<String> list = new ArrayList<>();
> 			list.add(“迪丽热巴”);
> 			list.add(“古力娜扎”);
> 			list.add(“周杰伦”);
> 			list.add(“蔡徐坤”);
> 			//请定义“字符缓冲输出流”BufferedWriter将集合中的数据写入到文件：test3_2.txt中，每个名字一行。



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //定义集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("周杰伦");
        list.add("蔡徐坤");

        //定义字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("day17/files/test3_2.txt"));

        //写入文件
        for (String name : list) {
            bw.write(name);
            bw.newLine();//换行
        }

        //释放资源
        bw.close();
    }
}
```



## 4.3 题目三

> 请编写main()方法，定义一个字符缓冲输入流BufferedReader，读取test3_2.txt文件，一次读取一行，将读取的内容存储到一个List<String>集合中，遍历、并打印集合中的每个元素：
> 			//1.定义一个字符缓冲输入流
> 			BufferedReader in = new BufferedReader(......);
> 			//2.定义一个集合
> 			List<String> list = new ArrayList<>();
> 			//3.一次读取一行
> 			......
> 			......



参考答案

```java
public class Demo {

    
    public static void main(String[] args) throws IOException {
        //定义字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("day17/files/test3_2.txt"));

        //定义集合
        List<String> list = new ArrayList<>();

        //循环读取，每次读取一行
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        //打印结果
        System.out.println(list);

        //释放资源
        br.close();
    }
}
```



## 4.4 题目四

> 请按以下要求编写程序：
> 		1).定义一个学员类，有以下属性：姓名、性别、年龄、分数
> 		  无参、全参构造方法，get/set方法
> 		2).定义main()方法，定义一个存储Student的集合，并初始化一些数据：
> 			List<Student> stuList = new ArrayList<>();
> 			stuList.add(new Student(“迪丽热巴”,”女”,18,99);
> 			stuList.add(new Student(“古力娜扎”,”女”,19,98);
> 			stuList.add(new Student(“周杰伦”,”男”,20,88);
> 			stuList.add(new Student(“蔡徐坤”,”男”,19,78);
> 			/*
> 			定义一个字符缓冲输出流BufferedWriter，将学员信息写入到”test3_4.txt”中，       
>          每个学员信息占一行，每个字段之间用,符号隔开，例如：
> 				迪丽热巴,女,18,99
> 				古力娜扎,女,19,98
> 				周杰伦,男,20,88
> 				蔡徐坤,男,19,78



参考答案



学生类

````java
public class Student {

    private String name;    //姓名
    private String gender;  //性别
    private int age;        //年龄
    private int score;      //分数

    //空参构造
    public Student() { }

    //全参构造
    public Student(String name, String gender, int age, int score) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
````



测试类

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //定义集合
        List<Student> stuList = new ArrayList<>();

        //创建学生对象并添加到集合中
        stuList.add(new Student("迪丽热巴", "女", 18, 99));
        stuList.add(new Student("古力娜扎", "女", 19, 98));
        stuList.add(new Student("周杰伦", "男", 20, 88));
        stuList.add(new Student("蔡徐坤", "男", 19, 78));

        //定义字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("day17/files/test3_4.txt"));

        //循环集合中的所有学生对象，并写出到文件中
        for (Student student : stuList) {
            bw.write(student.getName() + ", " + student.getGender() + ", " + student.getAge() + ", " + student.getScore());
            bw.newLine();//换行
        }

        //释放资源
        bw.close();
    }
}
```



## 4.5 题目五

> 请编写main()方法，定义一个字符缓冲输入流BufferedReader对象，读取”test3_4.txt”文件，一次读取一行，将每行数据封装为一个Student对象，并将Student对象存储到一个集合。遍历并打印集合的所有Student信息。
> 		//定义一个BufferedReader对象
> 		BufferedReader in = new BufferedReader(......);
> 		//定义一个集合
> 		List<Student> stuList = new ArrayList<>();
> 		//一次读取一行
> 		......



参考答案

```java
public class Demo {
    
    public static void main(String[] args) throws IOException {
        //声明字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("day17/files/test3_4.txt"));

        //声明集合
        List<Student> stuList = new ArrayList<>();

        //循环读取
        String line;
        while ((line = br.readLine()) != null) {
            //创建学生对象
            Student stu = new Student();

            //切割字符串
            String[] split = line.split(",");

            //封装到对象中
            stu.setName(split[0]);
            stu.setGender(split[1]);
            stu.setAge(Integer.parseInt(split[2])); //转换类型
            stu.setScore(Integer.parseInt(split[3])); //转换类型

            //添加到集合中
            stuList.add(stu);
        }

        //打印结果
        for (Student student : stuList) {
            System.out.println(student);
        }

        //释放资源
        br.close();
    }
}
```



# 转换流

## 5.1 题目一

> 请定义一个输出转换流对象：OutputStreamWriter，使用GBK编码，向文件”test4_1.txt”文件输出内容：”我要学好Java，我要月薪过万！！”



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //定义输出转换流
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("day17/files/test4_1.txt"), "GBK");

        //输出内容
        osw.write("我要学好Java，我要月薪过万！！");

        //释放资源
        osw.close();
    }
}
```



## 5.2 题目二

> 请定义一个输入转换流对象：InputStreamReader，使用GBK编码读取“test4_1.txt”文件的内容，并打印。



参考答案

```java
public class Demo {

    //请定义一个输入转换流对象：InputStreamReader，使用GBK编码读取“test4_1.txt”文件的内容，并打印。
    public static void main(String[] args) throws IOException {
        //定义输入转换流
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("day17/files/test4_1.txt"), "GBK");

        //读取
        char[] buffer = new char[1024 * 8];
        int len = isr.read(buffer); //因为内容不多，读取一次就够了

        //打印结果
        System.out.println(new String(buffer, 0, len));

        //释放资源
        isr.close();
    }
}
```



# 序列化

## 6.1 题目一

> 请定义Student类，有以下属性：姓名、性别、年龄，并实现Serializable接口。
> 请定义main()方法，创建一个Student对象：
>
> Student stu = new Student(“迪丽热巴”,”女”,18);
> //定义一个序列化对象：ObjectOutputStream，将stu序列化到文件“test5_1.txt”中



参考答案



学生类

```java
public class Student implements Serializable {

    private String name;    //姓名
    private String gender;  //性别
    private int age;        //年龄

    //空参构造
    public Student() {
    }
    
    //全参构造
    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    //getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    //toString
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
```



测试

```java
public class Demo {
    
    public static void main(String[] args) throws IOException {
        //创建对象
        Student stu = new Student("迪丽热巴", "女", 18);

        //创建序列化对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day17/files/test5_1.txt"));

        //写出文件
        oos.writeObject(stu);

        //释放资源
        oos.close();
    }
}
```



## 6.2 题目二

> 请定义main()方法，创建一个反序列化对象：ObjectInputStream，将文件”test5_1.txt”的对象反序列化到程序中，并打印此对象。



参考答案

```java
public class Demo {

    public static void main(String[] args) throws Exception {
        //创建反序列化对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day17/files/test5_1.txt"));

        //读取
        Student stu = (Student)ois.readObject();

        //打印结果
        System.out.println(stu);

        //释放资源
        ois.close();
    }
}
```



# commons-io 包

## 7.1 题目一

> 1. 请参考讲义将commons-io包加入到项目中；
> 2. 编写程序，使用FileUtils工具类：
>    1). 将d:\\视频.itcast文件复制到e:\\下
>       		2). 将"d:\\多级目录"复制到"e:\\"下



参考答案

```java
public class Demo {

    public static void main(String[] args) throws IOException {
        //拷贝文件
        FileUtils.copyFileToDirectory(new File("d:\\视频.itcast"), new File("e:\\"));
        //拷贝目录
        FileUtils.copyDirectoryToDirectory(new File("d:\\多级目录"), new File("e:\\"));
    }
}
```


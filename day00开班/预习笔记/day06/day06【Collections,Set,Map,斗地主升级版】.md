# day06【Collections、Set、Map、斗地主排序】

## 今日内容

- Collections工具类
  - 常用方法
  - 比较器
  - 可变参数
- Set集合
  - 概述
  - HashSet集合
  - HashSet存储数据的结构
  - HashSet存储自定义类型元素
  - LinkedHashSet存储自定义类型元素
  - TreeSett存储自定义类型元素
- Map集合
  - 概述
  - 常用子类
  - 常用方法
  - Map集合遍历
  - HashMap键存储自定义类型
  - LInkedHashMap键存储自定义类型
  - TreeMap集合
  - 练习
- 集合的综合案例

## 教学目标

- [ ] 能够使用集合工具类 

- [ ] 能够使用Comparator比较器进行排序

- [ ] 能够使用可变参数

- [ ] 能够说出Set集合的特点

- [ ] 能够说出哈希表的特点

- [ ] 使用HashSet集合存储自定义元素

- [ ] 能够说出Map集合特点、常用的方法 

- [ ] 使用Map集合添加方法保存数据

- [ ] 使用”键找值”的方式遍历Map集合   

- [ ] 使用”键值对”的方式遍历Map集合

- [ ] 能够使用HashMap存储自定义键值对的数据   

- [ ] 能够完成斗地主洗牌发牌案例


# 第一章  Collections类

## 知识点--Collections常用功能

### 目标

- 掌握工具类Collections的使用

### 路径

- 概述
- 常用方法
- 演示Collections工具的使用

### 讲解

#### 1.1.1概述

`java.utils.Collections`是集合工具类，用来对集合进行操作。

#### 1.1.2常用方法


- `public static void shuffle(List<?> list) `:打乱集合顺序。
- `public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序。

#### 1.1.3演示Collections的工具的使用

需求：演示集合工具类中的功能

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合
        List<Integer> list = new ArrayList<>();
        //添加数据
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        System.out.println(list);
        //public static void shuffle(List<?> list)
        Collections.shuffle(list);
        System.out.println(list);
        // public static <T> void sort(List<T> list)
        Collections.sort(list);
        System.out.println(list);
    }
}

```

### 小结

```java

```

## 知识点--Comparator比较器

### 目标

- 掌握Comparator比较器使用

### 路径

- 概述
- 常用方法
- 演示Comparator比较器使用

### 讲解

#### 1.2.1概述

​		`public interface Comparator<T>`  定义比较对象规则的接口

#### 1.2.2常用方法

```java
public int compare(T  o1,T  o2) 比较用来排序的两个参数
	o1一般代表正着添加的元素，o2表示已经添加过的元素。根据第o1与o2的比较结果，返回负整数、零或正整数实现排序。
	默认使用方式
 		升序   根据o1的值与o2的值做比较(o1-o2)
 		降序   根据o2的值与o1的值做比较(o2-o1)
```

#### 1.2.3 应用场景

​		Collections工具类中:	`public static <T> void sort(List<T> list，Comparator<? super T> )`:将集合中元素按照指定规则排序。

#### 1.2.4演示Comparator比较器的应用

需求：演示Comparator在集合工具类排序功能中的使用

//Comparator实现类

```java
public class Test {
    public static void main(String[] args) {
        //创建集合
        List<Integer> list = new ArrayList<>();
        //添加数据
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(0);
        System.out.println("排序前"+list);
        //自定义规则排序:匿名内部类
        //创建了一个Compartor的实现类对象
        Comparator c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1代表后面的那个数  o2代表前面的那个数
                // System.out.println(o1+"---"+o2);
                //o1与o2做比较:升序
                //>0  o1放在o2的后面
                //=0  位置不变
                //<0  o1放在o2的前面
                int num =o1-o2;
                //o2与o1做比较:降序
                // int num =o2-o1;
                return num;

            }
        };
        Collections.sort(list, c);
        System.out.println("排序后"+list);
    }
}
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //添加数据
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        //public static <T> boolean addAll(Collection<T> c,T...elements)
        Collections.addAll(list,"d","e","f");
        System.out.println(list);

        method1(10,"a","b","c");
    }
    //注意实现1:一个方法只能有一个可变参数
    // public static void method1(String ... arr1,Integer arr2){
    // 如果方法中有多个参数，可变参数要放到最后。
    // public static void method1(String ... arr1,int num){
    public static void method1(int num,String ... arr1){
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
```

### 小结

```

```

## 知识点--可变参数

### 目标

- 掌握可变参数的使用

### 路径

- 概述
- 格式
- 注意事项
- 应用场景
- 演示可变参数应用场景

### 讲解

#### 1.3.1 

在JDK1.5之后，定义了可变参数，用来表示一个方法需要接受的多个同类型参数。

#### 1.3.2 格式

```java
参数类型... 形参名
```

#### 1.3.3 注意事项

- 1.一个方法只能有一个可变参数
- 2.如果方法中有多个参数，可变参数要放到最后。

#### 1.3.4应用场景

​	Collections工具类的方法：`public static <T> boolean addAll(Collection<T> c,T...elements)  `:往集合中添加一些元素。

#### 1.3.5演示可变参的使用

需求：演示可变参数在集合工具类的添加方法中的应用

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //添加数据
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        //public static <T> boolean addAll(Collection<T> c,T...elements)
        Collections.addAll(list,"d","e","f");
        System.out.println(list);

        method1(10,"a","b","c");
    }
    //注意实现1:一个方法只能有一个可变参数
    // public static void method1(String ... arr1,Integer arr2){
    // 如果方法中有多个参数，可变参数要放到最后。
    // public static void method1(String ... arr1,int num){
    public static void method1(int num,String ... arr1){
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
```

### 小结

```java

```



# 第二章 Set接口

## 知识点--Set接口概述

### 目标

- 了解Set集合的特点

### 路径

- Set集合概述
- Set接口特点
- Set集合常用子类

### 讲解

#### 2.1.1Set集合概述

`java.util.Set`接口继承自Collection接口，是单列集合的一个重要分支。实现了Set`接口的对象称为Set集合。

Set集合没有对于Collection功能的额外扩充,但是有更加完善的存储机制。

Set集合无索引，只能是用增强for和迭代器遍历

#### 2.1.2Set接口特点    

- 元素无索引,元素存取无序,元素不可重复(唯一)

#### 2.1.3Set集合常用子类

`java.util.HashSet`：哈希表结构集合

`java.util.LinkedHashSet`：链表结构集合

`java.util.TreeSet`：树结构集合

#### 2.1.4演示Set的使用

需求：在测试类中演示Set的基本使用

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        Set<String> set =new HashSet<>();
        //添加数据
        set.add("c");
        set.add("a");
        set.add("a");
        set.add("b");
        System.out.println(set);
    }
}

### 小结

```java

```

## 知识点--HashSet存储自定义类型元素

### 目标

- 理解HashSet集合的特点

### 路径

- 概述
- 特点
- 数据结构
- 元素唯一代码原理
- 哈希表原理图
- 哈希表存储流程图
- HashSet存储自定义类型元素操作方式

### 讲解

#### 2.2.1概述

`java.util.HashSet`是`Set`接口的一个实现类

底层的实现其实是一个`java.util.HashMap`支持

根据对象的哈希值来确定元素在集合中的存储位置，具有良好的存储和查找性能

元素唯一，底层依赖`hashCode`与`equals`方法。

#### 2.2.2特点

- 元素无索引,元素存取无序,元素不可重复(唯一)

#### 2.2.3数据结构

​JDK1.8之前，哈希表底层采用数组+链表，
​JDK1.8开始，哈希表存储采用数组+链表+红黑树。

#### 2.2.4元素唯一代码原理

- hashCode决定存储的列数(相同则一列)，equals是否存在相同元素
- jdk8为提高查询效率，当一列数据达到8个且总数据达到64个，则增加数组长度，重新排列数据
    ![](./day06-imgs\哈希表.png) 

    ![](./day06-imgs\哈希表流程图.png)

#### 2.2.5HashSet存储自定义类型元素操作方式

- HashSet存储对象,是根据继承自Object类中的hashCode方法和equals方法的值进行判定存储
- 默认的hashCode和equals方法是通过地址值计算，在实际开发中我们一般需要重写对象这两个方法

#### 2.2.6演示HashSet存储自定义类型元素

需求：通过HashSet存储自定义学生类型对象

//自定义学生类代码

```java
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Student> hs = new HashSet<>();
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加学生对象
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        //打印集合
        // System.out.println(hs);
        for (Student s : hs) {
            System.out.println(s);
        }
        //内容不同，但是hashCode有可能相同
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("BB".hashCode());
    }
}
```

### 小结

```java

```

## 知识点--LinkedHashSet存储自定义类型元素

### 目标

- 掌握LinkedHashSet使用及特点

### 路径

- 概述
- 特点
- 演示LinkedHashSet使用

### 讲解

#### 2.3.1概述

`java.util.LinkedHashSet` 是HashSet的一个子类，底层采用链表+哈希表

LinkedHashSet类在保留HashSet元素唯一的基础上，增加了有序性

#### 2.3.2特点

元素无索引,元素**存取有序**,元素不可重复(唯一)

- 保证元素唯一:由哈希表保证元素唯一,哈希表保证元素唯一依赖hashCode()和equals()方法
- 保证元素存取有序: 由链表保证元素存取有序

#### 2.3.3演示LinkedHashSet使用

需求：通过LinkedHashSet存储自定义学生类型对象

//学生类代码

```
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        LinkedHashSet<Student> lhs = new LinkedHashSet<>();
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加学生
        lhs.add(s1);
        lhs.add(s2);
        lhs.add(s3);
        lhs.add(s4);
        //打印内容
        for (Student s : lhs) {
            System.out.println(s);
        }
    }
}

```

### 小结

```java

```

## 知识点--TreeSet存储自定义类型元素

### 目标

- 掌握TreeSet的使用及特点

### 路径

- 概述
- 特点
- 演示TreeSet的使用

### 讲解

#### 2.4.1概述

`java.util.TreeSet` 是是Set接口的一个实现类,底层依赖于TreeMap,是一种基于**红黑树**的实现。

TreeSet集合存储的对象必须拥有排序规则(比较器)，否则会报出异常`cannot be cast to java.lang.Comparable`。

自然排序：
- 对象类实现 java.lang.Comparable接口，重写compareTo方法，使用TreeSet无参构造创建集合对象

比较器排序 ：
- 创建重写compare方法的Comparator接口实现类对象,使用TreeSet有参构造【TreeSet(Comparator<E> comparator)】创建集合对象

> tips：以谁为优先排序，就把谁放前面

#### 2.4.2特点

元素无索引,元素存取无序,元素不可重复(唯一)，元素可排序

#### 2.4.3演示TreeSet比较规则

需求：通过TreeSet存储Integer演示比较器基本使用

//测试类代码

~~~java
public class Test {
    public static void main(String[] args) {
        //定义比较规则
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1代表正在添加(后面)的数据  o2代表已添加(前面)的数据
                //o1与o2做比较  升序
                //>0 o1放到o2的后面
                //=0 不存
                //<0 o1放到o2的前面
                // int num = o1 - o2;
                //o2与o1做比较  降序
                int num = o2 - o1;
                return num;
            }
        };
        //创建集合对象
        TreeSet<Integer> ts = new TreeSet<>(c);
        //添加数据
        ts.add(5);
        ts.add(3);
        ts.add(4);
        ts.add(2);
        ts.add(1);
        //打印数据
        System.out.println(ts);
    }
}
~~~

#### 2.4.4演示TreeSet自定义排序

需求：通过TreeSet存储自定义学生类演示自定义排序

//学生类代码

~~~java
public class Student implements Comparable<Student> {
    String name;
    int age;

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


    @Override
    public int compareTo(Student o) {//this ----  o
        // System.out.println(this+"---"+o);
        //this代表正在添加(后面)的数据  o代表已添加(前面)的数据
        //this与o做比较  升序
        //>0 this放到o的后面
        //=0 不存
        //<0 this放到o的前面
        // int num = this - o;
        //o与this做比较  降序

        //多个比较的项目:name,age,优先以谁作为比较条件，就先比谁。
        /*
        //优先以name的升序，作为比较条件
        int num = this.name.compareTo(o.name);
        //如果名字的比较结果相同，再以年龄的升序排列
        num = (num == 0) ? this.age - o.age : num;
        */
        //优先以name的降序，作为比较条件
        int num = o.name.compareTo(this.name);
        //如果名字的比较结果相同，再以年龄的降序排列
        num = (num == 0) ? o.age - this.age : num;
        return num;
    }
}

~~~

//测试类代码

~~~java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<>();
        //创建集合对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加学生对象
        ts.add(s1);//class  Student cannot be cast to class  Comparable
        // System.out.println("--------");
        ts.add(s2);
        // System.out.println("--------");
        ts.add(s3);
        // System.out.println("--------");
        ts.add(s4);
        //打印集合
        for (Student s : ts) {
            System.out.println(s);
        }
    }
}
~~~

#### 2.4.5演示TreeSet比较器排序

需求：通过TreeSet存储自定义老师类演示比较器排序

//老师类代码

~~~java
public class Student {
    String name;
    int age;

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
~~~

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
/*
        //通过匿名内部类创建比较器对象
        Comparator c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //o1代表正在添加(后面)的数据  o2代表已添加(前面)的数据
                //o1与o2做比较  升序
                //>0 o1放到o2的后面
                //=0 不存
                //<0 o1放到o2的前面
                // int num = o1 - o2;
                //o2与o1做比较  降序
                //按照姓名升序，年龄降序排列
                int num = o1.name.compareTo(o2.name);
                num = (num == 0) ? o2.age - o1.age : num;
                return num;
            }
        };
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<>(c);
        */
        TreeSet<Student> ts= new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //o1代表正在添加(后面)的数据  o2代表已添加(前面)的数据
                //o1与o2做比较  升序
                //>0 o1放到o2的后面
                //=0 不存
                //<0 o1放到o2的前面
                // int num = o1 - o2;
                //o2与o1做比较  降序
                //按照姓名升序，年龄降序排列
                int num = o1.name.compareTo(o2.name);
                num = (num == 0) ? o2.age - o1.age : num;
                return num;
            }
        });
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加学生对象
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        //打印集合
        for (Student s : ts) {
            System.out.println(s);
        }
    }
}
```

### 小结

```java

```



# 第三章 Map集合

## 知识点--Map集合概述

### 目标

- 能够说出Map集合特点

### 路径

- Map集合概述
- Map集合与Collection集合区别
- 单列/双列集合原理图
- Map的常用子类介绍

### 讲解

#### 3.1.1概述

`java.util.Map`双列集合的顶层接口，用来存储具备映射关系对象的集合接口定义。

映射关系：生活中类似`IP地址与主机名`、`身份证号与个人`等一一对应的对应关系。

Map集合中存储的内容根据映射关系分为两部分，称为键值对
- 键(Key)不能包含重复的键，
- 值(Value)可以重复；
- 每个键只能对应一个值。

#### 3.1.2Map集合与Collection集合区别

- `Collection`集合中的元素，是以单个的形式存储。称为单列集合
- `Map`集合中的元素，是以键值对的形式存储。称为双列集合

#### 3.1.3单列/双列集合原理图

<img src="./day06-imgs\Collection与Map.bmp" style="zoom:67%;" />

#### 3.1.4Map的常用子类介绍

HashMap<K,V>

- 存储数据采用的哈希表结构，元素的存取顺序不能保证一致。

- 由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。


LinkedHashMap<K,V>

- HashMap的子类，存储数据采用的哈希表结构+链表结构。
- 通过链表结构可以保证元素的存取顺序一致；
- 通过哈希表结构可以保证键唯一、不重复，需要重写键的hashCode()方法、equals()方法。

TreeMap<K,V>

- TreeMap集合和Map相比没有特有的功能，底层的数据结构是红黑树；
- 可以对元素的*键*进行排序，排序方式有两种:自然排序和比较器排序

> tips：Map接口中的集合都有两个泛型变量<K,V>,在使用时，要为两个泛型变量赋予数据类型。两个泛型变量<K,V>的数据类型可以相同，也可以不同。

### 小结

```

```



## 知识点--Map的常用方法

### 目标

- 掌握Map的常用方法

### 路径

- 常用方法
- 演示Map的常用方法

### 讲解

#### 3.2.1常用方法

- `public V put(K key, V value)`:  把指定的键与值添加到Map集合中。
  - 若键(key)在集合中不存在，添加指定的键和值到集合中，返回null；
  - 若键(key)在集合中存在，对应键的原值被新值替代，返回该键对应的原值。 
- `public V remove(Object key)`: 把指定的键对应的键值对元素在Map集合删除，返回被删除元素的值。
- `public V get(Object key)` 根据指定的键，在Map集合中获取对应的值。
- `public Set<K> keySet()`: 获取Map集合中所有的键，存储到Set集合中。
- `public Set<Map.Entry<K,V>> entrySet()`: 获取到Map集合中所有的键值对对象的集合(Set集合)。
- `public boolean containKey(Object key)`:判断该集合中是否有此键。

#### 3.2.2演示Map的常用方法

需求：通过HashMap演示Map集合常用方法

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        Map<Integer, String> m = new HashMap<>();
        //添加数据 public V put(K key, V value)
        // System.out.println(m.put(1, "a"));
        // System.out.println(m.put(1, "b"));//键不能重复，相同键的内容被新值替换，返回旧值
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        System.out.println(m);
        System.out.println("-------");
        // 根据键删除键值对  public V remove(Object key)
        System.out.println(m.remove(3));
        System.out.println(m);
        System.out.println("-------");
        // public V get(Object key)
        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
        System.out.println("-------");
        // 获取所有的键的单列集合  public Set<K> keySet()
        Set<Integer> keyset = m.keySet();
        //遍历所有的键
        for (Integer key : keyset) {
            System.out.println(key);
        }
        System.out.println("-------");
        // public Set<Map.Entry<K,V>> entrySet()
        // public Set<键值对对象> entrySet()
        Set<Map.Entry<Integer, String>> entrySet = m.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println(entry);
        }
        System.out.println("-------");
        //public boolean containKey(Object key)
        System.out.println(m.containsKey(1));
        System.out.println(m.containsKey(2));
        System.out.println(m.containsKey(3));
    }
}

```

### 小结

```

```

## 知识点-Map的遍历

### 目标

- 掌握Map集合的遍历

### 路径

- 方式1:键找值
- 方式:2键值对
- 演示两种遍历方式

### 讲解

#### 3.3.1方式1:键找值

通过元素中的键，获取键所对应的值

步骤：
- 获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示:`keyset()`
- 遍历键的Set集合，得到每一个键。
- 根据键，获取键所对应的值。方法提示:`get(K key)`


![](./day06-imgs\Map集合遍历方式一.bmp)

#### 3.3.2演示键找值方式遍历

需求：演示通过键找值的方式实现Map集合遍历

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建Map集合对象
        HashMap<Integer, String> hm = new HashMap<>();
        //添加数据
        hm.put(1, "a");
        hm.put(2, "b");
        hm.put(3, "c");
        //遍历双列集合数据
        // 1.获取所有的键  keySet
        Set<Integer> keys = hm.keySet();
        // 2.遍历所有的键
        for (Integer key : keys) {
            // 3.在遍历的过程中，根据获取的键，得到对应的值
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }

    }
}

```

#### 3.3.3方式2:键值对

`java.util.Map.Entry` 将键值对的对应关系封装成了对象。Map的内部接口定义，具体功能由Map子类负责具体实现。

Entry中的常用方法

- `public K getKey()`：获取Entry对象中的键。
- `public V getValue()`：获取Entry对象中的值。

步骤：

- 获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示:`entrySet()`。
- 遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
- 通过键值对(Entry)对象，获取Entry对象中的键与值。  方法提示:`getkey() getValue()`     

![](./day06-imgs\Map集合遍历方式二.bmp)

> tips：Map集合不能直接使用迭代器或者foreach进行遍历。但是转成Set之后就可以使用了。

#### 3.3.4演示键值对方式遍历

需求：演示通过键找值的方式实现Map集合遍历

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建Map集合对象
        HashMap<Integer, String> hm = new HashMap<>();
        //添加数据
        hm.put(1, "a");
        hm.put(2, "b");
        hm.put(3, "c");
        //遍历集合
        // 1.获取所有的键值对对象的集合
        Set<Map.Entry<Integer, String>> entries = hm.entrySet();
        // 2.遍历键值对对象的集合
        for (Map.Entry<Integer, String> entry : entries) {
            // 3使用键值对对象的方法，分别获取对应的键和值
            // public K getKey()
            Integer key = entry.getKey();
            // public V getValue()
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }
    }
}
```

### 小结

```java

```

## 知识点--HashMap键存储自定义类型

### 目标

- 掌握HashMap的使用

### 路径

- 概述
- 演示HashMap键存储自定义类型

### 讲解

#### 3.4.1概述

当给HashMap中存放自定义对象时，如果自定义对象作为key存在，这时要保证对象唯一，必须复写对象的hashCode和equals方法。

#### 3.4.2演示HashMap键存储自定义类型

需求：将包含姓名和年龄的学生对象作为键, 家庭住址作为值，存储到Hashmap集合中。

//学生类代码

```java
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

//学生类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建Map集合对象
        HashMap<Student, String> hm = new HashMap<>();
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加数据
        hm.put(s1, "北京");
        hm.put(s2, "上海");
        hm.put(s3, "广州");
        hm.put(s4, "深圳");
        //查看数据:键值对
        Set<Map.Entry<Student, String>> entries = hm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            //获取键:学生对象
            Student s = entry.getKey();
            //获取值
            String str = entry.getValue();
            //打印
            System.out.println(s + "---" + str);
        }
    }
}

```

### 小结

```

```

## 知识点--LinkedHashMap键存储自定义类型

### 目标

- 理解LinkedHashMap的使用

### 路径

-   概述
-   演示LinkedHashMap键存储自定义类型

### 讲解

#### 3.5.1概述

LinkedHashMap是HashMap子类，底层由链表和哈希表组合。要保证map中存放的key和取出的顺序一致，可以使用java.util.LinkedHashMap集合来存放。

#### 3.5.2演示LinkedHashMap键存储自定义类型

需求：将包含姓名和年龄的学生对象作为键, 家庭住址作为值，存储到 LinkedHashmap集合中。

//学生类代码

~~~java
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
~~~



//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        LinkedHashMap<Student, String> lhm = new LinkedHashMap<>();
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加数据
        lhm.put(s1, "北京");
        lhm.put(s2, "上海");
        lhm.put(s3, "广州");
        lhm.put(s4, "深圳");
        //展示数据:键值对
        Set<Map.Entry<Student, String>> entries = lhm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            //获取键
            Student s = entry.getKey();
            //获取值
            String str = entry.getValue();
            //打印内容
            System.out.println(s + "---" + str);
        }
    }
}

```

### 小结

```java

```

## 知识点--TreeMap键存储自定义类型

### 目标

- 理解TreeMap集合

### 路径

- 概述
- 演示TreeMap集合
- 演示自然排序
- 演示比较器排序

### 讲解

#### 3.6.1概述

`java.util.TreeMap` 是是Map接口的一个实现类,是一种基于**红黑树**的实现，可以对元素的***键***进行排序。

TreeMap集合存储的对象如果作为键，必须拥有排序规则(比较器)，否则会报出异常。`cannot be cast to java.lang.Comparable`

自然排序：

- 对象类型自身拥有的排序规则，由对象类实现java.lang.Comparable接口，重写compare方法
- 使用TreeSet无参构造创建对象

比较器排序 ：

- 存储容器拥有的排序规则，创建重写compare方法的Comparator接口子类对象,作为参数传递给TreeMap构造方法
- 使用TreeSet有参构造创建对象。public TreeMap(Comparator<E> comparator):    根据指定的比较器进行排序

#### 3.6.2演示TreeMap集合

需求：将包含姓名和年龄的学生对象作为键, 家庭住址作为值，存储到 TreeMap集合中

学生类代码

```java
public class Student implements Comparable<Student> {
    String name;
    int age;

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

    @Override
    public int compareTo(Student o) {//this   o
        //this 与  o比较  升序
        // int num = this.name.compareTo(o.name);
        // num = (num == 0) ? this.age - o.age : num;
        //o 与  this比较  降序
        int num = o.name.compareTo(this.name);
        num = (num == 0) ? o.age - this.age : num;
        return num;
    }
}

```

//测试类代码

```java
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        //使用比较器排序
        TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //1o 与  o2比较  升序
                // int num = o1.name.compareTo(o2.name);
                // num = (num == 0) ? o1.age - o2.age : num;
                //o2 与  o1比较  降序
                int num = o2.name.compareTo(o1.name);
                num = (num == 0) ? o2.age - o1.age : num;
                return num;
            }
        });
        //使用自然排序
        // TreeMap<Student, String> tm = new TreeMap<>();
        //创建学生对象
        /*
        Student s1 = new Student("张三", 18);
        tm.put(s1,"北京");
        */
        //使用匿名对象的方式，创建对象并添加数据
        tm.put(new Student("张三", 18), "北京");//Student cannot be cast to class Comparable
        tm.put(new Student("李四", 20), "北京");
        tm.put(new Student("张三", 20), "北京");
        tm.put(new Student("张三", 18), "北京");
        //遍历集合
        Set<Map.Entry<Student, String>> entries = tm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            //获取键
            Student key = entry.getKey();
            //获取值
            String value = entry.getValue();
            //打印数据
            System.out.println(key + "---" + value);
        }
    }
}
```

### 小结

```java

```

## 案例-Map集合练习

### 需求

输出一个字符串中每个字符出现次数。

### 分析

```
获取一个字符串对象
创建一个Map集合，键代表字符，值代表次数。
遍历字符串得到每个字符。
	判断Map中是否有该键。boolean containKey(Object key)
   	 	如果没有，第一次出现，存储次数为1；
    	如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
打印最终结果
```

### 实现

//测试类代码

```java
ublic class Test {
    public static void main(String[] args) {
        // 1.定义字符串(键盘录入)
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入一段字符串...");
        String line = sc.nextLine();
        // 2.定义Map集合--HashMap
        HashMap<Character, Integer> hm = new HashMap<>();
        // 3.遍历字符串
        for (int i = 0; i < line.length(); i++) {
            //      获取每一个字符
            char c = line.charAt(i);
            //      判断:获取的字符，在Map集合的键里面是否存在
            if (hm.containsKey(c)) {
                //      存在:
                //      获取该字符对应的次数
                int count = hm.get(c);
                //      将次数+1
                count++;
                //      put(字符,+1之后的次数)
                hm.put(c, count);
            } else {
                //      不存在:put(字符,1)
                hm.put(c, 1);
            }
        }
        //打印集合，展示所有字符锁对应的次数
        Set<Map.Entry<Character, Integer>> entries = hm.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            //获取键:
            char c = entry.getKey();
            //获取值
            int count = entry.getValue();
            //打印字符与对应的次数
            System.out.println(c + "出现的次数是:" + count);
        }

    }
}
```

### 小结

```

```



# 第四章  模拟斗地主

### 需求:

- 按照斗地主的规则，完成洗牌发牌的动作。

![](./day06-imgs\斗地主.png)

- 具体规则：
  - 使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌
  - 
    牌面展示规则：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3...     
  - 花色按照黑红梅方的顺序，优先花色排列。    

### 分析

- 准备牌

![](./day06-imgs\准备牌.png)

- 洗牌--发牌--看牌：使用牌号操作。

![](./day06-imgs\洗牌-发牌-看牌.png)

### 步骤

- 准备牌
  将牌盒设计为一个HashMap<Integer，String>集合
  将牌号作为键，牌面(花色和数字组成)作为值，按照映射关系，放进牌盒集合
  使用一个ArrayList集合记录所有牌号。
- 洗牌：
  使用Collections类的shuffle方法对牌号进行打乱
- 发牌
  为每个玩家和剩余底牌各分配一个ArrayList<Integer>记录牌号。
  将牌号通过对3取模判断，依次发牌，存入玩家集合中
  将最后3张牌号，直接存放于底牌集合中
- 看牌
  使用Collections类中的sort方法对玩家的牌号进行排序
  遍历手中牌号,从牌盒中获取对应牌面并打印。。

### 实现

演示代码

```java
public class Test {
    public static void main(String[] args) {
        //准备牌
        //     将牌盒设计为一个HashMap<Integer，String>集合
        HashMap<Integer, String> pokeBox = new HashMap<>();
        //     将牌号作为键，牌面(花色和数字组成)作为值，按照映射关系，放进牌盒集合
        //     获取花色数组
        String[] colors = "♠,♥,♣,♦".split(",");
        String[] nums = "2,A,K,Q,J,10,9,8,7,6,5,4,3".split(",");

        int index = 54;
        //添加大王
        pokeBox.put(index, "大王");

        index--;
        pokeBox.put(index, "小王");
        index--;
        for (String num : nums) {
            for (String color : colors) {//♠   ♥   ♣  ♦
                String poke = color + num;
                pokeBox.put(index, poke);
                index--;
            }
        }
        // System.out.println(pokeBox);
        //     使用一个ArrayList集合记录所有牌号
        ArrayList<Integer> pokeNums = new ArrayList<>();
        for (int i = 1; i <= 54; i++) {
            pokeNums.add(i);
        }

        //洗牌
        Collections.shuffle(pokeNums);
        // System.out.println(pokeNums);
        //发牌
        //准备3个玩家的集合，和底牌集合
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        for (int i = 0; i < pokeNums.size(); i++) {
            //通过索引获取每一张牌号，相当于就是那张牌
            int poke = pokeNums.get(i);
            //留3张底牌
            if (i >= 51) {
                diPai.add(poke);
            } else {
                //通过索引对3取余进行判断
                if (i % 3 == 0) {
                    player1.add(poke);
                } else if (i % 3 == 1) {
                    player2.add(poke);
                } else {
                    player3.add(poke);
                }
            }
        }
        //看牌
        //因为看的牌也是要有序的，先排序，再看牌

       /* Collections.sort(player1);

        for (Integer key : player1) {
            String poke = pokeBox.get(key);
            System.out.print(poke+" ");
        }*/
        System.out.print("玩家1牌面:");//不要加换行
        showPoke(player1, pokeBox);
        System.out.print("玩家2牌面:");//不要加换行
        showPoke(player2, pokeBox);
        System.out.print("玩家3牌面:");//不要加换行
        showPoke(player3, pokeBox);
        System.out.print("底牌:");//不要加换行
        showPoke(diPai, pokeBox);

    }

    public static void showPoke(ArrayList<Integer> pokeNums, HashMap<Integer, String> pokeBox) {
        Collections.sort(pokeNums);
        for (Integer key : pokeNums) {
            String poke = pokeBox.get(key);
            System.out.print(poke + " ");
        }
        System.out.println();
    }
}
```

### 小结

```

```



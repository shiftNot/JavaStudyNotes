## 一  编程题【Lambda表达式】

### 1.1 

请使用Lambda表达式启动一个Thread线程，线程中打印：1--100所有数字。

```java
public class H11 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i+1);
            }
        }).start();
    }
}
```

### 1.2

请使用Lambda表达式调用Collections的sort()方法，可以实现对一个`List<String>`集合进行：降序排序。

​	编写main()方法，在main()中按以下步骤编写代码：

​	1. 定义一个`List<String>`集合，并存储以下数据：

​			“cab”

​			“bac”

​			“acb”

​			“cba”

​			“bca”

​			“abc”

​	2. 使用Lambda表达式调用Collections的sort()方法对集合进行降序排序。

	3. 排序后向控制台打印集合的所有元素。

```java
public class H12 {
    public static void main(String[] args) {
        // 1. 存储数据
        List<String> list = new ArrayList<>(Arrays.asList("cab", "bac", "acb", "cba", "bca", "abc"));
        
        // 2. 排序
        Collections.sort(list, (a, b) -> b.compareTo(a));

        // 3. 打印
        System.out.println(list);
    }
}
```

还可以这么做，更简洁，不过跟题目要求不符

```java
// 1. 存储数据
List<String> list = new ArrayList<>(Arrays.asList("cab", "bac", "acb", "cba", "bca", "abc"));
// 2.        排序     倒序                       遍历打印
list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
```

## 二 编程题【Stream流】

### 2.1

定义main()方法，按以下顺序编写程序：

l 定义集合`List<String>`，添加以下数据：

​			“张三丰”

​			“王思聪”

​			“张飞”

​			“刘晓敏”

​			“张靓颖”

l 使用Stream流的forEach()方法打印集合的所有元素

```java
void forEach(Consumer<? super T> action);

public class H21 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖"));
        list.stream().forEach(s->{
            System.out.println(s);
        });
    }
}
```



### 2.2

定义main()方法，按以下顺序编写程序：

l 定义集合`List<String>`，添加以下数据：

​			“张三丰”

​			“王思聪”

​			“张飞”

​			“刘晓敏”

​			“张靓颖”

l 使用Stream流的filter()方法筛选集合中所有的“张”姓学员；

筛选后，使用forEach()方法打印筛选结果。

```java
Stream<T> filter(Predicate<? super T> predicate);
public class H22 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖"));

        list.stream().filter(s -> s.startsWith("张")).forEach(s -> {
            System.out.println(s);
        });
    }
}
```



### 2.3

定义main()方法，按以下顺序编写程序：

l 定义集合`List<String>`，添加以下数据：

​			“张三丰”

​			“王思聪”

​			“张飞”

​			“刘晓敏”

​			“张靓颖”

l 使用Stream流的filter()方法筛选集合中所有的“张”姓学员；

l 筛选后，使用count()方法获取筛选的数量。

```java
Stream<T> filter(Predicate<? super T> predicate);
long count();
public class H23 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖"));

        System.out.println(list.stream().filter(s -> s.startsWith("张")).count());
    }
}
```



### 2.4

定义main()方法，按以下顺序编写程序：

l 定义集合`List<String>`，添加以下数据：

​	“王佳乐”

​			“张三丰”

​			“王思聪”

​			“张飞”

​			“刘晓敏”

​			“张靓颖”

​			“王敏”

​			

l 使用Stream流的filter()方法筛选集合中所有的“张”姓学员；

l 筛选后，获取前两个，并打印。

l 重新获取Stream流，用filter()方法筛选出所有的“王”姓学员；

l 筛选后，跳过前1个，打印剩余的人员。

```java
Stream<T> limit(long maxSize);
public class H24 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("王佳乐", "张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖", "王敏"));

        System.out.println("张姓学员，获取前2个");
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(s->{
            System.out.println(s);
        });
        System.out.println("王姓学员，跳过前1个");
        list.stream().filter(s -> s.startsWith("王")).skip(1).forEach(s->{
            System.out.println(s);
        });
    }
}
```



### 2.5

定义main()方法，按以下顺序编写程序：

l 定义集合`List<String>`，添加以下数据：

​	“王佳乐”

​			“张三丰”

​			“王思聪”

​			“张飞”

​			“刘晓敏”

​			“张靓颖”

​			“王敏”

l 先筛选出所有的“张”姓学员；

l 再筛选出所有的“王”姓学员；

l 将两个流合并为一个流

l 打印合并后的每个元素。

```java
static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
public class H25 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("王佳乐", "张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖", "王敏"));
		// 合并两个流
        Stream.concat(
                list.stream().filter(s -> s.startsWith("张")),
                list.stream().filter(s -> s.startsWith("王"))
        ).forEach(s->{
            System.out.println(s);
        });
        
    }
}
```

### 2.6

1.定义一个Person类，包含一个属性：姓名(String)

​	 	定义无参、全参构造方法

​		定义get/set方法

​	2.定义main()方法，按依稀顺序编写程序：

l 定义集合`List<String>`，添加以下数据：

​		“王佳乐”

​		“张三丰”

​		“王思聪”

​		“张飞”

l 使用Stream流的map()方法，将每个元素封装为一个Person对象。

l 将新流中的元素提取为List集合。

l 遍历、打印集合中所有的Person对象信息。

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
收集到集合中
Stream流提供collect方法，其参数需要一个java.util.stream.Collector<T,A, R>接口对象来指定收集到哪种集合中。幸运的是，java.util.stream.Collectors类提供一些方法，可以作为Collector接口的实例：
- public static <T> Collector<T, ?, List<T>> toList()：转换为List集合。
- public static <T> Collector<T, ?, Set<T>> toSet()：转换为Set集合。
收集到数组:
Object[] toArray();

public class H26 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("王佳乐", "张三丰", "王思聪", "张飞"));
		
        List<Person> personList = list.stream()
            .map(s -> new Person(s)) // 映射字符串至person对象
            .collect(Collectors.toList()); // 提取为 List
        for (Person person : personList) {
            System.out.println(person.getName());
        }
    }
}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## 三 编程题【等待和唤醒】

### 3.1

​	请用“等待唤醒”机制编写一个程序，要求：

​	第一个线程：遍历1--1000所有的数字，在遍历过程中，如果发现这个数字能同时被

​					2,3,5,7整除，立即wait()退出等待，让第二个线程进入。

​	第二个线程：运行后，将一个计数器 + 1，之后再唤醒等待的线程。

​	

​	主线程中：休息2秒，让两个线程全部执行完毕，打印“计数器”的结果。

​	

​	注意：第二个线程使用的计数器，要定义在线程外部。

```java
* 分析:
 *      1.假设flag为1执行线程1,flag为2执行线程2
 *          对于线程1: flag为2,进入无限等待,flag为1,执行循环
 *          对于线程2: flag为1,进入无限等待,flag为2,执行计数+1操作
 *      2.线程1是遍历1--1000的数字,当遍历出来的数字同时被2,3,5,7整除,立即唤醒线程2执行count++
 *      3.线程2是将一个计数器 + 1，之后再唤醒等待的线程。
 */
public class Test1 {
    static Object lock = new Object();
    static int count = 0;
    static int flag = 1;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    synchronized (lock){
                        if (flag == 2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (i % 2 == 0 && i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
                            System.out.println(i);
                            // 否则就继续执行
                            flag = 2;
                            lock.notify();// 唤醒线程
                        }
                    }
                }
                System.out.println("===执行完毕===");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 被唤醒了就执行一次++
                while (true) {
                    synchronized (lock) {
                        if (flag == 1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (flag == 2){
                            count++;//计数+1;
                            flag = 1;
                            lock.notify();
                        }
                        System.out.println("========");
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
		System.exit(0);
    }
}
```

正确结果应当是：

```
210
420
630
840
4
```


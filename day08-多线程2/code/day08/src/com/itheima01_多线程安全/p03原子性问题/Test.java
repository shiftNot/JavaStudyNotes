package com.itheima01_多线程安全.p03原子性问题;

/*
多线程原子性
    1.概述
    	原子性是指在一组符合一定逻辑的操作，要么所有的操作都得到了执行不被中断，要么所有的操作都不执行，多个操作是一个不可以分割的整体。
    	举例:张三账户给李四1000元。`张三账户扣除1000元`，`李四账户增加1000元`，这两个动作要么都发生，要么都不发生。
    2.问题演示
    	需求:通过主线程和子线程对一个变量各递增10000次，预期得到结果20000。
    3.问题总结
    	执行结果与预期结果存在误差
    4.问题分析见《原子性问题分析》
    	count++操作包含3个步骤:
    		1.从主内存中读取数据到工作内存--2.对工作内存中的数据进行++操作--3.将工作内存中的数据写回到主内存
    	count++没保障原子性，以上步骤，随时会被另一个线程打断，从而导致不可预计的线程安全问题出现。
volatile不能解决原子性问题
    1.概述
    	多线程环境下，volatile关键字可以保证共享数据的可见性，但是并不能保证对数据操作的原子性。
    2.原因
    	volatile可以保证主内存共享变量被修改后其他工作内存同步数据，但不能保证主内存数据的有序读写;
同步机制解决原则性问题
    解决办法：通过给count++添加同步机制，使count++称为一个原子性操作。
原子类解决原子性问题
    1.概述
    	JDK1.5开始，提供了一系列，用法简单，性能高效，线程安全的，用于更新变量的类，统称为原子类
    	java.util.concurrent.atomic  原子包，所有的原子类都位于这个包下
    2.常见原子类
    	AtomicInteger 原子类型的int值		AtomicLong 原子类型的long值
    	AtomicReference 原子类型的对象		AtomicReferenceArray 原子类型的对象数组
    	AtomicIntegerArray 原子类型的int数组	AtomicLongArray 原子类型的long数组
    3.构造方法
    	public AtomicInteger()	初始化一个默认值为0的原子型Integer
    	public AtomicInteger(int initialValue)    初始化一个指定值的原子型Integer
    4.常用方法
    	int get():   		获取值
    	int getAndIncrement():		以原子方式将当前值加1，注意，这里返回的是自增前的值。
    	int incrementAndGet():     	以原子方式将当前值加1，注意，这里返回的是自增后的值。
    	int addAndGet(int data):	以原子方式将输入的数值与实例中的值相加，并返回结果。
    	int getAndSet(int value):   以原子方式设置为newValue的值，并返回旧值。
CAS机制
    1.概述
    	CAS(Compare and Swap)即比较并替换,意识是先经过比较之后的，决定是否进行替换
    2.原理 见《CAS机制原理图》
    	CAS有三个操作数：内存值V、旧的预期值A、要修改的值B
    	当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true
    	如果不相同则证明内存值在并发的情况下被其它线程修改过了，则不作任何修改，返回false
    	根据新的内存值，记录新的预期值，并计算要修改的值，再次重复步骤2.
    3.CAS与synchronized区别
    	同步机制是从悲观的角度出发：
    		总是假设最坏的情况，每次去拿数据的时候都认为别人会修改。
    		共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程。
    		因此Synchronized我们也将其称之为悲观锁，jdk中的ReentrantLock也是一种悲观锁。
    	CAS机制是从乐观的角度出发:
    		总是假设最好的情况，每次去拿数据的时候都认为别人不会修改。
    		不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据。
    		CAS这种机制我们也可以将其称之为乐观锁
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //启动子线程，递增十万次
        CountThread ct = new CountThread();
        ct.start();
        //主线程也对count变量递增十万次
        for (int i = 0; i < 100000; i++) {
            //使用同步机制解决原子性问题
            //synchronized (ct) {
            //    ct.count++;
            //}
            ct.count.incrementAndGet();

        }
        //打印结果前，确保二十万次底层全部执行完,等子线程执行完成
        Thread.sleep(1000);
        //打印结果
        System.out.println(ct.count);
    }
}


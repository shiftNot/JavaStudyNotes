package com.itheima.demo09_单例设计模式;

public class Test {
    /*
        介绍:
            单例模式（Singleton Pattern）是 Java 中的设计模式之一，属于创建型模式，
            它提供了一种创建对象的最佳方式。
        作用：保证在程序运行期间,某个类有且仅能创建一个对象,从而节省内存资源。
        单例设计模式特点:
            1.将构造方法私有化,确保在类的外部不能通过new来创建对象
            2.在本类中创建该类的唯一对象
            3.提供公共的访问方式来访问该类的唯一对象  静态方法
        实现方式分类
            饿汉模式:类加载到内存中时，就将类的对象创建好，以备使用，且对象不能再新建。
            懒汉模式:在需要使用对象的时候，通过指定方法获取创建的对象，且对象只能创建这一次。
        使用场景：
            1.一个类没必要创建多个对象时 使用单例设计模式 保证这个类在程序运行期间有且仅有一个对象 从而节省内存
            2.单例设计模式一般用在工具类上工具类一般采用单例设计模式实现
     */
    //饿汉式设计模式测试
    /*public static void main(String[] args) {
        Student_饿汉式 student1 = Student_饿汉式.getInstance();
        System.out.println("student1 = " + student1);
        Student_饿汉式 student2 = Student_饿汉式.getInstance();
        System.out.println("student2 = " + student2);
        Student_饿汉式 student3 = Student_饿汉式.getInstance();
        System.out.println("student3 = " + student3);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Student_饿汉式.getInstance());
            }).start();
        }
    }*/

    //懒汉式设计模式测试
    public static void main(String[] args) {
        /*System.out.println(Student_懒汉式.getInstance());
        System.out.println(Student_懒汉式.getInstance());
        System.out.println(Student_懒汉式.getInstance());*/

        System.out.println("-------------------------");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Student_懒汉式.getInstance());
            }).start();
        }
    }

}

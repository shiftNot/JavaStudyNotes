package com.itheima03_常用API;

/*
1.概述:java.lang.Object 类是Java语言中的根类，即所有类的父类。
2.常用方法：Object中有11个可被子类继承的方法，常用的有equals方法、toString方法等。
	public String toString()：
		返回该对象的字符串表示。
		默认返回，“对象的类型名+@+内存地址值”字符串形式。子类可以通过重写获取自己想要的字符串内容。
	public boolean equals(Object obj)：
		判断指定对象(参数)是否与此对象(调用者)“相同”。
		默认返回，通过==运算符对地址值做比较后，获取的比较结果
3.重写toString()方法
        按照需要，展示指定类中的内容，若不重写则展示地址值。
        输出语句中展示的内容，均为指定对象的字符串形式。
        快捷方式：alt+insert-->toString()-->选择要展示的成员-->OK
4.重写equals(Xxx)方法
        按照需要，将两个对象按照指定规则进行比较，若不重写则通过地址值比较。
        比较步骤
            ①比较两个对象的地址值是否相同，如果相同，返回true
            ②如果参数为空，或者类型不一致，返回false
            ③将参数转换为当前类型
            ④比较两个对象的内容是否相同，并返回比较结果
        快捷方式：alt+insert-->equals and hashcode -->选择要比较的成员-->OK
示例：通过定义子父类，理解直接与间接继承，及toString方法和equals方法的继承及重写使用。
     通过定义Studen类，演示toString与equals方法的重写操作。

 */
public class Test_01Object {
    public static void main(String[] args) {
        //创建Student对象
        //Student s = new Student("张三", 18);
        Student s = new Student(null, 18);
        System.out.println(s.toString());
        System.out.println(s);

        boolean b = s.equals(new Student("张三", 18));
        System.out.println(b);
    }
}

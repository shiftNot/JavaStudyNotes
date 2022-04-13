package com.itheima03_多态.p04多态应用;

/*
1.应用场景
	变量多态的使用     父类/接口名  变量名   = 子类/实现类对象;(同一个变量,可以指向不同的子类或实现类对象)
	形参多态的使用	修饰符	返回值类型 方法名(父类/接口名 变量名){  变量名.方法名(); }
	返回值类型多态的使用	修饰符 	父类/接口名 方法名(参数) { return 子类/实现类对象; }
2.好处和弊端
	多态的好处：可以将方法的参数或返回值定义为父类引用，使程序编写的更简单，提高程序的灵活性，扩展性，复用性
	多态的弊端：无法访问子类/实现类的特有方法

示例:
    动物
        行为:吃
    猫
        行为:
            吃
            捉耗子
    狗
        行为:
            吃
            看家
 */
public class Test {
    public static void main(String[] args) {
        //变量多态的使用
        Animal a = new Cat();
        a.eat();
        a = new Dog();
        a.eat();
        System.out.println("--------");
        //形参多态的使用
        Cat c = new Cat();
        showAnimal(c);
        showAnimal(new Dog());
        System.out.println("--------");
        //返回值类型多态的使用
        Animal a2 = getAnimal("猫");
        a2.eat();
        a2=getAnimal("狗");
        a2.eat();
    }

    //展示动物
    /*public static void showCat(Cat c) {
        c.eat();
    }

    public static void showDog(Dog d) {
        d.eat();
    }*/
    public static void showAnimal(Animal a){
        a.eat();
        //展示子类的特有内容，但是，多态的情况下，编译看左边(父类)，不能调用父类中没有的内容。
        //父类的引用，不能使用子类的特有的内容。
        //a.catchMouse();
        //a.lookHouse();
    }

    //获取动物
   /* public static Cat getCat(){
        return new Cat();
    }
    public static Dog getDog(){
        return new Dog();
    }*/
    public static Animal getAnimal(String type){
        if ("猫".equals(type)){
            return new Cat();
        }else if ("狗".equals(type)){
            return new Dog();
        }else{
            return null;
        }
    }
}

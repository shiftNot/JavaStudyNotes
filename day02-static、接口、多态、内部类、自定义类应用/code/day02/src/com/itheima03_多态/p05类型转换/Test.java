package com.itheima03_多态.p05类型转换;

/*
1.转换的意义：由于多态弊端，通过父类引用,不能调用子类/实现类的特有方法，若强行调用子类/实现类特有方法，导致编译报错。
2.转换分类
        向上转型:父类类型  变量名 = new 子类类型() 或 子类对象引用;(子类/实现类对象--默认转换为-->父类/接口类型)
        向下转型:子类类型 变量名 = (子类类型) 父类变量名;(父类/接口类型--强制转换为-->子类/实现类类型)
3.类型转换中的问题:
        当“两个类型不存在继承/实现关系”或“子类引用指向父类对象”会出现类型转换异常(ClassCastException)
4.问题解决办法:
        格式:变量名 instanceof 数据类型  (判断该变量名所对应的对象的类型 是否属于  指定的数据类型)
            	如果变量属于该数据类型，返回true。
            	如果变量不属于该数据类型，返回false。
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
        //向上转型  多态的格式
        Animal a = new Cat();

        showAnimal(new Cat());
        showAnimal(new Dog());
    }

    public static void showAnimal(Animal a) {
        a.eat();
        //假设传进来的是猫,父类引用不能使用子类特有方法，希望可以将这个引用转为猫类型的引用
        //a.catchMouse();
        //利用向下转型，将父类类型的引用，转为了子类自己的类型的引用。
        if (a instanceof Cat) {
            Cat c = (Cat) a;//向下转型
            c.catchMouse();
        } else if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.lookHouse();
        }
    }
}

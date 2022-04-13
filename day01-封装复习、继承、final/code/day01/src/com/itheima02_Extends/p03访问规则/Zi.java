package com.itheima02_Extends.p03访问规则;

public class Zi extends Fu {
    int a = 999;
    int b2 = 222;

    //父类的构造方法，不能放到子类中
    //public Fu() {
    //}
    public Zi() {
        //调用父类构造方法（默认调用）
        //super();//隐含一个调用父类无参构造的操作。
        super();//手动调用父类构造，默认调用父类无参构造的操作就不存在了。
        System.out.println("我是子类的无参构造方法");
        //调用父类构造方法的操作，必须在子类构造方法的第一行。
        //super();
    }

    //方法重写:重写了父类中的方法，目的是替换掉父类中该方法。
    //@Override 用于检查，被注解的方法，是否满足方法重写要求。
    //权限需要大于或等于父类的该方法的权限
    //private void show(){
    @Override
    //还可以检查，当前类是否继承了指定的类
    //public void show3(){
    //public void show(int num){
    //返回值不同，语法上就会报错，不需要Override验证
    //public int show(){
    public void show() {
        System.out.println("子类中与父类同名的show方法");
    }

    public void show2() {
        System.out.println("子类中与父类不同名的show2方法");
    }
}

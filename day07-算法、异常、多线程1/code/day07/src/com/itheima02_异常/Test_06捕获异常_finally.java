package com.itheima02_异常;

/*
捕获异常完整格式
	与try结合使用，当try中内容执行，finally一定执行，若try执行前程序结束，finally不执行。
	格式:
	        try{
	            编写可能会出现异常的代码
	        }catch{
	            处理异常的代码/记录日志/打印异常信息/继续抛出异常
	        }
	        ...
	        finally{
	            执行try中行为执行后，一定要执行的操作，一般用于结束资源
	        }
需求:通过除数为0异常，演示finally使用效果

 */
public class Test_06捕获异常_finally {
    public static void main(String[] args) {
        /*try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("除数为0了，告诉小明，它算错了");
        }*/


        //try可以跟finally结合使用，但是如果没有catch，意味着问题交给调用者,如果最终交给虚拟机， 程序就会直接中断。
        /*try {
            System.out.println(10 / 0);
        } finally {
            System.out.println("除数为0了，告诉小明，它算错了");
        }*/

        //try没有执行，对应的finally就不会执行
        System.out.println(10 / 0);
        try {

        } finally {
            System.out.println("除数为0了，告诉小明，它算错了");
        }
        System.out.println("结束");
    }
}

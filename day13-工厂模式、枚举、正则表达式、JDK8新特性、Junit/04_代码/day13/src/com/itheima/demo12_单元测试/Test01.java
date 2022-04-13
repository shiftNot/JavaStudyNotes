package com.itheima.demo12_单元测试;

import org.junit.Test;

/**
 * junit单元测试使用步骤：
 *  1.下载junit相关工具包jar包
 *  2.将junit工具包 放入到指定项目下 并添加依赖
 *  3.在要进行的测试方法上面打上@Test注解
 *  4.就可以选中方法直接运行了
 *
 */
public class Test01 {
    /*
        junit使用注意事项
            1.测试方法的权限修饰符使用public
            2.测试方法返回值类型为void
            3.测试方法没有参数
            4.测试方法必须使用@Test注解

            总结：方法上打了@Test注解的方法 必须使用public修饰 返回值类型为void，且没有方法参数。
     */
    @Test
    public void fun01(){
        System.out.println("fun01...");
    }

    @Test
    public void fun02(){
        System.out.println("fun02...");
    }
}

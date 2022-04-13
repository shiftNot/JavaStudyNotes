package com.itheima.demo12_单元测试;

import org.junit.*;

public class Test03_junit其他注解 {
    /*
        其他注解
            @Before  修饰方法,在@Test方法之前执行,@Before方法可以有多个       【在调用测试方法执行之前，完成资源的初始化操作】
            @After   修饰方法,在@Test方法之后执行,@After方法可以有多个        【在调用测试方法执行之后，完成资源的释放操作】
            @BeforeClass 修饰静态方法,在所有@Before执行之前执行,只会执行一次
            @AfterClass  修饰静态方法,在所有@After执行之后执行,只会执行一次
     */

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass...");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass...");
    }

    @Before
    public void before(){
        System.out.println("before...");
    }

    @After
    public void after(){
        System.out.println("after...");
    }

    @Test
    public void fun01(){
        System.out.println("fun01...");
    }

    @Test
    public void fun02(){
        System.out.println("fun02...");
    }
}

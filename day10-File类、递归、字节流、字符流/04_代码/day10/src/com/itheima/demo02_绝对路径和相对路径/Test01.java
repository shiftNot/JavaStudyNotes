package com.itheima.demo02_绝对路径和相对路径;

import java.io.File;

public class Test01 {
    public static void main(String[] args) {
        /*
            绝对路径和相对路径
            绝对路径：从盘符开始的路径，是一个完整的路径
                eg:D:\\workspace\\java126\\day10\\aa\\a.txt
                使用绝对路径可能出现的问题：
                    1.写绝对路径比较麻烦  路径比较长
                    2.一旦项目迁移了，可能出现找不到文件路径的报错  【你的idea项目路径：E:\sz126\day10\\aa\\a.txt】
                    3.项目迁移容易出问题 windows | Linux  | mac  windows：C|D|E   linux|mac：/

            相对路径：相对于项目目录的路径，有一个参照物，是一个便捷的路径，推荐在开发中使用
                eg:  相对路径：day10\aa\a.txt
                    老师电脑：D:\\workspace\\java126\\day10\\aa\\a.txt
                    你的电脑：E:\sz126\day10\\aa\\a.txt

                老师：
                    绝对路径：广东省深圳市宝安区西乡街道麻布新村xx巷xx栋
                    相对路径1：宝安区西乡街道麻布新村xx巷xx栋
                    相对路径2：西乡街道麻布新村xx巷xx栋
                使用相对路径使用要点：
                    相对谁  谁哪一部分路径就不用写了【目前我们写的代码一般都是相对于项目目录的  所以项目目录那一部分可以不用写了】

            怎么选择使用相对路径还是绝对路径：
                1.一般项目开发  在自己的项目中都使用相对路径
                2.如果想访问的别人的东西 或项目外的资源 使用绝对路径
         */

        //1.使用绝对路径创建a.txt的file对象
        File f1 = new File("D:\\workspace\\java126\\day10\\aa\\a.txt");
        System.out.println("f1 = " + f1);

        //2.使用相对路径创建a.txt的file对象
        File f2 = new File("day10\\aa\\a.txt");
        System.out.println("f2 = " + f2);
    }
}

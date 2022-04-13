package com.itheima.domain;

import com.itheima.bean.Student;
import com.itheima.utils.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    //存储学生对象的集合
    public static ArrayList<Student> stuArray = new ArrayList<>();
    //存储老师对象的集合
    public static ArrayList<Student> teaArray = new ArrayList<>();

    public static void main(String[] args) {

        //首界面
        //因为如果用户输入的是1或2选项，需要重写回到主界面，这里要加循环。
        while (true) {
            //1.展示界面
            System.out.println("1.学生管理系统\t2.教师管理系统\t3.退出");
            //2.输入选项
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的选择......");
            String choose = sc.nextLine();
            //3.使用switch匹配选项
            switch (choose) {
                case "1":
                    studentManager();
                    break;
                case "2":
                    System.out.println("进入教师管理系统");
                    System.out.println("结束教师管理系统");
                    break;
                case "3":
                    System.out.println("再见,谢谢使用");
                    //break;//结束switch的
                    //System.exit(0);//不推荐
                    return;
            }
        }
    }

    /**
     * 学生管理系统界面
     */
    public static void studentManager() {
        //因为如果用户输入的是1-4选项，需要重写回到学生管理系统界面，这里要加循环。
        while (true) {
            //1.展示界面
            System.out.println("1.添加学员\t2.修改学员\t3.删除学员\t4.查询学员\t5.返回");
            //2.输入选项
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入功能序号......");
            String choose = sc.nextLine();
            //3.使用switch匹配选项
            switch (choose) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updataStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("返回");
                    //break;
                    return;
            }
        }

    }

    /**
     * 该方法用于删除指定学员信息
     */
    public static void deleteStudent() {
        //录入要删除的学员的id
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学员ID");
        String sid = sc.nextLine();
        //查找要删除的id对应的学员在集合中的位置
        int index = Util.findIndex(stuArray, sid);
        //判断位置是否为-1，如果是代表没找到
        if (index == -1) {
            System.out.println("【错误】学员ID:" + sid + "没找到");
        } else {
            System.out.println("【查询结果】要删除的学员的信息");
            //获取要删除的学员
            Student s = stuArray.get(index);
            //展示学员信息
            Util.showPerson(s);
            //由于用户可能输入错误，为了防止用户误操作，所以，如果没有明确的选择y或n，让用户重新选择。
            while (true) {
                //让用户输入选择，是否删除
                System.out.println("【确认】您要删除这条信息么(y/n)");
                String choose = sc.nextLine();
                //判断用户的选择
                if (choose.equals("y")) {
                    stuArray.remove(index);
                    System.out.println("【成功】数据已被删除");
                    break;
                } else if (choose.equals("n")) {
                    System.out.println("【取消】操作被取消");
                    break;
                } else {
                    System.out.println("输入有误，请重新做选择");
                }
            }
        }
    }

    /**
     * 该方法用于修改学员信息
     */
    public static void updataStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学员ID:");
        String sid = sc.nextLine();
        //查找学号在集合中的位置
        int index = Util.findIndex(stuArray, sid);
        //通过查找的结果判断该学号在集合中是否存在
        if (index == -1) {
            System.out.println("【错误】学员ID:" + sid + "没找到");
        } else {
            System.out.println("【查询结果】要修改的学员信息");
            //通过index获取要修改的学员
            Student s = stuArray.get(index);
            //展示要修改的学员的信息
            Util.showPerson(s);
            //录入新的信息
            System.out.println("请输入姓名...");
            String name = sc.nextLine();
            System.out.println("请输入性别...");
            String sex = sc.nextLine();
            System.out.println("请输入生日(格式:2020-12-12)");
            String birthday = sc.nextLine();
            //获取新的年龄
            int age = Util.birthdayToAge(birthday);
            //创建新的学生对象
            Student newStu = new Student(sid, name, birthday, age, sex);
            //替换旧的学员
            stuArray.set(index, newStu);
            //替换信息思路2:直接通过上面的s调用学生对象的set方法，进行修改。自己尝试一下。
            System.out.println("【成功】学员信息修改成功");


        }
    }

    /**
     * 该方法用于添加学员信息
     */
    public static void addStudent() {
        //录入学员信息
        System.out.println("请输入要添加的学员信息");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名...");
        String name = sc.nextLine();
        System.out.println("请输入性别...");
        String sex = sc.nextLine();
        System.out.println("请输入生日(格式:2020-12-12)");
        String birthday = sc.nextLine();
        //获取id
        String sid = Util.sid + "";
        //获取年龄
        int age = Util.birthdayToAge(birthday);
        //创建学生对象
        Student s = new Student(sid, name, birthday, age, sex);
        //添加学生对象
        stuArray.add(s);
        System.out.println("【成功】学员信息添加成功");
        //添加成功以后，递增学号
        Util.sid++;
    }

    /**
     * 该方法用于展示所有的学生
     */
    public static void findAllStudent() {
        //添加测试数据
       /* Student s1 = new Student("0", "张三", "2000-12-12", 22, "男");
        Student s2 = new Student("1", "李四", "2000-12-12", 22, "男");
        stuArray.add(s1);
        stuArray.add(s2);*/
        //判断是否无数据
        if (stuArray.size() == 0) {
            System.out.println("无数据");
            return;
        }
        //展示集合中的学员数据
        System.out.println("【查询结果】");
        Util.showAllStudent(stuArray);
    }

}

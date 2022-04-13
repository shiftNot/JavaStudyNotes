package com.itheima.utils;

import com.itheima.bean.Person;
import com.itheima.bean.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//工具类
public class Util {
    //添加学员要录入的id
    public static int sid = 0;
    //添加学教师要录入的id
    public static int tid = 0;


    /**
     * 该方法用于展示单个学生或老师的信息
     *
     * @param p 接收要进行展示的学生或老师对象
     */
    public static void showPerson(Person p) {
        System.out.println("************************************************");
        System.out.println("编号\t姓名\t性别\t生日\t\t\t年龄\t描述");
        System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getSex() + "\t" + p.getBirthday() + "\t" + p.getAge() + "\t" + p.descrip());
        System.out.println("************************************************");
    }

    /**
     * 该方法用于展示所的学员信息
     *
     * @param array 用于接收存储所有学生对象的集合对象
     */
    public static void showAllStudent(ArrayList<Student> array) {
        System.out.println("************************************************");
        System.out.println("编号\t姓名\t性别\t生日\t\t\t年龄\t描述");
        //展示所有的学员信息
        //遍历集合，获取每一个学员，展示每个学员的信息
        for (int i = 0; i < array.size(); i++) {
            //获取每一个学员
            Student s = array.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getSex() + "\t" + s.getBirthday() + "\t" + s.getAge() + "\t" + s.descrip());
        }
        System.out.println("************************************************");
    }

    /**
     * 该方法用于根据指定的生日的字符串内容获取对应的年龄
     *
     * @param birthday 接收生日的字符串内容
     * @return 返回的是生日对应的年龄
     */
    public static int birthdayToAge(String birthday) {//birthday格式:yyyy-MM-dd
        int age = -1;
        //准备
        //1.根据生日的字符串获取对应的Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //try..catch后面讲。
        Date briDate = null;
        try {
            briDate = sdf.parse(birthday);
        } catch (ParseException p) {
            System.out.println("提供的生日有问题");
        }
        //2.根据对应的Date对象，获取对应的Calendar对象
        Calendar birCal = Calendar.getInstance();
        birCal.setTime(briDate);
        //3.获取当前的Calendar对象
        Calendar nowCal = Calendar.getInstance();
        //计算年龄
        //1.判断当前的时间是在出生日期的后面，才计算年龄
        //if (birCal.before(nowCal)){
        if (nowCal.after(birCal)) {
            //2.计算年龄:当前的年-生日的年
            int birYear = birCal.get(Calendar.YEAR);
            int nowYear = nowCal.get(Calendar.YEAR);
            age = nowYear - birYear;
            /*
                age=当年的年-生日的年
                2.1当前月份如果比生日的月份小，计算后的年龄   age--
                2.2当前月份如果等于生日的月份
                        当前日比生日的日小,计算后的年龄      age--
                        当前日等于生日的日,计算后的年龄    不操作
                        当前日比生日的日大,计算后的年龄    不操作
                2.3当前月份如果比生日的月份大，计算后的年龄    不操作；
            */
            int birMonth = birCal.get(Calendar.MONTH);
            int nowMonth = nowCal.get(Calendar.MONTH);
            int birDay = birCal.get(Calendar.DAY_OF_MONTH);
            int nowDay = nowCal.get(Calendar.DAY_OF_MONTH);
            if ((nowMonth < birMonth) || (nowMonth == birMonth && nowDay < birDay)) {
                age--;
            }
        }
        return age;
    }

    /**
     * 该方法查找指定的学号在集合中的位置
     *
     * @param array 要查找的集合
     * @param sid  要查找的学号
     * @return 返回的是学号在集合中的位置，如果位置不存在，返回-1
     */
    public static int findIndex(ArrayList<Student> array, String sid) {
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            //获取每个学员
            Student s = array.get(i);
            if (s.getId().equals(sid)) {
                index = i;
                break;
            }
        }
        return index;
    }
}


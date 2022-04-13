package com.itheima.demo08_Base64;

import java.util.Base64;

public class Test01_基本型 {
    public static void main(String[] args) {
        //需求：使用Base64基本型编码器和解码器对name=中国?password=123456进行编码和解码
        //注意：编码和解码时要使用同一种类型的编解码器

        //1.获取基本型的编码器
        Base64.Encoder encoder = Base64.getEncoder();

        //2.对数据进行编码
        String msg = "name=中国?password=123456";
        String s = encoder.encodeToString(msg.getBytes());
        System.out.println("编码后：s = " + s);

        //3.获取基本型的解码器
        Base64.Decoder decoder = Base64.getDecoder();

        //4.对编码之后的数据进行解码
        byte[] bytes = decoder.decode(s);
        System.out.println("解码后：bytes = " + new String(bytes));
    }
}

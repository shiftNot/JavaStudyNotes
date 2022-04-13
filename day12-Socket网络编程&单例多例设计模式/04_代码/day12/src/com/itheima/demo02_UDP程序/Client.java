package com.itheima.demo02_UDP程序;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws Exception {
        /*
            需求：客户端向服务器端发送一条消息 ，要求使用UDP协议完成 
            分析：UDP是面向无连接的 发送数据包
            客户端client：         
                1.创建数据包对象DatagramPacket  【指定发给谁，发给哪个程序，发送的数据以及数据的长度】
                    public DatagramPacket(byte buf[], int length,InetAddress address, int port)          
                2.创建发送对象 DatagramSocket    用于构建通道 完成数据包发送   
                    public DatagramSocket()    
                3.使用发送对象发送数据包               send()     
                    public void send(DatagramPacket p)  
                4.关闭通道：close方法


         */

        //1.创建数据包对象DatagramPacket  【指定发给谁，发给哪个程序，发送的数据以及数据的长度】 
        String msg = "大家稍安勿躁 不要急";
        byte[] bytes = msg.getBytes();
        //因为我这里只有一台电脑 所以就使用本地电脑构建客户端和服务器端 大家在宿舍的可以相互之间发送消息
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 7777);

        //2.创建发送对象 DatagramSocket    用于构建通道 完成数据包发送 
        DatagramSocket datagramSocket = new DatagramSocket();//如果你不指定端口号 系统会自动指定

        //3.使用发送对象发送数据包         send()   
        datagramSocket.send(datagramPacket);

        //4.关闭通道：close方法
        datagramSocket.close();

    }
}

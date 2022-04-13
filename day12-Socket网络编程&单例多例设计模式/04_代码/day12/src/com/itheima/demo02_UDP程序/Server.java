package com.itheima.demo02_UDP程序;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        /*
            服务器端server：         
                1.创建数据包对象DatagramPacket  【设置要接收的数据及长度】 
                   public DatagramPacket(byte buf[], int length);
                2.创建接收对象 DatagramSocket    用于构建通道 完成数据包接收 
                    public DatagramSocket(int port)       
                3.使用接收对象接收数据包              receive()         
                    public synchronized void receive(DatagramPacket p)
                4.关闭通道：close方法
            注意：先启动服务端 再启动客户端
         */
        //1.创建数据包对象DatagramPacket  【设置要接收的数据及长度】 
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        //2.创建接收对象 DatagramSocket 需要指定端口号    用于构建通道 完成数据包接收         
        DatagramSocket datagramSocket = new DatagramSocket(7777);

        //3.使用接收对象接收数据包              receive()         
        datagramSocket.receive(datagramPacket);

        //4.关闭通道：close方法  打印接收到的数据
        datagramSocket.close();

        System.out.println("接收到的数据："+new String(bytes, 0, datagramPacket.getLength()));


    }
}

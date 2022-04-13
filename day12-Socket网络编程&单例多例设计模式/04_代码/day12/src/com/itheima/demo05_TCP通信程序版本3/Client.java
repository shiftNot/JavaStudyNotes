package com.itheima.demo05_TCP通信程序版本3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        /*

           客户端程序：
                1.创建客户端程序Socket对象  指定服务器主机地址及程序端口号
                2.使用getOutPutStream得到字节输出流对象 向服务器端发送数据
                3.使用getInputStream得到字节输入流对象  从服务器端接收数据
                4.关闭通道
           注意：
                1.先启动服务器端程序，再启动客户端程序。
         */
        //1.创建客户端程序Socket对象  指定服务器主机地址及程序端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        Scanner sc = new Scanner(System.in);

        while (true) {
            //2.使用getOutPutStream得到字节输出流对象 向服务器端发送数据
            OutputStream os = socket.getOutputStream();
            System.out.println("请输入一个字符串：");
            String msg = sc.nextLine();
            os.write(msg.getBytes());

            //*3.使用getInputStream得到字节输入流对象  从服务器端接收数据
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println("客户端接收到服务器端的数据："+new String(bytes,0,len));

            //4.关闭通道  如果关闭os对象则socket对象也会随着关闭  关闭socket对象，os对应也会一起关闭
            //os.close();
            //socket.close();
        }

    }
}

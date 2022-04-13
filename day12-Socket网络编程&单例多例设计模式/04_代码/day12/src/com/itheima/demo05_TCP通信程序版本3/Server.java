package com.itheima.demo05_TCP通信程序版本3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        /*
             服务器端程序：
                1.创建服务器端程序ServerSocket  指定端口号
                2.等待客户端连接 调用accept()方法 得到客户端对象Socket
                3.使用getInputStream得到字节输入流对象 获取客户端发送过来的数据
                *4.使用getOutputStream得到字节输出流对象 向客户端发送数据
                5.关闭通道  打印接收到的数据
         */
        //1.创建服务器端程序ServerSocket  指定端口号
        ServerSocket serverSocket = new ServerSocket(8888);

        //2.等待客户端连接 调用accept()方法 得到客户端对象Socket
        Socket socket = serverSocket.accept();  //阻塞 如果没有客户端连接 就会一直停在这里

        Scanner sc = new Scanner(System.in);

        //接收到客户端请求 一致循环对话
        while (true) {
            //3.使用getInputStream得到字节输入流对象 获取客户端发送过来的数据
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println("服务器端接收到客户端的数据："+new String(bytes,0,len));

            //*4.使用getOutputStream得到字节输出流对象 向客户端发送数据
            OutputStream os = socket.getOutputStream();


            System.out.println("请输入一个字符串：");
            String msg = sc.nextLine();
            os.write(msg.getBytes());

            //5.关闭通道  打印接收到的数据   服务器一般不关
            //socket.close();
        }
    }
}

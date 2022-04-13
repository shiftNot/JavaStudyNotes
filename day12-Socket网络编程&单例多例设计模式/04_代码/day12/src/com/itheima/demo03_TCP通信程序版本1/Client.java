package com.itheima.demo03_TCP通信程序版本1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        /*

           客户端程序：
                1.创建客户端程序Socket对象  指定服务器主机地址及程序端口号
                2.使用getOutPutStream得到字节输出流对象 向服务器端发送数据
                3.关闭通道
           注意：
                1.先启动服务器端程序，再启动客户端程序。
         */
        //1.创建客户端程序Socket对象  指定服务器主机地址及程序端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //System.out.println("client-socket = " + socket);

        //2.使用getOutPutStream得到字节输出流对象 向服务器端发送数据
        OutputStream os = socket.getOutputStream();
        os.write("服务器：今晚约吗？".getBytes());

        //3.关闭通道  如果关闭os对象则socket对象也会随着关闭  关闭socket对象，os对应也会一起关闭
        //os.close();
        socket.close();

    }
}

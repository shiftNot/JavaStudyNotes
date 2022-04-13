package com.itheima.demo06_TCP文件上传版本一;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        /*
            服务器端：
                1.接收客户端上传的文件
                2.将文件保存到服务器硬盘上

            优化：
                1.文件名写死 会导致后上传的文件覆盖前面上传文件  解决：文件名随机生成不要重复即可
         */
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(9999);

        //2.获取客户端连接 得到Socket对象
        Socket socket = serverSocket.accept();

        //3.通过socket对象获取字节输入流对象 接收客户端发送过来的数据
        InputStream is = socket.getInputStream();

        //4.创建字节输出流对象 关联上传的文件保存在服务器的硬盘地址
        FileOutputStream fos = new FileOutputStream("day12\\bb\\mlCopy2.jpg");

        System.out.println("server：服务器端开始接收上传的文件");

        //5.循环读写 将上传的文件保存在服务器的硬盘上
        byte[] bytes = new byte[8192];
        int len;
        while((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        System.out.println("server：服务器端开始接收上传的文件成功");

        //*6.通过socket对象获取字节输出流对象 回复数据给客户端*
        OutputStream os = socket.getOutputStream();

        System.out.println("server：服务器端回复客户端文件上传成功");

        os.write("文件上传完毕！".getBytes());

        //6.关闭流 释放资源
        fos.close();
        socket.close();

    }
}

package com.itheima.demo07_TCP文件上传版本二;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws Exception {
        /*
            服务器端：
                1.接收客户端上传的文件
                2.将文件保存到服务器硬盘上

            优化：
                1.文件名写死 会导致后上传的文件覆盖前面上传文件  解决：文件名随机生成不要重复即可
                    解决方式：重命名文件 1.使用时间戳  2.使用UUID【随机的36位字符串】
                2.每上传一次文件 就需要启动一次服务端  我们希望可以一直接收任意客户端上传文件  使用循环优化
                3.现在的优化代码是一个单线程的  如果有一个用户已经在上传文件了 其他用户就需要等待着  不能多个用户同时上传文件
                    解决：使用多线程
         */
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(9999);


        while (true) {
            //2.获取客户端连接 得到Socket对象
            Socket socket = serverSocket.accept();

            //使用多线程 允许多个客户端同时上传文件
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        //3.通过socket对象获取字节输入流对象 接收客户端发送过来的数据
                        InputStream is = socket.getInputStream();

                        //4.创建字节输出流对象 关联上传的文件保存在服务器的硬盘地址
                        //FileOutputStream fos = new FileOutputStream("day12\\bb\\"+System.currentTimeMillis()+".jpg");
                        FileOutputStream fos = new FileOutputStream("day12\\bb\\"+ UUID.randomUUID().toString()+".jpg");

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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}

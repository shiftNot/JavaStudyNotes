package com.itheima.demo07_TCP文件上传版本二;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception {
        /*
            客户端：
                1.将要上传的文件从硬盘读取到内存中
                2.使用TCP程序将文件发送到服务器端
         */
        //1.创建Socket对象
        Socket socket = new Socket("127.0.0.1", Integer.parseInt("9999"));

        //2.创建字节输入流对象 关联上传文件路径
        FileInputStream fis = new FileInputStream("day12\\aa\\mm.jpg");

        //3.通过socket对象 获取字节输出流 将上传的文件数据发送给服务器端
        OutputStream os = socket.getOutputStream();

        System.out.println("client：客户端开始上传文件");

        //4.循环读写数据 实现发送
        byte[] bytes = new byte[8192];
        int len;
        while((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }

        //问题：客户端上传文件完成，但是服务器还一直在等待着接收数据
        //原因：服务器端不知道用户是否还要继续发送内容 所以服务器就一直在等待着 接收新的数据 停留在while循环读数据那里了
        //解决：告诉服务器我文件已经上传完毕了 不再进行数据写入了   socket.shutdownOutput();禁止输入
        System.out.println("client：客户端上传文件完毕");
        //禁止输入
        socket.shutdownOutput();

        //*文件上传成功之后 接收服务器端给的回复数据*


        //5.使用socket对象获取字节输入流对象 接收服务器端的回复数据
        InputStream is = socket.getInputStream();

        System.out.println("client：客户端接收服务器端回复数据");

        //byte[] bytes01 = new byte[8192];  //可以不用再创建一个新的字节数组了 直接使用之前已经创建好的就可以了 之前的字节数组是用于写数据的 写完数据就没有存在的必要了
        //写完数据之后  依然可以使用这个字节数组去进行接收数据
        int len2 = is.read(bytes);
        System.out.println(new String(bytes,0,len2));

        //5.关闭流 释放资源
        fis.close();
        socket.close();
    }
}

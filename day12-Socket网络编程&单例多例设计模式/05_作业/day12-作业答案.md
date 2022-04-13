# 一  编程题【TCP通信】

## 1.1 题目一

> 1. 请定义TCP的客户端，向服务器端发送一条信息：你好，我是客户端小白。
> 2. 请定义TCP的服务器端，接收这条信息，并打印到控制台



参考答案

服务端

```java
public class Server {

    public static void main(String[] args) throws Exception {
        //创建ServerSocket，监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端启动成功，正在等待客户端连接...");
        while (true) { //这个循环可加可不加，只要能收到客户端的消息即可。
            //等待连接
            Socket socket = serverSocket.accept();

            //获得输入流
            InputStream is = socket.getInputStream();

            //将字节输入流转换成字符输入流，这里只是为了方便读取一行数据，不转换也是可以的
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //读取一行数据
            String message = br.readLine();

            //打印消息
            System.out.println("接收到来自客户端的消息：" + message);

            //释放资源
            is.close();
            socket.close();
        }
    }
}
```

客户端

```java
public class Client {

    public static void main(String[] args) throws Exception {
        //创建Socket，连接本机的8888端口（也就是服务端）
        Socket socket = new Socket("127.0.0.1", 8888);

        //获取输出流
        OutputStream os = socket.getOutputStream();

        //发送消息
        os.write("你好，我是客户端小白。".getBytes());

        //释放资源
        os.close();
        socket.close();

        System.out.println("客户端消息发送成功");
    }
}
```





## 1.2 题目一

> 请编写客户端向服务器端上传的案例，要求上传完毕，服务器端要向客户端发送一条反馈信息，客户端收到反馈后打印到控制台，两端结束。

服务端

```java
public class Server {

    public static void main(String[] args) throws Exception {
        //创建ServerSocket，监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端启动成功，正在等待客户端连接...");
        while (true) {
            //等待连接
            Socket socket = serverSocket.accept();

            //获得输入流
            InputStream is = socket.getInputStream();

            //创建输出流（作用是保存文件）
            OutputStream outputStream = new FileOutputStream("day18/files/" + System.currentTimeMillis() + ".jpg");
            byte[] buf = new byte[1024];
            int len;
            //循环读写文件
            while ((len = is.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }

            //通知客户端文件上传完毕
            OutputStream os = socket.getOutputStream();
            os.write("上传成功".getBytes());

            //释放资源
            os.close();
            outputStream.close();
            is.close();
            socket.close();

            System.out.println("接收到一个文件");
        }
    }
}
```

客户端

```java
public class Client {

    public static void main(String[] args) throws Exception {
        //创建Socket，连接本机的8888端口（也就是服务端）
        Socket socket = new Socket("127.0.0.1", 8888);

        //获取输出流
        OutputStream os = socket.getOutputStream();

        //创建输入流，读取文件
        InputStream is = new FileInputStream("day18/files/1.jpg");

        //发送图片文件
        byte[] buf = new byte[1024 * 8];
        int len;
        while ((len = is.read(buf)) != -1) {
            os.write(buf, 0, len);
        }

        //文件发送完毕后要关闭输出流，通知服务端
        socket.shutdownOutput();

        //接收服务端的回写数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String message = br.readLine();
        System.out.println(message);

        //释放资源 & 断开连接
        os.close();
        socket.close();
    }
}
```





## 1.3 题目一

> 请编写模拟B/S服务器案例。

服务端

```java
public class Server {

    /**
     *  服务器
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1. 创建 ServerSocket 并绑定端口 8888
        ServerSocket serverSocket = new ServerSocket(8888);

        //2. 循环接收客户端发送的请求，并返回 Socket 对象
        while (true) {
            Socket socket = serverSocket.accept();

            /**
             * GET /day12/web/index.html HTTP/1.1
             * Host: 127.0.0.1:9999
             * Connection: keep-alive
             * Upgrade-Insecure-Requests: 1
             * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36
             * Sec-Fetch-Dest: document
             * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,;
             */
            //3. 从客户端发送的数据中提取要访问的资源
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
            String resource = line.split(" ")[1].substring(1);
            System.out.println("客户端请求的资源名称：" + resource);

            //从 Socket 中获得输出流
            OutputStream os = socket.getOutputStream();
            os.write("HTTP/1.1 200 OK\r\n".getBytes());
            os.write("Content-Type:text/html\r\n".getBytes());
            os.write("\r\n".getBytes());

            //4. 根据获取的资源名称，从本地磁盘中读取并响应给客户端
            InputStream localIs = new FileInputStream(resource);
            byte[] buffer = new byte[1024 * 8];
            int len;
            while ((len = localIs.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            //5. 释放资源
            localIs.close();
            os.close();
            is.close();
            socket.close();
        }
    }
}
```


package com.itheima.demo01_InetAddress类;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
    public static void main(String[] args) throws Exception {
        /*
        InetAddress类,此类表示Internet协议（IP）地址。
        获取InetAddress对象
            static InetAddress getLocalHost() ；获得本地主机IP地址对象
            static InetAddress getByName(String host)；根据主机名获得对应的IP地址对象
        常用方法
            String getHostName()；根据InetAddress对象获得主机名
            String getHostAddress()；根据InetAddress对象获得IP地址字符串

         扩展：
            //static InetAddress getByAddress(byte[] addr) ：在给定原始 IP 地址的情况下，返回 InetAddress 对象。
            //InetAddress.getAllByName("www.baidu.com");
         */

        //1.获取本机ip地址对象
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("ip1 = " + ip1);
        InetAddress ip2 = InetAddress.getByName("LAPTOP-2A92AUT7");
        System.out.println("ip2 = " + ip2);

        //2.使用ip地址对象 获取到对应的主机名和ip地址字符串
        String hostName = ip1.getHostName();
        System.out.println("hostName = " + hostName);
        String hostAddress = ip1.getHostAddress();
        System.out.println("hostAddress = " + hostAddress);

        //延伸：想获取百度服务器的ip地址对象  【获取对方的ip地址对象】

        /*byte[] bytes = {(byte) 163, (byte) 177, (byte) 151,(byte)110};
        InetAddress byAddress = InetAddress.getByAddress(bytes);
        System.out.println("byAddress = " + byAddress);*/

        String baiduIpStr = "163.177.151.110";
        String[] ips = baiduIpStr.split("\\.");
        byte[] ipss = new byte[4];
        for (int i=0;i<4;i++) {
            ipss[i] = (byte)(Integer.parseInt(ips[i]));
        }
        InetAddress baiduIp = InetAddress.getByAddress(ipss);
        System.out.println("baiduIp = " + baiduIp);


        InetAddress[] addrs = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress addr : addrs) {
            System.out.println("addr = " + addr);
        }

    }

}

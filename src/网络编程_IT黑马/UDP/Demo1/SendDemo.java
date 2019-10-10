package 网络编程_IT黑马.UDP.Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 9:46
 * @Description：  UDP的发送  套接字编程  发送和接收都是由套接字 Socket来完成的。
 *
 *      UDP 是不可靠的协议，即使没有接收端，也可以照发。
 *
 *
 * DatagramSocket 此类表示用于发送和接收数据报数据包的套接字。
     *  DatagramSocket()
     * 构造数据报套接字并将其绑定到本地主机上的任何可用端口。随机分配端口号。
     * * DatagramSocket(int port)
     * 构造数据报套接字并将其绑定到本地主机上的指定端口。
 *
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {

        /** 2019/10/7 14:41
         * 创建 发送端Socket对象，构造没有参数，所以随机指定Ip地址。，
         * 根据数据包内的ip来正确发送。
         *  由此可见UDP是不可靠的。
        */
        DatagramSocket ds=new DatagramSocket();

        String s="Helo Udp,Im coming!!";
        byte[] bytes=s.getBytes();
        int len=bytes.length;
        InetAddress address = InetAddress.getByName("ZhangHao-PC");//发送给这个设备
        int port=8888;

//        打包 * DatagramPacket 表示数据包。
        DatagramPacket dp=new DatagramPacket(bytes,len,address,port);

        /**
         * 发送端发完就行了。
        */
        ds.send(dp);

        ds.close();






    }

}

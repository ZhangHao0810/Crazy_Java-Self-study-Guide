package 网络编程_IT黑马.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 10:26
 * @Description： 接收Socket对象，
 * 接收数据
 * 解析数据
 * 输出数据
 * 释放资源
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);
        /**
         * DatagramPacket(byte[] buf, int length) 构造一个 DatagramPacket用于接收length长度的数据包
         */
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);//用于接收的packet 无需ip
        System.out.println("开始接收数据了，datagramSocket.receive()发生阻塞，等待发送端发送。");
        ds.receive(dp);//阻塞

        /**
         * InetAddress getAddress() 解析数据。可以获得数据包的一些属性，如主机姓名 地址 数据等等
         *  getData()
         *  getHostAddress()
         */
        InetAddress address = dp.getAddress();
        byte[] data = dp.getData();
        int lenth = dp.getLength();

        System.out.println("sender:---->" + address.getHostAddress());
        System.out.println(new String(data, 0, lenth));

        /**
         * 因为接收过来的就是字节数组，所以也可以直接用bytes来操作。
         */
        System.out.println("sender:---->" + address.getHostAddress());
        System.out.println(new String(bytes, 0, lenth));//也可以直接用传进来的字节数组。

        ds.close();

    }
}


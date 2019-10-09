package 网络编程_IT黑马.UDP;

import java.io.IOException;
import java.net.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 11:26
 * @Description： 升级的Send，使用了匿名类，更高效了。 升级幅度不大。
 *
 *      主机号错了可能发生异常java.net.UnknownHostException
 *          但是端口号错了，不会发生异常，但是收不到。
 *              端口号不可重复，不能被占用。java.net.BindException: Address already in use: Cannot bind
 */
public class SendDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();

        /** 2019/10/7 14:47
         * UDP 通过DatagramPacket 数据包来完成传输。
        */
        byte[] bytes="Hello UDP, Im update Send!!".getBytes();
        DatagramPacket dp=new DatagramPacket(bytes, bytes.length,InetAddress.getByName("ZhangHao-PC"),9999);

        ds.send(dp);
        ds.close();

    }
}

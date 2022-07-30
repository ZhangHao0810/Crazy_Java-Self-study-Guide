package 网络编程.UDP.Demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 11:30
 * @Description： 升级版的Receive  升级幅度不大。
 */
public class ReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(9999);

        byte[] bytes=new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length);

        ds.receive(dp);
//      收到数据要解析！！！
        InetAddress address=dp.getAddress();
        byte[] data = dp.getData();
        int length = dp.getLength();
        System.out.println("sender==>"+ address.getHostAddress());
        System.out.println(new String(data,0,length));

        ds.close();
    }

}

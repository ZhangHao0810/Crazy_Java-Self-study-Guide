package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 8:40
 * @Description：  IP地址类的 使用。
 *
 *  IP 地址是惟一的，而主机名可能重复。
 *
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address=InetAddress.getByName("ZhangHao-PC");//ZhangHao-PC/10.3.141.186
        InetAddress address=InetAddress.getByName("10.3.141.186");///10.3.141.186  ipconfig
        System.out.println(address);

        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();

        System.out.println(hostAddress);
        System.out.println(hostName);
    }
}

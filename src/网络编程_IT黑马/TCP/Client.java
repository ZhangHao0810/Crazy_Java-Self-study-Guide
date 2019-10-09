package 网络编程_IT黑马.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 14:38
 * @Description：  客户端（发送端） 。使用TCP协议传输  TCP是可靠传输
 *
 *      创建发送端Socket对象，（创建连接）
 *      获取输出流对象。
 *      发送数据
 *      释放资源
 *
 *         TCP是可靠的，需要客户端（发送端）和服务端（接收端）建立连接。
 *                      未连接会抛出java.net.ConnectException: Connection refused: connect
 */
public class Client {
    public static void main(String[] args) throws IOException {
        /** 2019/10/7 14:43
         * public class Socket  该类实现 客户端 套接字（也称为“套接字”）。
         *        Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号。
        */
        Socket s=new Socket(InetAddress.getByName("ZhangHao-PC"),10086);

        /** 2019/10/7 14:47
         *  通过创建字IO流来进行TCP的输入输出。而非UDP的 数据包。
         *  outputStream.write(str.getBytes()); 随着流的write 数据就发送完了
         *
        */
        OutputStream outputStream = s.getOutputStream();
        String str = "Hello TCP,Im coming!!!";
        outputStream.write(str.getBytes());

//        outputStream.close();//Socket会帮助我关闭IO流，无需自己关闭。
        s.close();
    }
}

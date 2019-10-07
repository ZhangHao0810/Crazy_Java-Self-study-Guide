package 网络编程.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 14:51
 * @Description： TCP 服务端（接收端）的程序
 *
 *      创建接收端Socket对象
 *      监听（阻塞）
 *      获取输入流对象。
 *      获取数据
 *      输出数据
 *      释放资源
 *
 *      public class ServerSocket
 *          *      这个类实现了服务器套接字。 服务器套接字等待通过网络进入的请求。
 */
public class Server {
    public static void main(String[] args) throws IOException {
        /** 2019/10/7 14:54
         * ServerSocket(int port)
         *      创建绑定到指定端口的服务器套接字。
        */
        ServerSocket ss = new ServerSocket(10086);

        /** 2019/10/7 14:56
         * ServerSocket 没有获取IO流的方法，所以还是要用Socket来完成。
         *      accept()返回的也是 Socket类型。
        */
        Socket s=ss.accept();//阻塞，等待接收一次数据

        /** 2019/10/7 15:07
         * //      解析数据。得到InetAddress对象。但是想获得数据还是要用 IO流来操作。
        */
        InetAddress inetAddress = s.getInetAddress();
        System.out.println("client===>"+inetAddress.getHostName());
//        System.out.println(inetAddress.);

        /** 2019/10/7 15:07
         *  获得流。进行输出。
         */
        InputStream inputStream = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len ;
        len=inputStream.read(bytes);
        System.out.println(new String (bytes,0,len));

        s.close(); //关闭Socket
//        ss.close(); 服务器端不关,持续等待接收。

    }
}

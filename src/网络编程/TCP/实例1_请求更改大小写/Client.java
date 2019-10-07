package 网络编程.TCP.实例1_请求更改大小写;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 15:12
 * @Description： 客户端，发送数据，并且收到来自服务端返回的数据。
 */
public class Client {
    public static void main(String[] args) throws IOException {
        /** 2019/10/7 15:33
         * 创建套接字对象，连接服务端。
        */
        Socket s=new Socket(InetAddress.getByName("ZhangHao-PC"),7777);
        /** 2019/10/7 15:29
         * 用套接字创建输出流，利用输出流向服务端写数据
        */
        OutputStream os=s.getOutputStream();
        os.write("tcp,i am coming o hahaha!".getBytes());

        /** 2019/10/7 15:29
         * 获取服务器端返回的输入流对象。
        */
        InputStream is=s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        os.close();
        s.close();

    }
}

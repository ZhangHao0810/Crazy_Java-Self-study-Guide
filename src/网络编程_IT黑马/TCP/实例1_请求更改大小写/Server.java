package 网络编程_IT黑马.TCP.实例1_请求更改大小写;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 15:13
 * @Description： 服务端，接收客户端发来的数据，并返回结果给客户端。
 */
public class Server {
    public static void main(String[] args) throws IOException {
        /** 2019/10/7 15:33
         * 建立服务器端对象和套接字对象。进行监听。
        */
        ServerSocket ss=new ServerSocket(7777);
        Socket socket = ss.accept();

        /** 2019/10/7 15:31
         * 获取从客户端来的输入流对象，
         *      能看出来，socket就是连接客户端和服务器端的桥梁。
        */
        InputStream inputStream = socket.getInputStream();

        /** 2019/10/7 15:32
         * 读取输入流中的信息。
        */
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String str = new String(bytes, 0, read);
        System.out.println(str);

        /** 2019/10/7 15:31
         * 完成功能
        */
        String upperCase = str.toUpperCase();
        /** 2019/10/7 15:30
         * 利用输出流向客户端返回数据
        */
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(upperCase.getBytes());

        /** 2019/10/7 15:32
         * 释放资源。
        */
        socket.close();
//        ss.close();

    }

}

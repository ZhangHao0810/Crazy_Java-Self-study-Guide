package 网络编程_IT黑马.TCP.实例2_模拟用户登录;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 15:39
 * @Description： 客户端 用于用户登录
 *                      输入姓名和密码，传给服务区，
 *                          接收服务器返回的内容。
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        Socket socket=new Socket(InetAddress.getByName("ZhangHao-PC"),8888);
        /** 2019/10/7 15:42
         *  用新的Socket构造方法。 直接传入字符串，可以自动得到InetAddress对象
        */
        Socket socket = new Socket("ZhangHao-PC", 8888);

        /** 2019/10/7 15:44
         * 从键盘输入：
         * 利用高效的包装流 BufferedReader来进行 姓名和密码的 键盘输入。选择不用 Scanner类。
         *   system.in  是 InputSteam 字节输入流。从键盘读入数据
         *      BufferedReader接收的基本流不是字节输入流，需要用转换流换成字节流。
        */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String userName = br.readLine();
        System.out.println("请输入密码：");
        String passWord = br.readLine();

        /** 2019/10/7 15:50
         * 向服务器写数据。所有走网络的，都要经Socket来操作。
         *  1.可以利用高效输出流 BufferedWriter 但是需要转换
         *      BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         *  2.利用打印流。直接传，并且第二个参数为true，保证输出是按照行。
         *      好处是编写更高效，而且服务器也直接读两行即可，无需再读字节数组了。
        */
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(userName);
        out.println(passWord);

        /** 2019/10/7 16:32
         * 获取服务器返回的数据，获取输入流对象。
         *  虽然服务器是用打印流返回的数据，但是数据在网络上总归是用二进制来进行传输的，所以还是用socket.getInputStream()来接收
         *
         *  采用循环读出输入流的内容。也可以不用循环，因为服务器就写了一行。
         *
        */
        BufferedReader sbr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result;
        while ((result = sbr.readLine()) != null) {
            System.out.println(result);
        }


        /** 2019/10/7 17:06
         * 释放资源
        */
        socket.close();


    }
}

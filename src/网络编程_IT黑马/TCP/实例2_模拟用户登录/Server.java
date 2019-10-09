package 网络编程_IT黑马.TCP.实例2_模拟用户登录;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 15:56
 * @Description： 服务器端，收到客户端信息，判断并返回
 */
public class Server {
    public static void main(String[] args) throws IOException {
        /** 2019/10/7 15:59
         * 创建服务器端 Socket，开始监听
        */
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket=serverSocket.accept();

        /** 2019/10/7 15:59
         * 获取输入流对象，获取用户名和密码
         *      利用 包装流 BufferedReader
        */
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String userName = br.readLine();
        String passWord = br.readLine();

        /** 2019/10/7 16:03
         *  执行判断功能。
        */
        boolean flag=false;
/*
        if ("ZhangHao".equals(userName) && "123456".equals(passWord)) {
            flag=true;
        }
*/
        List<User> users = UserDB.getUsers();
        User user = new User(userName, passWord);
        if (users.contains(user)) { //注意，ArrayList 的contains 底层调用了 equals方法。所以User要重写这个方法！！
            flag=true;
        }

        /** 2019/10/7 16:23
         * 获取输出流对象，利用socket进行输出，将结果返回给客户端
        */
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        if (flag) {
            pw.println("登录成功！！");
        }
        else{
            pw.println("登录失败");
        }

        /** 2019/10/7 16:30
         * 释放资源
        */
        socket.close();
//        serverSocket.close();



    }
}

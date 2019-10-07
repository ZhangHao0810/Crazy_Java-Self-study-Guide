package 网络编程.TCP.实例2_模拟用户登录;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 18:41
 * @Description： 用来存储用户对象的类。模拟数据库 对外开放读数据的方法。
 */
public class UserDB {
    private static List<User> users =new ArrayList<>();

    static {
        users.add(new User("Zhangsan", "123123"));
        users.add(new User("Lisi", "123123"));
        users.add(new User("wangwu", "123123"));
        users.add(new User("admin", "123456"));

    }

    public static List<User> getUsers(){
        return users;
    }
}

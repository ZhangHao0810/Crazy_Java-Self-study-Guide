package 注解_渡一教育.ATM机器;

import 注解_渡一教育.利用注解和反射实现_IOC.MySpring2;

/**
 * @author ZhangHao
 * @date 2019/10/10 19:54
 * @Description： ATM机器的测试类
 */
public class TestMain {
    public static void main(String[] args) {

        MySpring2 ms=new MySpring2();
        User user = (User) ms.getBean("注解.ATM机器.User");
        System.out.println("自动创建的User账户！！！");
        System.out.println(user);
    }
}

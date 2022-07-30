package 注解.ATM机器;

import 注解.利用注解和反射实现_IOC.MyAnnotation;

/**
 * @author ZhangHao
 * @date 2019/10/10 19:42
 * @Description： Atm系统，用户账户
 */
public class User {

    private  String username;
    private  String password;
    private Float balance;

    @MyAnnotation({"ZhangHao","123456","6955552.5"})
    public User() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}

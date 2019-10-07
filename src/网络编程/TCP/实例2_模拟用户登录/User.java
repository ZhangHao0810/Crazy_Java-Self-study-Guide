package 网络编程.TCP.实例2_模拟用户登录;

import java.util.Objects;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/7 17:17
 * @Description： 原先模拟用户登录的改进，设施用户类，更加的面向对象
 */
public class User {
    private  String userName;
    private  String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(passWord, user.passWord);
    }

}

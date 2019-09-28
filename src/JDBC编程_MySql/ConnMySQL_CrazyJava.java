package JDBC编程_MySql;

import java.sql.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 16:45
 * @Description： 连接和执行数据库操作。
 */
public class ConnMySQL_CrazyJava {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");//注册JDBC驱动的语句，在JDBC4之后可以省略。但是加上最保险。

        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","0206");

            Statement stmt=conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select *from stu");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+" "
                        + resultSet.getString("name")+" "
                        +resultSet.getDouble("score")+"");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

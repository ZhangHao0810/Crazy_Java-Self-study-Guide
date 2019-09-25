package MySQL数据库和JDBC编程;

import java.sql.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 16:45
 * @Description： 连接和执行数据库操作。
 */
public class ConnMySQL_CrazyJava {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

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

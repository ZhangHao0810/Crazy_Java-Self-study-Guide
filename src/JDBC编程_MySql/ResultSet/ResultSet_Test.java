package JDBC编程_MySql.ResultSet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/26 16:33
 * @Description： 演示使用 可更新，可滚动的结果集。
 *
 * 可以通过改变结果集来影响数据库内的数据。
 */
public class ResultSet_Test {
    private String driver;
    private String url;
    private String user;
    private String password;

    public void initParam(String paramFile) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));

        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        password = props.getProperty("password");

    }

    public void query(String sql) throws Exception {
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
//                创建PreparedStatement对象的时候，传入控制结果集可滚动，可更新的参数。
                PreparedStatement pstmt = conn.prepareCall(sql
                        , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = pstmt.executeQuery()
        ) {
            rs.last();
            int rowCount = rs.getRow();
            for (int i = rowCount; i > 0; i--) {
                rs.absolute(i);
                System.out.println(rs.getString(1)+" "
                +rs.getString(2)+" "+rs.getString(3));
//                修改记录指针所指记录第2列的值。
                rs.updateString(2,"学生名"+i);
//                提交修改。
                rs.updateRow();
            }
        }
    }

    public static void main(String[] args) throws  Exception {
        ResultSet_Test rt=new ResultSet_Test();
        rt.initParam("mysql.ini");
        rt.query("select * from stu");

    }

}

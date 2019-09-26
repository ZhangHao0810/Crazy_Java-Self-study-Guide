package MySQL数据库和JDBC编程.Execute;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 22:40
 * @Description： 执行DML语句 返回记录条数。
 */
public class ExecuteDML {
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

    public int insertData(String sql) throws Exception {
        Class.forName(driver);

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
        ) {
            return stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        ExecuteDML ed = new ExecuteDML();
        ed.initParam("mysql.ini");
        int data = ed.insertData("insert into jdbc_test"
                + " select *  from stu ");
        System.out.println("--系统中有" + data + "条记录受影响");

    }

}

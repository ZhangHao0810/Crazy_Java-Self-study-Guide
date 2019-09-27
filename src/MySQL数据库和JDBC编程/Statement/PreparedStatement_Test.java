package MySQL数据库和JDBC编程.Statement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/26 15:32
 * @Description：
 * 使用 更高效，更安全，更易复用的 PreparedStatement 来代替 Statement
 *
 */
public class PreparedStatement_Test {
    private String driver;
    private String url;
    private String user;
    private String password;

    public void initParam(String paramFile) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));

        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        password = props.getProperty("password");
        Class.forName(driver);
    }

    /**
     * @author Zhanghao
     * @date 2019/9/27 8:55
     *
     * @param
     * @return void
     * @Description: 用Statement来操作  用来做对照。
    */
    public void insertUseStatement() throws Exception{
        long start = System.currentTimeMillis();
        try(
                Connection conn=DriverManager.getConnection(url,user,password);
                Statement stmt=conn.createStatement()
        ){
            for (int i =0;i<100;i++){
                stmt.executeUpdate("insert into stu values ( null,'姓名"+i+" ',1)");
            }
            System.out.println("使用Statement耗时："+(System.currentTimeMillis()-start));
        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/26 16:03
     *
     * @param
     * @return void
     * @Description:  无需拼接字符串，可以用 占位符？   保证了正确！！
    */
    public void insertUsePrepare() throws Exception{
        long start = System.currentTimeMillis();
        try(
                Connection conn=DriverManager.getConnection(url,user,password);
                PreparedStatement pstmt=conn.prepareStatement("insert into stu value (null,?,1)")
                ){
            for (int i =0;i<100;i++){
                pstmt.setString(1,"姓名"+i);
                pstmt.executeUpdate();
            }
            System.out.println("使用PreparedStatement耗时："+(System.currentTimeMillis()-start));
        }
    }

    public static void main(String[] args) throws  Exception{
        PreparedStatement_Test pt = new PreparedStatement_Test();
        pt.initParam("mysql.ini");
        pt.insertUseStatement();
        pt.insertUsePrepare();
    }
}

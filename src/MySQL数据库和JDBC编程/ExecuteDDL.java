package MySQL数据库和JDBC编程;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 16:58
 * @Description：
 *
 * 用java8 新增的executeUpdate方法执行DDL和DML
 *  可以在ini配置文件中 保存数据库链接信息。这样无需修改源代码即可变更数据库。
 */
public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String password;

    public void setProperty() throws Exception {
        Properties props = new Properties();
//添加属性
        props.setProperty("driver","com.mysql.jdbc.Driver");
        props.setProperty("url","jdbc:mysql://localhost/test");
        props.setProperty("user","root");
        props.setProperty("password","0206");
//保存文件
        props.store(new FileOutputStream("mysql.ini"),"comment line");
    }

    public void initParam(String paramFile) throws IOException {
        Properties props= new Properties();
        props.load(new FileInputStream(paramFile));
        driver=props.getProperty("driver");
        url=props.getProperty("url");
        user=props.getProperty("user");
        password=props.getProperty("password");

    }

    public void createTable(String sql) throws Exception {
        Class.forName(driver);

        try( Connection conn= DriverManager.getConnection(url,user,password);
             Statement stmt=conn.createStatement())
        {
         stmt.executeUpdate(sql); //执行DDL返回0
        }
    }

    public static void main(String[] args) throws Exception {


        ExecuteDDL ed=new ExecuteDDL();
        ed.setProperty();

        ed.initParam("mysql.ini");
        ed.createTable(
                "create table jdbc_test "+
                        "(jdbc_id int auto_increment primary key,"+
                        "jdbc_name varchar(225),"+
                        "jdbc_desc text);"
        );

        System.out.println("---------建表成功------");
    }


}

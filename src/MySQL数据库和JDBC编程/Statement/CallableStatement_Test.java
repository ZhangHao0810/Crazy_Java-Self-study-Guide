package MySQL数据库和JDBC编程.Statement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/26 16:08
 * @Description： 演示JDBC调用存储过程。  暂时读不太懂。需要日后学习存储过程相关的知识点。
 * 学完MySQL要回过头来看这个。
 */
public class CallableStatement_Test {
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

    /**
     * @author Zhanghao
     * @date 2019/9/26 16:24
     * 
     * @param 	
     * @return void
     * @Description:    需要用到一个存储过程 add_pro() 具体的程序在下方注释。
    */
    public void callProcedure() throws Exception{
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url,user,password);
                CallableStatement cstmt=conn.prepareCall("{call add_pro(?,?,?)}")
                ){
            cstmt.setInt(1,4);
            cstmt.setInt(2,5);
            //注册CallableStatement 的第三个参数是Integer类型。
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            System.out.println("执行结果是："+cstmt.getInt(3));

        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/26 16:24
     *
     * @param args
     * @return void
     * @Description:   运行成功的前提是要在MySQL中创建一个存储过程：
     *
     * delimiter//
     * create procedure add_pro(a int ,b int ,out sun int)
     * begin
     * set sum = a + b;
     * end;
     * //
     *
     * 上面程序是创建该存储过程的程序。
     *
     *
    */
    public static void main(String[] args) throws Exception {
        CallableStatement_Test ct=new CallableStatement_Test();
        ct.initParam("mysql.ini");
        ct.callProcedure();

    }

}

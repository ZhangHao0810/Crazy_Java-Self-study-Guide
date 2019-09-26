package MySQL数据库和JDBC编程.Execute;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/26 14:30
 * @Description： 如果不清楚SQl语句的类型，就得使用Statement的execute方法。
 *
 */
public class ExecuteSQL {
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
     * @date 2019/9/26 14:45
     *
     * @param sql
     * @return void
     * @Description:  使用execute只能返回boolean值，
     * getResultSet() 获取返回的ResultSet对象。执行DDL语句会有ResultSet对象返回。
     * getUpdateCount（）返回执行DML语句所影响的行数。
    */
    /**
     * @author Zhanghao
     * @date 2019/9/26 15:15
     *
     * @param sql
     * @return void
     * @Description:  有点不明白为何  Connection   Statement ResultSet ResultSetMetaData 都他娘的是接口！！
     * 难道都是依赖于DriverManger类来创造实例对象吗。
     * 满屏都是接口，蛮诧异的。
    */
    public void executeSql(String sql) throws Exception {
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stm = conn.createStatement();
        ) {//执行SQL语句
            boolean hasResultSet = stm.execute(sql);

            if (hasResultSet) {
                try (
                        //获取结果集
                        ResultSet resultSet = stm.getResultSet()
                ) {
//                    ResultSetMetaData 是用于分析结果集的元数据接口
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnCount =resultSetMetaData.getColumnCount();
//                    迭代输出ResultSet对象
                    while (resultSet.next()){
                        for (int i = 0;i<columnCount;i++){
                            System.out.println(resultSet.getString(i+1)+" ");
                        }
                        System.out.println();
                    }
                }
            }
            else {
                System.out.println("该Sql语句影响的记录有"+stm.getUpdateCount()+"条");
            }

        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/26 15:14
     *
     * @param args
     * @return void
     * @Description:  有点不明白为何  执行DDL语句的时候，影响行数是0条。
    */
    public static void main(String[] args) throws Exception{
        ExecuteSQL es = new ExecuteSQL();

        es.initParam("mysql.ini");
        System.out.println("------------执行删除表的DDL语句----------");

        es.executeSql("drop table if exists my_test");
        System.out.println("========执行建表语句=========");
        es.executeSql("create table my_test"
                +"(test_id int auto_increment primary key, "
                +"test_name varchar(255))");
        System.out.println("========执行插入数据的DML语句===========");
        es.executeSql("insert into my_test(test_name) "
            +"select name from stu");
        System.out.println("=============执行查询数据的查询语句===========");
        es.executeSql("select * from my_test");



    }

}

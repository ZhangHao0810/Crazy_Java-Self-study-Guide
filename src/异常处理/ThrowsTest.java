package 异常处理;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 10:18
 * @Description：
 * 当不知道怎么处理时，用throws声明抛出异常，
 * 从普通方法throws出的异常，由他的上一级调用者来处理。
 * 从main（）throws出的异常将交给JVM处理,JVM的处理方式是打印异常的跟踪栈信息，并中止程序运行。
 * 可以抛出多个异常，用， 隔开
 * 一旦使用throws声明抛出了异常，程序就无需使用try-catch来捕获该异常了。
 */
public class ThrowsTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("a.txt");
    }
}

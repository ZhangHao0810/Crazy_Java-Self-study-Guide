package 异常处理;

import java.io.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 9:52
 * @Description： 在try语句后声明，初始化可关闭资源，语句结束会自动关闭资源，无需在finally块中操作，避免臃肿。
 *
 * 这些资源实现类必须实现AutoCloseable或者Closeable接口，（接口中定义了close方法）
 *
 * java几乎把所有的资源类，包括IO，JDBC的Connection，Statement等都实现了上述接口。
 *
 *
 * 这里学了IO之后再回来看。
 *
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br= new BufferedReader(new FileReader("b.txt"));
             PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))){
            System.out.println(br.readLine());
            ps.println("你是一个大笨猪");
        }

    }
}

package 反射;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author ZhangHao
 * @Date： 2019/10/8 10:51
 * @Description： 测试根类加载器Bootstrap ClassLoader。
 *                   根类加载器通过JVM 自身实现。而非java.ClassLoader 子类
 *    JVM启动时，形成三个类加载器组成的初始类加载器层次结构。
 *      Bootstrap ClassLoader 根类加载器。
 *      Extension ClossLoader 扩展类加载器，加载JRE扩展目录（放在jre/lib/ext ）中jar包的类。既可以自己开发类，放进去。
 *      System ClassLoader  系统（也称应用）类加载器。负责JVM启动时加载环境变量指定的JAR包和类路径。
 */
public class BootstrapTest {
    public static void main(String[] args) {
        /** 2019/10/8 11:03
         * 获取跟类加载器所加载的全部URL数组，并遍历输出
         *
         *  结果为：
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/resources.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/rt.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/sunrsasign.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/jsse.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/jce.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/charsets.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/lib/jfr.jar
         * file:/C:/Program%20Files/Java/jdk1.8.0_212/jre/classes
         *
         * Process finished with exit code 0
        */
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i].toExternalForm());
        }
    }
}

package 集合框架类Test.Map.HashMap和Hashtable.Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 20:29
 * @Description：
 * Properties 是Hashtable的子类，他在处理属性文件上特别方便。相当于key和value都是String类型的Map
 *
 * 它还提供了两个读写属性文件的方法。
 * > void load(InputStream inStream):
 * 追加内容到properties，从属性文件(以输入流表示)中加载key-value对,把加载到的 key-value对追加到Properties里(Properties是Hashtable的子类,它不保证key-value对之间的次序)。
 * void store(OutputStream out, String comments):
 * 保存properties到文件，将Properties中的key-value对输出到指定的属性文件(以输出流表示)中。
 * 这两个方法利用了java的IO体系中的基类 InputStream OutputStream
 */
public class Properties_Test {
    public static void main(String[] args) throws Exception {

            Properties props = new Properties();
//添加属性
            props.setProperty("Usetname","Zhanghao");
            props.setProperty("PassWord","123456");
//保存文件
            props.store(new FileOutputStream("PropertiesTest.ini"),"comment line");

            Properties props2 = new Properties();
//添加属性到另一个properties
            props2.setProperty("Gender","male");
//追加文件
            props2.load(new FileInputStream("PropertiesTest.ini") );
            System.out.println(props2);


    }

}

package IO流.Properties;

import java.io.*;
import java.util.Map;
import java.util.Set;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 20:29
 * @Description：
 * Properties 是Hashtable的子类，他在处理属性文件上特别方便。相当于key和value都是String类型的Map
 *
 * Properties 和IO流结合的功能：
 *
 *      void load(Reader reader )
 * *    void list(PrintWriter out); 只能接收打印流
 *      void store(Writer writer,String comment) 可以接收任意类型。
 * *
 * 方法利用了java的IO体系中的基类 InputStream OutputStream
 */
public class Properties {
    public static void main(String[] args) throws IOException {

//        Crazy_java_Method();

//        UseHashtableMethod();

//        UseListMethod();

//        UseLoadMethod();

//        UseStoreMethod();

    }


    /**
     * @author Zhanghao
     * @date 2019/10/6 11:38
     *
     * @param
     * @return void
     * @Description:
     * * >void store(OutputStream out, String comments):void store(Writer writer,String comment)
     *  * 保存properties到文件，将Properties中的key-value对输出到指定的属性文件(以输出流表示)中。
    */
    private static void UseStoreMethod() throws IOException {
        java.util.Properties pro=new java.util.Properties();

        pro.setProperty("8888","dn");
        pro.setProperty("9999","wq");
        pro.setProperty("7777","wzc");

        FileWriter fw=new FileWriter("IO/Properties2.txt");

        pro.store(fw,"HelloWord");

        pro.clear();
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 11:36
     *
     * @param
     * @return void
     * @Description:
     * > void load(InputStream inStream):  void load(Reader reader )
     *  * 追加内容到properties，从属性文件(以输入流表示)中加载key-value对,
     *  把加载到的 key-value对追加到Properties对象里(Properties是Hashtable的子类,它不保证key-value对之间的次序)。
    */
    private static void UseLoadMethod() throws IOException {
        java.util.Properties pro=new java.util.Properties();

        FileReader fr=new FileReader("IO/Properties.txt");

//        传这个输入流到pro对象中去，这个load的参数是字符流。 load（Reader reader）
        pro.load(fr);

        fr.close();

        System.out.println(pro);
    }

    private static void UseListMethod() throws FileNotFoundException {
        java.util.Properties pro=new java.util.Properties();

        pro.setProperty("8888","dn");
        pro.setProperty("9999","wq");
        pro.setProperty("7777","wzc");

        PrintWriter out =new PrintWriter("IO/Properties.txt");
        pro.list(out);

        out.close();
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 10:59
     *
     * @param
     * @return void
     * @Description:  使用Map(Hashtable)的特性，来存储properties
    */
    private static void UseHashtableMethod() {
        java.util.Properties prop=new java.util.Properties();

        prop.put("11111","张三");
        prop.put("22222","李四");
        prop.put("33333","王二");

//        利用key来找value
        Set<Object> keySet = prop.keySet();
        for (Object key :
                keySet) {
            Object value = prop.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("----------------");

//        利用entry 结婚证来找key和value。
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/22 20:29
     *
     * @param
     * @return void
     * @Description:   疯狂讲义中用到的Properties
    */
    private static void Crazy_java_Method() throws IOException {
        java.util.Properties props = new java.util.Properties();
//添加属性
        props.setProperty("Usetname","Zhanghao");
        props.setProperty("PassWord","123456");
//保存文件
        props.store(new FileOutputStream("PropertiesTest.ini"),"comment line");

        java.util.Properties props2 = new java.util.Properties();
//添加属性到另一个properties
        props2.setProperty("Gender","male");
//追加文件或者说加载文件到对象。这个load的参数是字节流。只存到了pro对象中，还没有追加到文件。
        props2.load(new FileInputStream("PropertiesTest.ini") );
        System.out.println(props2);
    }

}

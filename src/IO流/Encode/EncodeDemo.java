package IO流.Encode;

import java.io.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 11:42
 * @Description：  编码表 把计算机底层的二进制数据转换成能看到的字符。
 *   ASCII码表
 *
 *   GB3212  包含中文，又完全包含ASCII买码表
 *   GBK 是GB2312的升级版，包含更多。
 *
 *   Unicode  专门的组织 整合的各个国家的 大而全的码表 （java 中字符的默认码表）
 *             Unicode 所有的字符占两个字节。所以会有浪费。
 *   UTF-8  Unicode升级版 长度可变的码表。节省空间。
 *
 *   ANSI：本地编码表  跟系统环境、语言有关 Windows中文版的是 gbk
 *
 *      Java中的字符 默认是本地编码，为了防止乱码。
 *
 *
 *      乱码：编码保持前后一致即可解决。
 *          比如读写前后一致。
 *
 *
 *          字符转换流 （FileOutputStreamWriter） =字节流+编码
 *
 */
public class EncodeDemo {
    public static void main(String[] args) throws IOException {
//        writer();

        字符流中的编码原理();


//        output();
//        input();
        return;

    }

    private static void 字符流中的编码原理() throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("IO/Encode.txt"),"GBK");

        String s="妹子";
        osw.write(s);
        osw.close();
    }

    private static void writer() throws IOException {
        FileWriter fw=new FileWriter("IO/Encode.txt");

        String s="字符流";
        byte[] bytes=s.getBytes("gbk"); //就顺利乱码了。
        fw.write(new String(bytes));

        fw.close();
    }

    private static void input() throws IOException {
        FileInputStream fis=new FileInputStream("IO/Encode.txt");

        byte[] bytes=new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len,"gbk"));//乱码
            System.out.println(new String(bytes,0,len,"utf-8"));//正常
        }
    }

    private static void output() throws IOException {
        String s="张浩";

        byte[] bys=s.getBytes();//没有参数，使用默认编码换成数组。
//        byte[] bys=s.getBytes("gbk");//乱码

        FileOutputStream fos=new FileOutputStream("IO/Encode.txt");
        fos.write(bys);
        fos.close();
    }
}

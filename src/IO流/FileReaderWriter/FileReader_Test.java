package IO流.FileReaderWriter;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/28 20:30
 * @Description：
 * 从文件中读数据，显示到控制台
 * 读数据--输入流--FileReader
 *
 *  read()当读数据的返回值是-1时，便代表没有数据了。
 *  read(ch[]) 返回-1 也代表没有数据了。
 *
 *
 *  read()  读一个字符，返回这一个字符。
 *  read(ch[])将读到的数据放到 ch[]中，返回的是数组的长度、
 */
public class FileReader_Test {
    public static void main(String[] args) throws IOException {
//        FileReader fr=new FileReader("./IO/FileWriter_Test2.txt");
        FileReader fr=new FileReader("IO/FileWriter_Test2.txt");
//        int ch= fr.read();
//        System.out.println(ch);
//        System.out.println((char)ch);
//
//        ch= fr.read();
//        System.out.println(ch);
//        System.out.println((char)ch);


//        int ch;
//        while ((ch=fr.read())!=-1){
////            System.out.println(ch);
//            System.out.print((char)ch); //在这里一样能够读到换行符！！
//        }

//        char[] chs=new char[5];
//        int len=fr.read(chs);
//        System.out.println("len:"+len);
//        System.out.println(new String(chs)+"\n");

//        chs=new char[5];
//        len=fr.read(chs);
//        System.out.println("len:"+len);
//        System.out.println(new String(chs)+"\n");


        char[] chs=new char[1024];
        int len;
        while((len=fr.read(chs))!=-1){
            System.out.println("len:"+len);
            System.out.println(new String(chs,0,len)+"\n");
        }


        fr.close();

    }
}

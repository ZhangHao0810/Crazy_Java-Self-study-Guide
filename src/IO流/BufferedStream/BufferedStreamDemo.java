package IO流.BufferedStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/4 7:12
 * @Description：
 * BufferedWriter 将文本写入字符输出流，缓冲各个字符，提供单个字符，数组，和字符串的高效写入。
 * BufferedReader 从字符输入流中读取文本，缓冲各个字符，从而实现字符，数组的高效读取。
 *
 *  用缓冲流进行文件的输入输出会更高效。
 *
 *  缓冲流的特殊功能。
 *      BufferedWriter
 *          void newLine() ：写一个换行符，这个换行符由系统决定。
 *      BufferedReader
 *          String readLine() : 一次读取一行数据，但是不读取换行符。没有数据了，返回NULL
 *
 *
 */
public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {

/*//        创建 输出 缓冲流对象.构造方法不是直接传文件名（字符串）而是传一个FileWriter对象。
        BufferedWriter bw=new BufferedWriter(new FileWriter("IO/Bw.txt"));
        bw.write("Hello!");
//        bw.flush();
        bw.close();*/

//          创建输入缓冲流对象
        BufferedReader br=new BufferedReader(new FileReader("IO/FileWriter_Test2.txt"));

        int ch;
        while ((ch=br.read())!=-1){
            System.out.println((char)ch);
        }

        char[] chs=new char[1024];
        int len;
        while ((len=br.read(chs))!=-1) {
            System.out.println(new String(chs,0,len));
        }

        br.close();

    }
}

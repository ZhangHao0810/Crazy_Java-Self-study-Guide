package IO流.FileReaderWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/28 20:40
 * @Description： 把一个文件的内容复制到另一个文件中 利用字符输入输出流。
 */
public class CopyFileTest {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("IO/FileWriter_test.txt");
        FileWriter fw=new FileWriter("IO/copy.txt");

//        一次读取一个字符的方式
//        int ch;
//        while((ch=fr.read())!=-1){
//            fw.write(ch);
//        }

//        一次读取一个字符数组的方式，更高效。
        char[] chs=new char[1024];
        int len;
        while ((len=fr.read(chs))!=-1){
            fw.write(chs,0,len);
        }

        fr.close();
        fw.close();
    }


}

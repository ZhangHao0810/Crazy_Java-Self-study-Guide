package IO流.FileReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/28 20:12
 * @Description：
 *
 * windows换行需要\r\n
 * linux :\n
 * mac:\r
 *
 */
public class FileWriter_Test2 {
    public static void main(String[] args) throws IOException {
//        FileWriter fw=new FileWriter("FileWriter_Test2.txt");
//        用以下构造方法便可实现追加写入
        FileWriter fw=new FileWriter("./IO/FileWriter_Test2.txt",true);
        fw.write("Hello\r\nWord!!!");

        fw.write("追加的");
        fw.flush();
        fw.close();


    }
}

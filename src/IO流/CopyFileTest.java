package IO流;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/28 20:40
 * @Description： 把一个文件的内容复制到另一个文件中
 */
public class CopyFileTest {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("IO/FileReader.txt");
        FileWriter fw=new FileWriter("IO/copy.txt");

        int ch;
        while((ch=fr.read())!=-1){
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }


}

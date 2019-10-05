package IO流.FileIn_OutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/4 17:15
 * @Description： IO的基类 用于输入输出字节流。
 * 输出流会自动创建新的文件。
 */
public class FileIn_OutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("IO/File.txt");
        FileOutputStream fos=new FileOutputStream("IO/newFile.txt");

        byte[] buty=new byte[1024];
        int hasRead;
        while ((hasRead=fis.read(buty))>0){
            fos.write(buty,0,hasRead);
        }
    }
}

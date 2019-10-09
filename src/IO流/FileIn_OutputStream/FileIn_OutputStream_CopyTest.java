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
public class FileIn_OutputStream_CopyTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("IO/File.txt"); //这里直接用字符串是因为字节流的构造应该输入的是File对象，但是输入字符串他也可以自动new出来这个File对象。
        FileOutputStream fos=new FileOutputStream("IO/newFile.txt");

        byte[] buty=new byte[1024];
        int hasRead;
        while ((hasRead=fis.read(buty))!=-1){ //这里的判断依据可以是！=-1 也可以是>0
            fos.write(buty,0,hasRead);
        }
    }
}

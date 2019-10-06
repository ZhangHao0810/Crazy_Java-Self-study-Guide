package IO流.System;

import java.io.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 0:18
 * @Description： 读取键盘录入的数据，写入文件中、
 *
 * 转换流：把字节输入流转换成字符输入流。InputStreamReader
 *
 */
public class InputStreamReader_Test {
    public static void main(String[] args) throws IOException {
        InputStream inputStream= System.in;

        Reader r=new InputStreamReader(inputStream);

        FileWriter fileWriter=new FileWriter("IO/InputStreamReader.txt");

        char[] chars=new char[1024];
        int len;
        while ((len=r.read(chars))!=-1){
            fileWriter.write(chars,0,len);
            fileWriter.flush();
        }

        inputStream.close();
        fileWriter.close();
    }

    private static void method() throws IOException {
        InputStream inputStream= System.in;

        FileWriter fileWriter=new FileWriter("IO/InputStreamReader.txt");

        byte[] bytes=new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            fileWriter.write(new String(bytes,0,len));
            fileWriter.flush();
        }

        inputStream.close();
        fileWriter.close();
    }

}

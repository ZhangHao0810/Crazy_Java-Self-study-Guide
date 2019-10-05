package IO流.BufferedStream;

import java.io.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/4 8:25
 *
 * 利用缓冲流
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("IO/FileWriter_Test2.txt"));

        BufferedWriter bw=new BufferedWriter(new FileWriter("IO/copy.txt"));

/*        int ch;
        while ((ch=br.read())!=-1){
            bw.write(ch);
        }*/

/*        char[] chs=new char[1024];
        int len;
        while ((len=br.read(chs))!=-1){
            bw.write(chs,0,len); //保证了不将多余的空的数组内容输出。
        }*/

//      利用缓冲流的特殊功能进行文件的复制。。
        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();
    }
}

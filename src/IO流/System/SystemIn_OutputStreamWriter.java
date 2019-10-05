package IO流.System;

import java.io.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/5 22:19
 * @Description： 标准输入输出流：
 *      public static final InputStream in； 字节输入流。从键盘输入（学会和从文件输入相区别）
 *          InputStream is=System.in;
 *          Scanner sc = new Scanner(System.in);
 *         public static final PrintStream out； 字节输出流,将数据输出到命令行。
 *              System.out.println();
 *
 *     因为标准输出流是字节输出流，所以想输出字符串最好把字节输出流转换成字符输出流。
 *      OutputStreamWriter 的子类是FileWriter
 *      OutputStreamWriter(OutputStream out)
 */
public class SystemIn_OutputStreamWriter {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("IO/SystemInOutDemo.txt"));
//        OutputStream os = System.out;
//        Writer writer = new OutputStreamWriter(System.out);
//        BufferedWriter bw= new BufferedWriter(writer);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    private static void method2() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("IO/SystemInOutDemo.txt"));
//        OutputStream os = System.out;
        Writer writer = new OutputStreamWriter(System.out);

        String line;
        while ((line=br.readLine())!=null){
            writer.write(line);
            writer.write("\r\n");
        }

        writer.close();
        br.close();
    }

    private static void method1() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("IO/SystemInOutDemo.txt"));
        OutputStream os = System.out;

        String line;
        while ((line=br.readLine())!=null){
            os.write(line.getBytes());
            os.write("\r\n".getBytes());
        }

        os.close();
        br.close();
    }
}

package IO流.PrintWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 8:03
 * @Description：  打印流。只可以输出。直接父类是Writer。
 *  PrintWriter实现了PrintStream的所有方法。println（）等
 *     ！ 自动换行，println()  [这个换行和系统无关]
 *     ！ 他不能输出字节，但是可以输出其他任意类型。
 *     ！ 自动刷新，开启自动刷新，调用print println format 才有用。
 *           注意：创建FileWriter对象时的boolean参数是 是否追加
 *                 而创建打印流对象的Boolean类型参数是 是否自动刷新。
 *
 *     打印流是包装流，不具备写出功能。需要一个输出流。
 *     打印流可以把字节输出流转换成字符输出流。
 *

 *
 */
public class PrintWriter_Test {
    public static void main(String[] args) throws IOException {
//        Println();
//        PrintWriter pw=new PrintWriter("IO/PrintWriter2.txt");

        PrintWriter pw=new PrintWriter(new FileWriter("IO/PrintWriter2.txt",true),true);

        pw.println("Hello");
        pw.println("Word");
        pw.println("Java");

//        pw.close();

    }

    private static void Println() throws FileNotFoundException {
        PrintWriter pw=new PrintWriter("IO/PrintWriter.txt");

//        pw.write("Hello");
//        pw.write("Word");
//        pw.write("Java");

        pw.println("Hello");
        pw.println("Word");
        pw.println("Java");

        pw.close();
    }
}

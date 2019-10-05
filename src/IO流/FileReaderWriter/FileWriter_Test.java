package IO流.FileReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/28 20:00
 * @Description： 写数据---输出流--FileWriter
 *
 * 输出流会自动创建文件。
 *
 * FileWriter（String fileName）
 *
 *  *  创建输出流对象
 *  *  调用写数据方法，并刷新缓冲区
 *  *  释放资源（这一步其实蕴涵着flush()）
 *
 *
 *  相对路径  ./  当前文件夹下 或者 直接写。IO/FileWriter.txt
 *           ../ 父级文件夹下
 */
public class FileWriter_Test {
    public static void main(String[] args) throws IOException {
//      1.创建输出流对象。调用系统资源创建文件，将输出流对象指向文件。
        FileWriter fw=new FileWriter("./IO/FileWriter_test.txt");//若无具体路径，默认是项目的根目录,是相对路径。
//      2.写一个字符串数据，单纯下面语句无法写入，因为硬盘存储数据的最基本单位是字节，一个字符串是好多个字节，所以传不进去
        fw.write("IO流你好！！");
//        数据没有直接写入文件，其实是写入了缓冲区
        fw.flush();//刷新缓冲区
//      3.释放资源:通知系统释放和该对象相关的资源，文件便可以自由了。
        fw.close();
    }
}

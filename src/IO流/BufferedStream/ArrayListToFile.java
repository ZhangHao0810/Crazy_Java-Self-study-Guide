package IO流.BufferedStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/4 8:49
 * @Description：    集合中的数据写入文件
 */
public class ArrayListToFile {
    public static void main(String[] args) throws IOException {
        String str= "Hello,I am ArrayList!";
        ArrayList<String> arrayList=new ArrayList<String>();

        arrayList.add(str);
        arrayList.add("you can see me~");
        arrayList.add("put your hands up!");

        BufferedWriter bw=new BufferedWriter(new FileWriter("IO/Array.txt"));

        for (int x=0;x<arrayList.size();x++){
            String s = arrayList.get(x);
            bw.write(s);
            bw.newLine(); //通过他可以实现写文件的时候换行！！！！！
            bw.flush();
        }

        bw.close();


    }
}

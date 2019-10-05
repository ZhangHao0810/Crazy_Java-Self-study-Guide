package IO流.PushBack;

import java.io.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/5 8:38
 * @Description： 推回输入流。
 * 找出文件中的"you" 字符串，打印该字符串之前的内容。
 */
public class PushBackTest {
    public static void main(String[] args) {
        try (//创建PushBackReader对象，指定退回缓冲区的长度为64
             PushbackReader pr = new PushbackReader(new FileReader("IO/Array.txt"), 64)) {
            char[] buf = new char[32];
//            用于保存上次读取字符串的内容
            String lastContent = "";
            int hasRead = 0;
//            循环读取文件内容
            while ((hasRead = pr.read(buf)) > 0) {
//                将读取的内容转换成字符串
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
//                将上次读取的字符串和本次读取的字符串拼起来。
//                查看是否包含目标字符串，如果包含目标字符串
                if ((targetIndex = (lastContent + content).indexOf("you")) > 0) {
//                    将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
//                    重新定义一个长度为targetIndex的char数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
//                    再次读取指定长度的内容（目标字符串之前的内容）
                    pr.read(buf, 0, targetIndex);
//                    打印读取的内容
                    System.out.println(new String(buf, 0, targetIndex));
                    System.exit(0);
                } else {
//                    打印上次读取的内容
                    System.out.println(lastContent);
//                    将本次内容设为上次读取的内容。
                    lastContent = content;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

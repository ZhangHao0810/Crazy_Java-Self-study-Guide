package IO流.Object_InOut_Stream;

import java.io.*;
import java.util.ArrayList;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 8:48
 * @Description：        对象操作流，可以读写任意类型的对象！
 *      对象输出流：ObjectOutputStream 将Java对象的基本数据类型写入OutPutStream
 *                      writeObject()
 *                      ObjectOutPutStream（OutputStream out）
 *      对象输入流：objectInputStream  读取（重构）对象
 *                      readObject()
 *                      ObjectInputStream(InputStream in);
 *
 *   注意：使用对象输出流，就一定使用对象输出流。
 *   要求实现序列化接口。Exception in thread "main" java.io.NotSerializableException: IO流.Object_InOut_Stream.Student
 *
 *   Serializable：序列化接口，是一个标识接口，只起标识作用，没有方法。
 *                  当一个类的对象需要进行IO流读写的时候，该类必须实现Serializable接口。
 *
 *  Exception in thread "main" java.io.EOFException 当输入过程意外达到文件或者流的末尾时，抛出该异常。
 *
 *
 */
public class Object_InOut_Stream_Test  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        objectOutputStream();

        objectInputStream();

//        System.out.println("--------------------------------------");
//
//        objectOutputStream2();
//
//        objectInputStream2();

        return;


    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 10:13
     *
     * @param
     * @return void
     * @Description:  解决对象输入流读取对象出现异常的问题，通过只读写一个对象（集合对象）来解决。
     * 输入的时候用集合来接收。然后遍历集合即可。
    */
    private static void objectInputStream2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("IO/ObjectStream_b.txt"));
        Object o = ois.readObject();
//        System.out.println(o);

        ArrayList<Student> list = (ArrayList<Student>) o;

        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 10:04
     *
     * @param
     * @return void
     * @Description:   解决对象输入流读取对象出现异常的问题，通过只读写一个对象（集合对象）来解决。
     *                   先利用集合输出。
    */
    private static void objectOutputStream2() throws IOException {

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("IO/ObjectStream_b.txt"));

        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("xiaoming",12));
        list.add(new Student("xiaohong",22));
        list.add(new Student("xiaoliu",18));

        oos.writeObject(list);

        oos.close();
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 9:58
     *
     * @param
     * @return void
     * @Description: 对象流输入
    */
    private static void objectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("IO/ObjectStream_a.txt"));

        try {
            while (true){
                //ClassNotFoundException 有可能找不到这个类，因为可能把Student类删掉。所以要抛出找不到类异常。
                Object o = ois.readObject();
                System.out.println(o);
            }
        } catch (EOFException e) {
            System.out.println("读到文件结尾了。(这是catch的内容)");
        }

        ois.close();
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 9:59
     *
     * @param
     * @return void
     * @Description:    对象流输出
    */
    private static void objectOutputStream() throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("IO/ObjectStream_a.txt"));

        Student s1=new Student("zhangsan",18);
        Student s2=new Student("lisi",28);
        Student s3=new Student("wangermazi",85);

        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);

        oos.close();
    }

}

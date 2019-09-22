package 集合框架类Test.Collection.Set.TreeSet;

import java.util.Date;
import java.util.TreeSet;


/**
 * @Auther： ZhangHao
 * @Date： 2019/9/20 23:07
 * @Description：
 */
public class TreeSetError_Test {
    public static void main(String[] args) {

        /**
         * @author Zhanghao
         * @date 2019/9/20 23:15
         *
         * @Description:
         * 1.对象放到TreeSet必须实现Comparable接口，
         * 2.TreeSet中必须存放的是同一个类的对象。
        */

       TreeSet ts = new TreeSet();

        ts.add(new TreeSetError_Test());
        //添加第二个Err对象时，TreeSet会调用对象的comparableTo（Object obj）
        //方法与集合中的其他元素进行比较,对应的类没有实现Comparable接口，便会报错。
        //虽然第一个不报错，但是取出元素的时候也会报同样的错。
        ts.add(new TreeSetError_Test());

        //向集合中添加两个对象。会报错，
        // 所以用户自定义类实现的Comparable接口的compareTo方法要进行强制类型转换。
        ts.add(new String("Test!!!!!"));
        ts.add(new Date());


    }
}

package 集合框架类.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
/**
 *
 * @Description:    测试collection的基本使用，其他方式看API
 * @Author:         ZhangHao
 * @CreateDate:     2019/9/18 11:26
 * @UpdateUser:     Zhanghao
 * @UpdateDate:     2019/9/18 11:26
 * @UpdateRemark:   暂无修改
 * @Version:        1.0

*/
public class collection_Test {

    public static void main(String[] args) {
        //多态，应用ArrayList的方法。
        Collection c = new ArrayList();
        //添加元素
        c.add("张三");
        c.add(6);
        System.out.println("元素个数:"+c.size());
        //移出元素
        c.remove(6);
        System.out.println("元素个数:"+c.size());
        //再次添加
        c.add("张浩是最强的。");
        System.out.println("元素个数:"+c.size());

        //应用HashSet的方法，同上
        Collection books = new HashSet();
        books.add("测试判断包含字符串程序");

        System.out.println("yes?no?"+books.contains("字符串"));

    }

}
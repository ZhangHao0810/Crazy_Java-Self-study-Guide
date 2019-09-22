package 集合框架类Test.Collection.Set.EnumSet;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 14:43
 * @Description： 本程序演示复制Collection集合中的所有元素来创建新的EnumSet集合。
 * 要求Collection集合中的所有元素必须是同一个枚举类型的枚举值。
 */
public class EnumSet_Test2 {

    public static void main(String[] args) {
        Collection c = new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.SPRING);

        EnumSet enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet);

//        c.add("Crazy ZhangHao");//这一句报错，java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Enum
//        c.add(9);// 报错：java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Enum

        enumSet = EnumSet.copyOf(c);
    }
}

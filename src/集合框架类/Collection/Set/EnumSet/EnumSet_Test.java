package 集合框架类.Collection.Set.EnumSet;

import java.util.EnumSet;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 14:28
 * @Description： 集合元素也是有序的，以枚举值在Enum类内定义顺序来决定集合元素的顺序
 * EnumSet类没有暴露构造器来创造实例，需要用方法来创建实例对象。
 *
 * 本程序演示EnumSet的基本用法。
 */

enum Season{
    SPRING, SUMMER,FALL,WINTER
}

public class EnumSet_Test {
    public static void main(String[] args) {

        //创建集合，指定元素为season枚举值。
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println(es1);
        //创建空集合，指定集合元素为season枚举值。
        EnumSet es2 =  EnumSet.noneOf(Season.class);
        System.out.println(es2);
        //手动添加元素。
        es2.add(Season.WINTER);
        es2.add(Season.SPRING);
        System.out.println(es2);

        //以指定枚举值创建集合
        EnumSet es3 = EnumSet.range(Season.SUMMER,Season.WINTER); //从1到2之间都包括。
        EnumSet es4 = EnumSet.of(Season.SUMMER,Season.WINTER); //1 和 2
        System.out.println(es3);
        System.out.println(es4);

        EnumSet es5 = EnumSet.complementOf(es3); //es5补全es3
        System.out.println(es5);
    }

}

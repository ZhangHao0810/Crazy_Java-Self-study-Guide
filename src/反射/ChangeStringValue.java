package 反射;

import java.lang.reflect.Field;

/**
 * @author ZhangHao
 * @date 2019/10/9 15:06
 * @Description： 利用反射来改变String的值。牛逼了。
 */
public class ChangeStringValue {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "abc";
        System.out.println(str);

//        反射可以获取私有属性并且可以操作私有属性，虽然很不合理。嘿嘿
        Class<? extends String> aClass = str.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
//        注意，String 修饰的value是: private final char[]
//             因为是final的 所以数组的大小不能动，地址不让动
//                      （内存地址）地址虽然不让动，但是地址里的字可以变。
//        为什么呢，因为经过getDeclaredField("value");/setAccessible(true);之后，相当于只把private修饰符屏蔽了，
//                      private是屏蔽内容的。而 final 和char[] 的基本结构不能变。
        char[] chars = (char[]) value.get(str);
//        chars 引用指向了内存中真实的String对象中的数组，挨着修改数组内每个元素的值！
        chars[0]='唉';chars[1]='嘿';chars[2]='嘿';


//        完成修改！！
        System.out.println(str);


    }
}

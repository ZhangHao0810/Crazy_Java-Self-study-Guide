package 集合框架类.Map.HashMap和Hashtable.WeakHashMap;

import java.util.WeakHashMap;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 21:10
 * @Description：
 * WeakHashMap与HashMap的用法基本相似。
 * 与HashMap的区别在于, HashMap的key保留了对实际对象的强引用,
 * 这意味着只要该HashMap对象不被销毁,该HashMap的所有key所引用的对象就不会被垃圾回收,
 * HashMap也不会自动删除这些key所对应的key-value对;
 * 但WeakHashMap的key只保留了对实际对象的弱引用,
 * 这意味着如果WeakHashMap对象的key所引用的对象没有被其他强引用变量所引用,
 * 则这些key所引用的对象可能被垃圾回收, WeakHashMap也可能自动删除这些key所对应的key-value对。
 * WeakHashMap中的每个key对象只持有对实际对象的弱引用,因此,当垃圾回收了该key所对应的实际对象之后,
 * WeakHashMap会自动删除该key对应的key-value对。看如下程序。
 *
 *
 */
public class WeakHashMap_Test {
    public static void main(String[] args) {
        WeakHashMap whm = new WeakHashMap();

        whm.put(new String("语文") ,new String("良好"));
        whm.put(new String("数学") ,new String("及格"));
        whm.put(new String("英语") ,new String("中等"));

        whm.put("Java",new String("中等"));  //"java" 是一个字符串直接量，自动保留对该字符串对象的强引用，所以垃圾回收时不会回收它。

        System.out.println(whm);
//        通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
//        通常情况下将只能看到一个键值对。
        System.out.println(whm);

    }
}

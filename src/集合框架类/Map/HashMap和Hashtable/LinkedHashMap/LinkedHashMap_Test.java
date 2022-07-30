package 集合框架类.Map.HashMap和Hashtable.LinkedHashMap;

import java.util.LinkedHashMap;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 20:16
 * @Description： LinkedHashMap 也使用双向链表来维护Key-value对的次序。（只考虑key）
 *  该链表负责维护Map的迭代顺序，顺序与键值对插入顺序保持一致。
 *
 *  LinkedHashMap可以避免对HashMap Hashtable里的键值对进行排序，同时又避免使用TreeMap所增加的成本。
 *
 *  因维护插入顺序，性能略低于HashMap  但是在迭代访问Map全部元素的时候将有较好的性能。
 *
 *  下列方法可以看到LinkedHashMap 可以记住key-Value
 */
public class LinkedHashMap_Test {
    public static void main(String[] args) {
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文",80);
        scores.put("数学",90);
        scores.put("英语",70);
        //该方法为java8的新特性。
        scores.forEach((key,value)-> System.out.println(key +"--->"+value));

    }
}

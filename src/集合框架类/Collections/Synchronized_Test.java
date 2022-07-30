package 集合框架类.Collections;

import java.util.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/24 20:55
 * @Description： 通过方法将指定的集合包装成线程同步的集合，解决多线程并发访问集合时的线程安全问题。
 *
 * 将新创建的集合对象传给了Collections的synchronizedXxx 方法，可以直接获取List，Set，Map的线程安全实现版本。
 */
public class Synchronized_Test {
    public static void main(String[] args) {
        Collection<Object> c = Collections.synchronizedCollection(new ArrayList());
        List list = Collections.synchronizedList(new ArrayList());
        Set s = Collections.synchronizedSet(new HashSet<>());
        Map map = Collections.synchronizedMap(new HashMap<>());
    }
}

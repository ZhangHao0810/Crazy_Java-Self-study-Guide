package 集合框架类.古老的Enumeration类;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/24 21:09
 * @Description：  Enumeration 是一个古老的迭代器（JDK1.0），只能用来遍历古老的Vector和Hashtable集合里面的元素。
 *
 * 除非极端情况下，否则都应该选择Iterator迭代器（从JDK1.2开始）
 */
public class Enumeration_Test {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("11111");
        v.add("222222");

        Hashtable scores = new Hashtable();
        scores.put("语文",78);
        scores.put("数学",89);
        scores.put("政治",99);

        Enumeration em = v.elements();
        while (em.hasMoreElements()){
            System.out.println(em.nextElement());
        }
        Enumeration keyEm = scores.keys();
        while (keyEm.hasMoreElements()){
            Object key = keyEm.nextElement();
            System.out.println(key+"----->"+scores.get(key));
        }
    }
}

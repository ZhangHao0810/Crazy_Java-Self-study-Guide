package 集合框架类Test.Map.HashMap和Hashtable.IdentityHashM;

import java.util.IdentityHashMap;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 21:36
 * @Description：
 * 这个Map实现类的实现机制与HashMap基本相似,但它在处理两 key相等时比较独特:
 * 在 IdentityHashMap中,当且仅当两个key严格相等(keyl=key2)时, IdentityHashMap才认为两个key相等;
 * 对于普通的HashMap而言,只要keyl和key2通过equals()方法比较返回true,且它们的hashCode值相等即可。
 * IdentityHashMap是一个特殊的Map实现!此类实现Map接口时,它有意违反Map的通常规范:
 * IdentityHashMap要求两个key严格相等时才认为两个key相等。
 * IdentityHashMap提供了与HashMap基本相似的方法,也允许使用null作为key和value。
 * 与HashMap相似: IdentityHashMap也不保证key-value对之间的顺序,更不能保证它们的顺序随时间的推移保持不变。
 */
public class IdentityHashMap_Test {
    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();

        ihm.put(new String("语文"),78);
        ihm.put(new String("数学"),98);
        ihm.put(new String("英语"),68);

        ihm.put("Java",97);
        ihm.put("Java",99);//这里的两个Java字符串的hashcode应该不相等，因为是两个对象。HashMap可以添加成功。
        System.out.println(ihm);

    }
}

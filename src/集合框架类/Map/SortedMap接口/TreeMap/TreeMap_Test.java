package 集合框架类.Map.SortedMap接口.TreeMap;

import java.util.TreeMap;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 20:47
 * @Description：
 * Set和Map的关系十分密切,
 * Java源码就是先实现了HashMap. TreeMap等集合,然后通过包装一个所有的value都为null的Map集合实现了Set集合类。
 *
 *  所以TreeMap和TreeSet原理是一样的。也是有两种排序方式。
 * >自然排序: TreeMap的所有key必须实现Comparable接口,而且所有的key应该是同一个类的对象,否则将会抛出ClassCastException异常。
 * >定制排序:创建TreeMap时,传入一个Comparator对象,该对象负责对TreeMap中的所有key进行排序。
 * 采用定制排序时不要求Map的key实现Comparable接口。
 *
 *   定制排序要重写Compare() 自然排序重写CompareTo()  Compare本质上也是CompareTo。
 *
 *
 * 类似于TreeSet中判断两个元素相等的标准, TreeMap中判断两个key相等的标准是:
 * 两个key通过compareTo0)方法返回0, TreeMap即认为这两个key是相等的。
 * 如果使用自定义类作为TreeMap的key,且想让TreeMap良好地工作,
 *      则重写该类的equals)方法和compareTo0方法时应保持一致的返回结果:
 *          两个key通过equals()方法比较返回true时,它们通过 compareTo()方法比较应该返回0。
 * 如果equals()方法与compareTo()方法的返回结果不一致, TreeMap与Map接口的规则就会冲突,
 *
 */
class R implements  Comparable {
    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R[" +
                "count=" + count +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null && o.getClass() != R.class) {
            R r = (R) o;
            return this.count == r.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        R r = (R) o;
        return count > r.count ? 1 :
                count < r.count ? -1 : 0;
    }

}


public class TreeMap_Test {
    public static void main(String[] args) {

        TreeMap tm = new TreeMap();
        tm.put(new R(3),"11111111");
        tm.put(new R(-5),"22222222");
        tm.put(new R(9),"3333333333");
        System.out.println(tm);

        System.out.println(tm.firstEntry());
        System.out.println(tm.lastKey());
        System.out.println(tm.higherKey(new R(2)));
        System.out.println(tm.lowerEntry(new R(2)));

        System.out.println(tm.subMap(new R(-1),new  R(4)));

    }


}

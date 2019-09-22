package 集合框架类Test.Collection.Set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/20 10:08
 * @Description： Hashset不是同步的，需用代码保证同步。按Hash算法来存储集合中的元素。
 *  当向HashSet集合中存入一个元素时, HashSet会调用该对象的hashCode()方法来得到该对象的 hashCode值,
 *然后根据该hashCode值决定该对象在HashSet中的存储位置。
 *  如果有两个元素通过equals()方法比较返回true,但它们的hashCode()方法返回值不相等,HashSet将会把它们存储在不同的位置,依然可以添加成功。
 *  也就是说, HashSet集合判断两个元素相等的标准是两个对象通过equals)方法比较相等,并且两的hashCode)方法返回值也相等。
 *
 *可变对象加入到HashSet之后，尽量不要修改集合元素中参与计算hashCode(),equals()的实例变量。或者不要让可变对象加入HashSet
 *
 * 上述说法的原因：因为HashSet存的对象唯一，依据是hashcode()的返回值。每次添加的时候都会有一个list来记录并比较hashcode的值。
 * 也就是说，每次add默认执行了一次contains()方法。这个方法会先调用对象的hashCode()再调用equals()只要他俩都返回false
 * 就代表这个对象不存在，可以添加。
 * 但是这个list是有缓存的，第一次contains执行完之后会缓存所有的hashcode，以后在调用contains时用的是缓存的hashcode（即那个list）
 * 所以本程序hashSet中的第一个对象，count值从-3变为了-2，而他的hashCode值却延续了缓存中的值-2没有变。这样用contains判断的时候，
 * 找-3这个量，hashcode通不过（因为那个合格的被删掉了。），找-2这个量，equals通不过，所以都报false。
 *
 * Object的hashCode()根据对象的内存地址算出的，保证不重复。String重写Object的hashCode()只要字符串内容相等（equals返回true）就相等
 *
 */

/**
 * @author Zhanghao
 * @date 2019/9/20 21:58
 *
 * @Description:   注意：本测试程序发现HashSet自动按照count值的升序排列输出，觉得与Set集合的定义相违背。所以网上查找了原因：
 * 链接：https://www.zhihu.com/question/28414001/answer/740571085
 * 来源：知乎
 * HashSet的add方法直接调用HashMap的put方法，并且将元素e放到map的key位置（保证了唯一性 ）
 *      JDK7到JDK8，其内部发生了一些变化，导致在不同版本JDK下运行结果不同，从HashSet追溯到HashMap的hash算法、加载因子和默认长度。
 * 由于我们所创建的HashSet是Integer类型的，这也是最巧的一点，Integer类型hashCode()的返回值就是其int值本身，而存储的时候元素通过一些运算后会得出自己在数组中所处的位置。
 * 由于在这一步，其本身即下标(只考虑这一步)，其实已经实现了排序功能，由于int类型范围太广，内存放不下，所以对其进行取模运算，为了减少哈希冲突，又在取模前进行了，
 * 扰动函数的计算，得到的数作为元素下标，按照JDK8下的hash算法，以及load factor及扩容机制，这就导致数据在经过 HashMap.hash()运算后仍然是自己本身的值，
 * 且没有发生哈希冲突。
 *      补充：对于有序无序的理解集合所说的序，是指元素存入集合的顺序，当元素存储顺序和取出顺序一致时就是有序，否则就是无序。
 * 并不一定是升序排列，HashSet的迭代器在输出时“不保证有序”，但也不是“保证无序”。也就是说，输出时有序也是可能的，但是你的程序不应该依赖这一点。
 * HashSet只是不保证有序，并不保证无序.
 * HashSet并不关心key的“排序”，就算其iterator“有序”通常也是说“按元素插入顺序”（LinkedHashSet就支持插入顺序遍历）。
 * 题主在此看到的所谓“有序”纯粹是个巧合。
 *
*/

class R{
    int count;

    public R(int count){
        this.count = count;
    }

    @Override
    public String toString() {
        return "R[count:"+count+"]";
    }

    /**
     * @author Zhanghao
     * @date 2019/9/20 16:52
     *  * @param obj	
     * @return boolean
     * @Description: 重写了equals，只要是一个类的对象，equals()都返回true。
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj.getClass() == R.class) {
            R r = (R) obj;
            return this.count == r.count;
        }
       return false;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}

public class HashSet_Test{

    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));

        System.out.println(hs);

        Iterator it = hs.iterator();
        R first = (R)it.next();
        //把第一个对象的count赋值-3,这样就有两个-3了，而他的hashcode还是原来的-2。
        first.count = -3;
        System.out.println(hs);
        //删除count值为-3的对象。
        hs.remove(new R(-3));

        System.out.println(hs);
        System.out.println("hs包含count 为-3的对象？"+ hs.contains(new R(-3))); //输出false
        System.out.println("hs包含count 为-2的对象？"+ hs.contains(new R(-2))); //输出false



    }

}

//
///**
// * @Description:    没有重写Hashcode()方法，但equals()总返回true
// * @Author:         ZhangHao
// * @CreateDate:     2019/9/20 16:27
//*/
//class A{
//    @Override
//    public boolean equals(Object obj) {
//        return true;
//    }
//}
//
///**
// * @Description:    hashcode()总返回1，没有重写equals()。
// * @Author:         ZhangHao
// * @CreateDate:     2019/9/20 16:26
//*/
//class B{
//    @Override
//    public int hashCode() {
//        return 1;
//    }
//}
///**
// * @Description:    Hashcode()总返回2，重写equals()总返回true
// * @Author:         ZhangHao
// * @CreateDate:     2019/9/20 16:23
//*/
//class  C{
//    @Override
//    public int hashCode() {
//        return 2;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return  true;
//    }
//}
//
//public class HashSet_Test {
//    public static void main(String[] args) {
//        HashSet book = new HashSet();
//
//        book.add(new A());
//        book.add(new A());
//        book.add(new B());
//        book.add(new B());
//        book.add(new C());
//        book.add(new C());
//
//        System.out.println(book);
//
//    }
//
//
//}

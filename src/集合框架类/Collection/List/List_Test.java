package 集合框架类.Collection.List;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 15:24
 * @Description： 演示List基本使用
 *
 * Java 8 为List接口添加了如下两个默认方法。
 * void replaceAl(naryOperator operator):根据operator指定的计算规则重新设置List集合的所有元素。
 * void sort(Comparator c):根据Comparator参数对List集合的元素排序。
 */
public class List_Test {
    public static void main(String[] args) {
        List books = new ArrayList();

        books.add(new String("11111111111"));
        books.add(new String("222222222222"));
        books.add(new String("33333333333"));
        books.add(new String("4444444444444"));
        System.out.println(books);

//      插入元素在位置
        books.add(1,new String("插入的"));

//        获得某元素并遍历。
        for( int i = 0 ;i < books.size() ; i++){
            System.out.println(books.get(i));
        }

//        移出某元素。
        books.remove(3);
        System.out.println(books);

//        输出某元素的位置。
        //这里参数是一个新的对象。调用了equals方法依次与集合中的对象进行比较。返回true便相等了。
        System.out.println(books.indexOf(new String("11111111111")));

//        将第二个元素替换
        books.set(1,new String("新的2222222222"));
        System.out.println(books);

//        截取2（包含）-3（包含）个元素成子集合。
        System.out.println(books.subList(1,2));
    }
}

package 集合框架类Test.Collection.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 15:59
 * @Description：  List除了Iterator()之外，还额外提供了一个listIterator()方法，返回ListIterator对象。
 * Listlterator接口继承了Iterator接口
 * Listiterator接口在 terator接口基础上增加了如下方法。
 *
 * boolean hasPrevious():返回该迭代器关联的集合是否还有上一个元素。
 * Object previous():返回该迭代器的上一个元素。
 * void add(Object o):在指定位置插入一个元素。
 *
 * 拿Listlterator与普通的Iterator进行对比,不难发现ListIterator增加了向前迭代的功能(Iterator只能向后迭代),
 * 而且Listiterator还可通过add()方法向List集合中添加元素(Iterator只能删除元素)。
 *
 * 下面程序示范了Listlterator的用法。
 */
public class ListIterator_Test {
    public static void main(String[] args) {
        String[] books = {
            "Zhangsan","Lisi","wangwu","Wangermazi"
        };

        List bookList = new ArrayList<>();
        for (int i = 0; i<books.length; i++){
            bookList.add(books[i]);
        }

        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
            lit.add("-----Iterator不能添加，而ListIterator可以-------");
        }

        System.out.println("------下面开始反向迭代---------");
        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }

}

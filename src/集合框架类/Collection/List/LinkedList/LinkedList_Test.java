package 集合框架类.Collection.List.LinkedList;

import java.util.LinkedList;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 18:42
 * @Description：
 * LinkedList ：基于链的List，在插入，删除方面比基于数组的ArrayList要好，但是访问的时候不如内存连续的ArrayList
 * LinkedList类是List接口的实现类-这意味着它是一个List集合,可以根据索引来随机访问集合·中的元素。
 * 除此之外, LinkedList还实现了Deque接口,可以被当成双端队列来使用,
 * 因此既可以被当成“栈”来使用,也可以当成队列使用。
 *
 * 下面程序简单示范了LinkedList集合的用法。
 */
public class LinkedList_Test {
    public static void main (String [] args) {
        LinkedList books = new LinkedList();
        //将字符串元素加入队列的尾部
        books.offer("疯狂Java讲义");
        //将一个字符串元素加入栈的顶部
        books.push("轻量级Java EE企业应用实战");
        //将字符串元素添加到队列的头部(相当于栈的顶部)
        books.offerFirst("疯狂Android讲义");
        //以List的方式(按索引访问的方式)来遍历集合元素
        for (int i = 0; i < books.size(); i++) {
            System.out.println("遍历中: " + books.get(i));
        }
        //访问并不删除栈顶的元素
        System.out.println(books.peekFirst());
        //访问并不删除队列的最后一个元素
        System.out.println(books.peekLast());
        //将栈顶的元素弹出“栈”
        System.out.println(books.pop());
        //下面输出将看到队列中第一个元素被删除
        System.out.println(books);
        //访问并删除队列的最后一个元素
        System.out.println(books.pollLast());
        //下面输出: [轻量级Java EE企业应用实战]
        System.out.println(books);
    }
}

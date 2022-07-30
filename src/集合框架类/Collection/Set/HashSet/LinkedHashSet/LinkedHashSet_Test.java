package 集合框架类.Collection.Set.HashSet.LinkedHashSet;

import java.util.LinkedHashSet;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/20 21:48
 * @Description： LinkedHashSet是HashSet的子类，他除了使用hashcode值来决定元素存储位置，还同时使用链表维护元素的次序，
 * 所以，Set可能是有序的，不要认为Set一定无序。
 * 这样使得元素看起来是以插入的顺序保存的。性能略低于HashSet,迭代访问Set内全部元素时有很好的性能，因为是用链表维护的。
 */
public class LinkedHashSet_Test {
    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
         books.add("疯狂张浩");
         books.add("This is a Test");
        System.out.println(books);

        books.remove("疯狂张浩");

        books.add("疯狂张浩");
        System.out.println(books);

    }
}

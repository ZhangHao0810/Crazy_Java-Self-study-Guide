package 集合框架类.Collection;
/**
 * @author ZhangHao
 * @date 2019.9.18 9:00
 * @description： 测试迭代器和增强for的使用。
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iterator_foreach_Test {
    public static void main(String[] args) {
        Collection<String> books = new ArrayList<>();

        books.add("张浩好帅啊");
        books.add("张浩要上天");
        books.add("世界第一美男子");

        //把集合全部放到迭代器当中。
        Iterator<String> iterator = books.iterator();

        while (iterator.hasNext()) {

            String book = iterator.next();
            System.out.println(book);

            if (book.equals("张浩要上天")) {
                iterator.remove();
            }

            //使用Iterator迭代过程中，不可修改集合元素，下列代码引起异常。
//			if(book.equals("张浩好帅啊")){
//				books.remove(book);
//			}

            book = "对迭代器赋值会不会改变原集合";
        }
        System.out.println(books);

        for (String str : books) {
            String str1 = str;
            if (str1.equals("张浩好帅啊")) {
                System.out.println();
                System.out.println(str1);
            }

        }

    }
}

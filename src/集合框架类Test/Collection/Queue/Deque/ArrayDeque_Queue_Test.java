package 集合框架类Test.Collection.Queue.Deque;

import java.util.ArrayDeque;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 18:22
 * @Description： ArrayDeque可以当成队列使用, 此处ArrayDeque将按“先进先出”的方式操作集合元素。
 *
 *访问或者poll都只能对队列头部（第一个插入元素）进行操作。
 *
 */
public class ArrayDeque_Queue_Test {
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        //依次将三个元素push入“栈”
        queue.offer("疯狂Java讲义");
        queue.offer("轻量级Java EE企业应用实战");
        queue.offer("疯狂Android讲义");
        //输出: [疯狂Java讲义, 轻量级Java EE企业应用实战, 疯狂Android讲义]
        System.out.println(queue);
        // 访问队列头部,但并不将其poll出队列“栈” ,输出:疯狂Java讲义
        System.out.println(queue.peek());
        //依然输出:[疯狂Java讲义, 轻量级Java EE企业应用实战, 疯狂Android讲义]
        System.out.println(queue);
        // poll出第一个元素（队列头部）,输出:疯狂java讲义
        System.out.println(queue.poll());
        //输出: [轻量级Java EE企业应用实战,疯狂Android讲义]
        System.out.println(queue);
    }
}

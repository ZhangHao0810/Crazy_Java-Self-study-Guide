package 集合框架类.Collection.Queue.Deque;

import java.util.ArrayDeque;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 18:09
 * @Description：
 * Deque:双端队列，，Stack 栈。
 * Deque接口是Queue接口的子接口,它代表一个双端队列, Deque接口里定义了一些双端队列的方法,
 * 这些方法允许从两端来操作队列的元素。
 *
 *  Deque不仅可以当成双端队列使用,而且可以被当成栈来使用,因为该类里还包含了pop (出栈),push (入栈)两个方法。
 *
 *  Deque接口提供了一个典型的实现类:
 *  ArrayDeque,从该名称就可以看出,它是一个基于数组实现的双端队列,
 *  创建Deque时同样可指定一个numElements参数,该参数用于指定ObiectI]数组的长度;
 *  如果不指定numElements参数, Deque底层数组的长度为16.
 *
 *  提示:.ArrayList和ArrayDeque两个集合类的实现机制基本相似,
 *  它们的底层都采用一个动态的、可重分配的Object]数组来存储集合元素,
 *  当集合元素超出了该数组的容量时,系统会在底层重新分配一个Object]数组来存储集合元素
 *
 *  下面程序演示了把ArrayDeque当成Stack来用。
 */
public class ArrayDeque_Stack_Test {
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();

        stack.push("11111111");
        stack.push("22222222");
        stack.push("33333333");
        System.out.println("最初："+stack);

        //访问第一个元素，但是不将他pop出栈。
        System.out.println("peek:"+stack.peek());
        System.out.println("peek后:"+stack);
        //pop出第一个元素并输出。
        System.out.println("pop："+stack.pop());
        System.out.println("pop后："+stack);

    }
}

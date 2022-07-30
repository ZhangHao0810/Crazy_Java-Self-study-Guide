package 集合框架类.Collection.Queue;

import java.util.PriorityQueue;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 16:50
 * @Description： 队列的实现类。保存元素的顺序不是按照加入的顺序，而是按照队列元素的大小进行重新排序。
 * 他已经违反了队列的最基本规则先进先出。
 *
 * 因为必须要排序，他对元素的要求与TreeSet对元素的要求基本一致。
 * 有自然排序和定制排序两种，详见TreeSet
 *
 * >自然排序:
 * 采用自然顺序的PriorityQueue集合中的元素必须实现了Comparable接口,而且应该是同一个类的多个实例,否则可能导致ClassCastException异常。
 * 定制排序:创建PriorityQueue队列时,传入一个Comparator对象,该对象负责对队列中的所有元素进行排序。
 *      采用定制排序时不要求队列元素实现Comparable接口。
 *
 */
public class PriorityQueue_Test {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();//下面代码依次向pq中加入四个元素
        pq.offer (6);
        pq.offer (-3);
        pq.offer (20);
        pq.offer (18);

        //输出pq队列,并不是按元素的加入顺序排列,也不是按照从小到大。比较混乱。
        System.out.println (pq); //输出[-3, 6, 20, 18]
        //但是反复访问队列的第一个元素,poll() 就会从小到大排序。
//        while(pq.poll()!= null)
        while (pq.size()!=0) //循环队列的时候用size，不要用Poll的返回值。
            System. out.print(pq.poll ()+" ");

        System.out.println();

        System.out.println(pq);

    }
}
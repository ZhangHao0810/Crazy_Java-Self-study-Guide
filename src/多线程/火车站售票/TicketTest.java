package 多线程.火车站售票;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 19:11
 * @Description：
 *      分析：     需要火车票总数：售出一张-1
 *                  数量<1时，停止售票
 *                  使用多线程模拟多个窗口进行售票。
 *                  火车票售完，火车站也一样开着门。
 *
 *                  static void sleep  (Long millis)  让当前线程睡一会儿。
 *
 *  synchronize 同步 （锁） 可以修饰代码块，被修饰的代码块一旦被某个线程访问了，其他的线程将无法访问。
 *
 *
 *  synchronize （锁对象） {
 *
 *  }
 *      锁对象要被所有的线程共享。
 *
 *
 *  同步：意味着安全性高，只能有一个线程参与这个事儿 效率肯定低
 *  非同步：安全性低，但是效率非常高。
 *
 *
 */
public class TicketTest {
    public static void main(String[] args) {

        TicketThread tt=new TicketThread();

        Thread t=new Thread(tt);
        t.setName("窗口1：");

        Thread t2=new Thread(tt);
        t2.setName("窗口2：");

        Thread t3=new Thread(tt);
        t3.setName("窗口3：");

        Thread t4=new Thread(tt);
        t4.setName("窗口4：");

        t.start();
        t2.start();
        t3.start();
        t4.start();


    }
}

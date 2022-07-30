package 多线程.火车站售票;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 19:15
 * @Description：  售票窗口类，用于创建售票窗口线程对象。
 *
 * synchronize （锁对象） {
 *
 *    }
 *  用同步代码块需要显式搞锁对象。
 *
 * synchronized 方法
 *      被他修饰的方法是安全的，同步的。同步方法也有锁对象
 *       非静态的同步方法锁对象是隐式的 为 This。
 *       静态的同步方法随着类的加载而加载，所以没有this。锁对象是当前类的字节码对象。
 *
 */
public class TicketThread implements Runnable {

//   火车票数量
static int tickets=100;
    Object object=new Object();

    @Override
    public void run() {
        while (true){

//  注意，在while（1） 这种粗暴的循环出现时，会引起100%Cpu占用， 电脑会卡机。只要sleep一下 即使是sleep（1） 即可解决问题。
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

/*            synchronized (object) {
                method();

            }*/

//            method();
            method2();

        }
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 20:07
     * 
     * @param 	
     * @return void
     * @Description:  抽象出来的售票功能，是同步的方法。  用同步代码块需要显式搞锁对象。
     *          非静态的同步方法也有锁对象，但是是隐式的 为 This。
     *
    */
    private synchronized void method() {
        // 当火车票还有，便售出。
        if (tickets>0) {
            /**
             * @Description: 当线程进入了判断，但是睡着了，又有别的线程进入了判断，把票取走了。
             * 这个线程醒来之后还可以接着取票，造成了负数票和重复票数（实例变量值）0的情况
            */

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+tickets--);
        }
    }


    /**
     * @author Zhanghao
     * @date 2019/10/6 20:09
     * 
     * @param 	
     * @return void
     * @Description: 抽象出来的售票功能，是同步的方法。  用同步代码块需要显式搞锁对象。
     *  静态的随着类的加载而加载，所以没有this。  静态的同步方法的锁对象是当前类的字节码对象。
    */
    private  static synchronized void method2() {
        // 当火车票还有，便售出。
        if (tickets>0) {

            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+tickets--);
        }
    }
}

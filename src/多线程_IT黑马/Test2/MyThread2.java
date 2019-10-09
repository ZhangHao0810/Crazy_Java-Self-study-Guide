package 多线程_IT黑马.Test2;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 18:41
 * @Description：
 *
 *  Thread(Runnable target)
 *  *            static Thread currentThread(); 返回当前Thread。 静态的，用类名调用。
 */
public class MyThread2 implements Runnable {

    int num;

    public MyThread2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
//            Thread thread = Thread.currentThread();
//            System.out.println(thread.getName()+":"+i);
            System.out.println(Thread.currentThread().getName()+":"+i+" "+num);
        }
    }
}

package 多线程.Test1;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 16:43
 * @Description： 多线程的实现方式1 类继承Thread ，成为线程类 线程类类调用方法，创建多个线程。
 *
 *      Thread
 *          String getName() 返回线程的名字。
 *          void setName(String name) 改变线程名字
 *
 *   CPU执行线程是随机的。
 *
 */
public class Thread_Test {
    public static void main(String[] args) {

        MyThread mt1=new MyThread();

        mt1.setName("泰勒");

        mt1.start();

        MyThread mt2=new MyThread();
        mt2.setName("洛必达");

        mt2.start();

    }


}

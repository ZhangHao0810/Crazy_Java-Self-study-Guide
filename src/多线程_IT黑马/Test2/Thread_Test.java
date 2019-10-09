package 多线程_IT黑马.Test2;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 18:44
 * @Description： 多线程的实现方式2：创建实现Runnable接口的类，将类实例作为创建Thread的参数。用thread对象来操作。
 *          Thread(Runnable target)
 *            static Thread currentThread(); 返回当前Thread。 静态的，用类名调用。
 *
 *            多线程的魅力之处在于他不是按照代码顺序来的，而是cpu的调用顺序。
 *              Mian线程总是第一个被调用，但不一定第一个全部执行完
 *                  一定要理解好多线程和普通程序（单线程）的执行关系。
 *
 *   既然有了继承Thread 为何还要整出来实现Runnable接口呢？？
 *          Java继承的特点：单一继承。
 *              Java利用实现接口的方式，来实现多线程，这样类就能继承其他的类了。
 *
 *              推荐使用实现Runnable接口，因为这样就再能继承其他类了。
 *
 *
 */
public class Thread_Test {

    public static void main(String[] args) {


        Thread t=Thread.currentThread();
        t.setName("Main线程：");
        System.out.println(t.getName());

        method();
        System.out.println("===================================================");
        method2();
        System.out.println("Test");
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 18:59
     *
     * @param
     * @return void
     * @Description:         //共享了Runnable对象，成员是共享的。
    */
    private static void method2() {
        MyThread2 mt=new MyThread2(100);
        Thread t=new Thread(mt);
        t.setName("hongtu");

        t.start();

        Thread t2=new Thread(mt);
        t2.setName("xioaying");

        t2.start();
    }

    /**
     * @author Zhanghao
     * @date 2019/10/6 18:58
     *
     * @param
     * @return void
     * @Description:  两个Runnable对象，成员不共享。
    */
    private static void method() {

        MyThread2 mt=new MyThread2(100);
        Thread t=new Thread(mt);
        t.setName("Lisi");

        t.start();

        MyThread2 mt2=new MyThread2(200);
        Thread t2=new Thread(mt2);
        t2.setName("wangwu");

        t2.start();
    }
}

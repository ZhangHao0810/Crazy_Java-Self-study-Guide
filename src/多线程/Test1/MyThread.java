package 多线程.Test1;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 18:30
 * @Description：
 *   *      Thread
 *  *          String getName() 返回线程的名字。
 *  *          void setName(String name) 改变线程名字
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}

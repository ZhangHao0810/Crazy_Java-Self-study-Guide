package 反射.Method;

/**
 * @author ZhangHao
 * @date 2019/10/9 17:22
 * @Description： 人
 */
public class Person extends Animal{

    Person(){
        System.out.println("我是无参");
    }

    Person(String s) {
        System.out.println(" 我是带参数的构造方法哦 ");
    }

    public void eat() {
        System.out.println("eat");
    }

    public  String eat(String s){
        System.out.println("eat带参数的方法");

        return "wa hahah "+s;
    }

    private void testPtivate(){
        System.out.println("Private 方法哦");
    }
}

package 反射_渡一教育.IOC;

/**
 * @author ZhangHao
 * @date 2019/10/9 18:56
 * @Description： 测试我的简单的Spring ioc
 */
public class TestMain {
    public static void main(String[] args) {
//        想要创建Question类型的对象，将对象的控制权交给MySpring类管理，IOC 控制权反转思想
        MySpring mySpring = new MySpring();
/*        Question question = (Question) mySpring.getBean("反射_渡一教育.IOC.Question");
        System.out.println(question);*/
        Person person = (Person) mySpring.getBean("反射_渡一教育.IOC.Person");
        System.out.println(person);


    }
}

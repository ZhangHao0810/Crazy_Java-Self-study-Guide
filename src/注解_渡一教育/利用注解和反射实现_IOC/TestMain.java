package 注解_渡一教育.利用注解和反射实现_IOC;

/**
 * @author ZhangHao
 * @date 2019/10/10 19:12
 * @Description： 测试类
 */
public class TestMain {
    public static void main(String[] args) {

/*        *//** 2019/10/10 19:15
         * 获取Person类型的对象。
        *//*

        Person p=new Person();
        p.setName("ZhangHao");
        p.setAge(18);
        p.setSex("男");

       Person p=new Person("ZhangHao",19,"男");*/

        MySpring2 ms=new MySpring2();
        Person p = (Person) ms.getBean("注解.IOC.Person");

        System.out.println(p);

    }
}

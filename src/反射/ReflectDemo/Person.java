package 反射.ReflectDemo;

/**
 * @author ZhangHao
 * @date 2019/10/9 7:47
 * @Description： 用作反射测试的  类
 */
public class Person extends Animal{
/*    public Person(int a) {

    }*/

    public String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

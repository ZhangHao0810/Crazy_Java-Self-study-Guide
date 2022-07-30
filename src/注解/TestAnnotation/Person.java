package 注解.TestAnnotation;

/**
 * @author ZhangHao
 * @date 2019/10/10 14:38
 * @Description： 子类
 */
public class Person extends Animal {


    @Override
    public void eat() {
        System.out.println("子类重写的eat方法！！！");
    }

    public void eat(String d) {

    }
}

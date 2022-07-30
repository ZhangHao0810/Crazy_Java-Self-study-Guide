package 反射.Method;

import java.lang.reflect.Constructor;

/**
 * @author ZhangHao
 * @date 2019/10/9 18:17
 * @Description： 利用反射查看和操作构造方法。
 */
public class TestConstructor {
    public static void main(String[] args) throws NoSuchMethodException {
        try {
            Class clazz = Person.class;

            /** 2019/10/9 18:25
             * 获取构造方法。
             * 和method相同哦 全都一样呢
            */
            Constructor constructor = clazz.getConstructor();
            clazz.getConstructors();
            clazz.getDeclaredConstructor();
            clazz.getDeclaredConstructors();

            constructor.getModifiers();
            constructor.getName();
            constructor.getExceptionTypes();
            constructor.getParameterTypes();

            /** 2019/10/9 18:22
             * 执行构造方法:
             * Object= newInstance(执行构造方法时的所有参数);和执行method的invoke区就是无需传对象。
            */
            Person p = (Person) constructor.newInstance("name");
            System.out.println(p);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

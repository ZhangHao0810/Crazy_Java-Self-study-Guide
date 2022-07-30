package 反射.Method;

import java.lang.reflect.Method;

/**
 * @author ZhangHao
 * @date 2019/10/9 17:22
 * @Description： 用反射来操作方法。
 */
public class TestMethod {
    public static void main(String[] args) {


        Class<Person> personClass = Person.class;
        try {
            /** 2019/10/9 17:27
             * 获取方法。
             *  getMethod（"方法名”，参数类型......） 获得公有的自己类和父类的。
             *  Method[]=getMethods();获取所有公有的方法，自己和父类的。
             *  获取私有的方法和之前的获取私有属性一样哦，easy
             */
//        通过方法名字定位方法，再通过方法参数类型对应的Class来找，没有参数类型 就空着
            Method method = personClass.getMethod("eat");


            /** 2019/10/9 17:54
             * 获取方法的信息。
            */
            int modifiers = method.getModifiers();
//            获取返回值类型。
            Class<?> returnType = method.getReturnType();
            String name = method.getName();
//            获取方法参数列表的类型
            Class<?>[] parameterTypes = method.getParameterTypes();
//            获取方法抛出异常的类型。
            Class<?>[] exceptionTypes = method.getExceptionTypes();

            /** 2019/10/9 17:36
             * 操作方法，执行。
             *  要传参或者接受返回值。返回值为了通用是Object类型的。
             *  invoke(对象，执行方法需要传递的所有参数......)
            */
//            通过方法名字定位方法，再通过方法参数类型对应的Class来找
            Method m = personClass.getMethod("eat",String.class);
            Person p = personClass.newInstance();
            String result = (String) m.invoke(p,"1234");
            System.out.println(result);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

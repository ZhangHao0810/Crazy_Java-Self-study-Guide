package 反射_渡一教育.ReflectDemo;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author ZhangHao
 * @date 2019/10/9 7:48
 * @Description： 测试Class类中的方法。
 */
public class TestReflect {

    /**
     * @Description: 通过反射找到类，类名，包，超类和接口。
     * @author ZhangHao
     * @CreateDate: 2019/10/9 8:14
     */
    private static void introduction() {

        try {

            /** 2019/10/9 7:49
             * 通过Class对象来操作Person.class 类文件，与硬盘产生映射关系。找到类文件，赋值给Class对象。
             * 通过字符串来找，容易拼错，要抛出类找不到异常。
             */
            Class<?> clazz = Class.forName("反射_渡一教育.ReflectDemo.Person");

            /** 2019/10/9 7:54
             * 获取类的修饰符，（权限，特征）等
             *   返回int型，对每一个修饰符，用一个整数来进行表示，若有多个修饰符，则求和
             *       0  1  2  4 8 16 32 64  128 256 512
             *       0-- 默认不写，1-- public，2--private，3--protect，4--protected，8-- static ，16-- final，
             *       32--synchronize， 64-- volatile  这俩都是修饰属性的。
             *       128-- transient 代表瞬时，修饰了之后不被写入到文件里，对象序列化用到 不常见。
             *       256--native 本地的 不是java代码
             *       512-- interface
             *       1024-- abstract
             */
            int modifiers = clazz.getModifiers();
            System.out.println(modifiers);

            /** 2019/10/9 8:04
             * 类的名字
             */
            String name = clazz.getName();
            String simpleName = clazz.getSimpleName();
            //类全名
            System.out.println(name);
            //类名
            System.out.println(simpleName);
            System.out.println("===============================");

            /** 2019/10/9 8:07
             * 获取类所在的包,用Package类型对象接住，基本上功能就是获取包名。
             */
            Package aPackage = clazz.getPackage();
            System.out.println(aPackage.getName());
            System.out.println("===============================");


            /** 2019/10/9 8:22
             * 通过类名直接获取Class
             * 通过反射和循环，获得类的所有超类和实现的接口。
             */
//        获取Class，用类名来找，不会拼错，所以不必抛出异常。
            Class<ArrayList> arrayListClass = ArrayList.class;
//        获取父类。赋值给Class变量。
            Class<? super ArrayList> superclass = arrayListClass.getSuperclass();
//        用循环反复赋值得到所有父类。
            while (superclass != null) {
                System.out.println(superclass.getName());
                superclass = superclass.getSuperclass();
            }
            System.out.println("++++++++++++++++++++++++++++++++++");
//        获取所有接口，用增强for循环。
            Class<?>[] interfaces = arrayListClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                System.out.println(anInterface.getName());
            }

            /** 2019/10/9 8:40
             * 利用newInstance()来创造对象，返回值是Object类型。要转换。
             * 相当于调用了person类中的默认无参数构造方法创造对象
             */
            Person p = (Person) clazz.newInstance();
            System.out.println(p);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        introduction();

        try {
            Class<?> aClass = Class.forName("反射_渡一教育.ReflectDemo.Person");

            /** 2019/10/9 8:44
             * 通过class 类对象来获取类的属性，赋值给了Field对象。,返回值是Field。抛出NoSuchFieldException
            */
//            知道属性名，而且公有。 getField
            Field nameField = aClass.getField("name");
//           当不知道属性名的时候， 一次性获得所有公有属性(包含他继承自父类的属性。)  getFields 得到数组，总有我要的，循环判断即可。
            Field[] fields = aClass.getFields();
            System.out.println("该类的公有属性数量："+fields.length);

            /** 2019/10/9 9:16
             * 得到属性信息
            */
//            获取属性的修饰符
            int modifiers = nameField.getModifiers();
            System.out.println("属性的修饰符标号为："+modifiers);
//            获取属性的类型,返回一个Class类型的对象。该对象getName便得到该属性的类型。
            Class<?> type = nameField.getType();
            System.out.println(type.getName());
//            获取属性的名字
            String name = nameField.getName();
            System.out.println("获取属性的名字:"+name);

            /** 2019/10/9 9:09
             * 操作属性。
             *  之前的操作都是查看，不需要对象 只有class模板即可
             *  因为得到了类对象，用它得到了属性对象，所以可以用属性对象来操作属性。
             *          因为反射的机制是，先找到 类，（进而找到属性），再找到对象的，对象是较低的层次，是由广到窄的。
             *          原先是 值=对象.属性，现在是  sth=属性.(对象，值）
             *  操作属性，因为每一个对象都有相同的属性，所以要确定好对象再操作。可以自己new 类名(); 也可以用反射newInstance()
            */
//          给具体对象的属性赋值（new） set
            Person person = new Person();
            nameField.set(person,"ZhangHao");
            System.out.println(person);
//          给具体对象的属性赋值（newInstance）
            Person p = (Person) aClass.newInstance();
            nameField.set(p,"反射");
            System.out.println(p);

//          取具体对象的值 get
            String pname = (String) nameField.get(p);
            System.out.println(pname);


            /** 2019/10/9 10:12
             * 操作私有属性 牛逼！！避开了封装
             */
            Person man = new Person();

//          利用反射获取私有的属性！！但也只是能找到。
            Field age = aClass.getDeclaredField("age");
//          类似getFields() 这个能获得所有的属性牛逼的是还能获得私有的。
//              但是只能获取本类的，不能获取父类的。（想获得父类私有，先通过当前类获得父类，再用父类操作私有。）
            Field[] declaredFields = aClass.getDeclaredFields();

            System.out.println("私有的属性名称："+age.getName());
//          设置私有属性Accessible,如果不设置只能得到名字，连值都得不到。否则抛出IllegalAccessException: Class 反射_渡一教育.Reflect.TestReflect can not access a member of class 反射_渡一教育.Reflect.Person with modifiers "private
            age.setAccessible(true);
            System.out.println("私有属性的原值："+age.get(man));
            age.set(man,18);
            int value= (int) age.get(man);
            System.out.println("更改之后私有属性的值："+value);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}

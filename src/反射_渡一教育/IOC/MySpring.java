package 反射_渡一教育.IOC;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author ZhangHao
 * @date 2019/10/9 18:44
 * @Description： 本程序提供了一个方法，输入参数(参数是类)便可以将任何类型的参数转化成对应的对象，
 *                  而且这个对象中还有内容。
 *
 *
 * 模拟简单的Spring框架的IOC思想，帮我控制对象的创建
 *  1.是否需要参数？   String 类全名
 *  2.是否需要返回值？  返回一个Object对象。
 *      如果能在创建对象的同时能够为对象内的属性赋值就好了 这就叫 DI 依赖注入。
 *
 *      IOC 控制反转：别人帮我创建对象
 *           DI 依赖注入：对象的控制权是别人的，别人创建对象的同时可以帮我们自动的注入属性值。
 *              DI是IOC的具体体现。
 *
 *      AOP 面向切面编程。
 *
 *  本程序缺点，待处理：
 *  利用的是Scanner 从控制台读文本，可以把参数放进文本，利用IO循环赋值！！
 *      使用的时候调用含参构造，new 即可创建好对象。
 *
 *   若属性是char（唯一一个包装类没有带String参数构造方法的）不可行，单独处理即可
 *   属性是对象，集合类等，不可行 (但是在实体类中较为少见)
 *
 */
public class MySpring {

    public MySpring() {
    }

    public MySpring(String className) {

    }

    public Object getBean(String className){
//        因为try了之后就没有了。所以要定义一个try外面的变量
        Object obj=null;
        Scanner input = new Scanner(System.in);
        System.out.println("请给"+className+"类的对象赋值~");

        try {
//            获取传进来参数对应的类映射。
            Class<?> clazz = Class.forName(className);
//            通过clazz创建对象。
            obj = clazz.newInstance();
//            在这里做一个自动DI注入，对象中的所有属性值。找寻属性的Set方法来赋值
//            找到每个不同对象中的Set方法，循环给属性赋值。
//            自己可以通过拼接字符串的方式赋值。
//            1.找所有的私有属性--》获取每一个属性的名字。--》处理Set属性。
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                String name = field.getName();
//            2.手动拼接字符串，拼接属性对应的set方法名， setTitle，setAnswer
//                将属性的首字母大写。
                String firstLetter = name.substring(0, 1).toUpperCase();
//                获得属性除首字母之外的其他字母
                String otherLetters = name.substring(1);

                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstLetter);
                setMethodName.append(otherLetters);
//            3.获取field对应的属性类型，-->找寻set方法时候传递参数用。
                Class<?> type = field.getType();
//            4.通过处理好的set方法名，找寻类中的set方法
                Method setMethod = clazz.getMethod(setMethodName.toString(),type);
//            5.执行属性对应的set方法，属性就赋值成功了。
                System.out.println("请给"+name+"属性赋值~~>-<");
                String value=input.nextLine();
//                属性的值现在接收过来的（Scanner 文件内读取）全都是String类型。
//                执行set方法的时候，方法需要的值不一定都是String。值的类型应该是属性的类型。
//              如何将所有String类型的值转化成属性类型的值？
//                八个包装类 有七个都含有带String的构造方法。除了char
//                  new Integer（String） new Float（String）new String（String）
//              可以利用包装类带String的构造方法处理。属性类型对应的带String参数的构造方法。
                Constructor<?> constructor = type.getConstructor(String.class);
                setMethod.invoke(obj,constructor.newInstance(value));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  obj;

    }
}

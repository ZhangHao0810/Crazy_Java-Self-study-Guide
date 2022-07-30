package 注解.利用注解和反射实现_IOC;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ZhangHao
 * @date 2019/10/10 17:36
 * @Description： 用注解方式写的简单Spring
 *
 * 设计一个方法，参数是字符串（类名）  给一个类名字（全地址），返回对象，对象内的属性值存着值。
 *
 *  和反射的MySpring功能一致，但是利用了注解的方式进行信息输入。 而非Scanner。
 *
 */
public class MySpring2 {

    public Object getBean(String className) {
        Object obj=null;

        try {

            /** 2019/10/10 17:42
             * 通过传递的className 获取对应的类Class
             */
            Class<?> aClass = Class.forName(className);

            /** 2019/10/10 17:43
             * 通过aClass 创建一个空的对象。 这一步就是IOC 控制反转
             *  通过构造方法来做。训练一下反射构造方法。而且注解是放在构造方法上的，之后好获取注解内容。
             *
             *   obj=aClass.newInstance(); 前提是有无参的构造。
             *
             *   aClass.getConstructor(); 可以传参 找到有参的构造方法。
             *   再用这个Constructor来创建对象。
            */
            Constructor<?> constructor = aClass.getConstructor();
            obj = constructor.newInstance();

            /** 2019/10/10 17:52
             * 创建对象之后，对象内的所有属性自动赋值。 这一步就是DI 依赖注入
             *  值 --》文件  .xml  .properties
             *      代码包装起来不可修改。.jar 不可修改，但是独立的文件可以修改。
             *      但是开发的时候源代码和配置文件读取/修改 比较麻烦。
             *  值 --》注解  @
             *      开发的时候方便，源代码和注解在一起，读取/调整 比较容易
             *      但是包装起来之后，注解内携带的信息不可修改。
             *
             *  之前的框架我们都是面向文件开发的，但是项目上线文件配置好之后通常没有人去修改，信息存到文件的好处就浪费了。
             *
            */

            /** 2019/10/10 18:02
             * 获取属性的值。------》从类的无参数构造方法上的注解中。
             * 这个是关键哦，从Scanner 还是文件 还是注释，就是这里有大不同。
             *    尝试改进：  可以利用文件输入流一行行读，可以自己解析。可以利用Properties来读。
             *
            */
            Annotation annotation = constructor.getAnnotation(MyAnnotation.class);
            Class<? extends Annotation> aClass1 = annotation.getClass();

            Method aMethod = aClass1.getMethod("value");
            //获得 invoke 是获得的意思。所有注释的信息。
            String[] values = (String[]) aMethod.invoke(annotation);

            /** 2019/10/10 18:36
             * 将注释的值对应赋值。
             *  获取私有属性的名字
             *  拼接字符串。
             *  找寻属性对应的set方法来操作。 利用反射找方法！！ 一定要熟练反射的基本操作。
            */
            Field[] fields = aClass.getDeclaredFields();
            for (int i=0;i<fields.length;i++) {
                String fieldName = fields[i].getName();
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String otherLetter = fieldName.substring(1);

                StringBuilder set = new StringBuilder("set");
                set.append(firstLetter);
                set.append(otherLetter);

                Class<?> fieldType = fields[i].getType();
                Method setMethod = aClass.getMethod(set.toString(),fieldType);
//                执行方法的应该是该方法所在类的对象。
//                并且方法的参数要正确！！赋值正确和类型正确。
//                需要将注解内读取到的String类型的值，转化成属性类型的值。
//      但是char类型的读不到，如果属性是char类型的，集合类型，数组类型，对象类型，则单独处理。
//                反射的method 调用它的invok 方法来执行。
                setMethod.invoke(obj,fieldType.getConstructor(String.class).newInstance(values[i]));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}

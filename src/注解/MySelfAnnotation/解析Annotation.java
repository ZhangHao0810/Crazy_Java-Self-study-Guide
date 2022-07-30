package 注解.MySelfAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ZhangHao
 * @date 2019/10/10 15:47
 * @Description：  利用反射解析我的自定义注解。
 *
 *      获取注解的内容。
 */



public class 解析Annotation {
    public static void main(String[] args) {

        getFieldAnnMessage();

        getAnnMethodMessage();

    }

    /**
     * @author Zhanghao
     * @date 2019/10/10 16:42
     *
     * @param
     * @return void
     * @Description: 获取类的属性上面的注解信息。
    */
    private static void getFieldAnnMessage() {
        try {
            /** 2019/10/10 16:08
             * 为了更好的理解注解
             * 解析Person类中 属性上面的注解信息。
             */

//        获取Preson 对象的类Class
            Class<Person> personClass = Person.class;
//        获取类的具体属性name
            Field field = personClass.getDeclaredField("name");


//        获取name属性上面的注解对象。
            Annotation ann = field.getAnnotation(MyAnnotation.class);

/* //        用注解对象获取他对应的class，进而得到注解类。 即对注解进行反射。
            Class<? extends Annotation> aClass = ann.getClass();
            Method amethod = aClass.getMethod("value");*/

            Method method = MyAnnotation.class.getMethod("value");

            String[] values = (String[]) method.invoke(ann);
            for (String value : values) {
                System.out.println(value);
            }


/*//        获取属性上面的注解对象。
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
//        利用a对象执行value方法，就把信息搬运过来了
            String[] value = annotation.value();
            System.out.println(value[0]);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 2019/10/10 17:26
     * 获取方法上面的的注解信息。
     */
    private static void getAnnMethodMessage() {
        try {
            /** 2019/10/10 16:43
             * 利用反射 获取Person类中方法上面的注解信息。
             */
            Class<?> bClass = Class.forName("注解.MySelfAnnotation.Person");
            Method eatmethod = bClass.getMethod("eat");

            Annotation annotation = eatmethod.getAnnotation(MyAnnotation.class);

            Method annmethod = annotation.getClass().getMethod("value");

            String[]  values = (String[]) annmethod.invoke(annotation);
            for (String arg : values) {
                System.out.println(arg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

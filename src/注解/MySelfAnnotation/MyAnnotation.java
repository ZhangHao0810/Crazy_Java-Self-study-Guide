package 注解.MySelfAnnotation;

import java.lang.annotation.*;

/**
 * @author ZhangHao
 * @date 2019/10/10 15:13
 * @Description： 我自己定义的注解
 */

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {

 //    静态常量属性。注解中几乎用不到。

    String test="sdf";


    //注解方法必须要有返回值 且跟接口的类型要求一致。public abstract
//    void test();


    String[] value() default  "默认值";

//    String[]  vlaue();
}

package 注解.TestAnnotation;

import java.util.Date;

/**
 * @author ZhangHao
 * @date 2019/10/10 14:33
 * @Description： 测试注解的使用
 */
public class TestAnnotation {
    public static void main(String[] args) {

        Date date=new Date();

//        过时的方法上面会有注解：@Deprecated 用来充当注释的作用，是个文字说明。
        date.getYear();


//Eclipse 的警告提示多一些。下方就会警告变量没有被使用。
        String str="abc";
        @SuppressWarnings("")
        String str2="asdf";
    }
}

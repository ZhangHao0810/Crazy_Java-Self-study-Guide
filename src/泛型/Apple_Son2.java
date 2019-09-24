package 泛型;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/24 21:54
 * @Description：
 */
public class Apple_Son2 extends Apple {
    public String getInfo(){
        //因为super.getInfo()的返回值是Object 类型， 所以要加toString()
        return super.getInfo().toString();
    }
}

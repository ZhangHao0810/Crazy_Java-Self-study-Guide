package 泛型;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/24 21:51
 * @Description： 从泛型类派生子类。
 */
public class Apple_Son extends Apple<String> {

    public String getInfo(){
        return "子类"+super.getInfo();
    }

//    重写父类方法的时候返回值类型不一致，所以是错误的。
//    public Object getInfo(){
//        return "子类" ;
//    }
}

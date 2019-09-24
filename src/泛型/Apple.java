package 泛型;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/24 21:36
 * @Description： 可以为任何类、接口添加泛型声明。
 */
public class Apple<T> {

    private T info;
    public Apple(){}

//  构造器名不应该加<> 但是调用的时候却可以使用<>的形式。
    public Apple(T info){
        this.info=info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }


    public static void main(String[] args) {
        Apple<String> al=new Apple<>("苹果");//因为T的形参是String， 所以构造器参数只能是String
        System.out.println(al.getInfo());

        Apple<Double> a2= new Apple<>(654.5);
        System.out.println(a2.getInfo());
    }
}

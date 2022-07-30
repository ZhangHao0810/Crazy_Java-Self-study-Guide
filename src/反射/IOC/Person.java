package 反射.IOC;

/**
 * @author ZhangHao
 * @date 2019/10/9 19:08
 * @Description： 另一个类
 */
public class Person {
    private  String name;
    /** 2019/10/9 19:56
     * 以后在写实体对象（只用于存储信息的，信息一般在文件里或者数据库里）的时候
     *      尽量写int的包装类，因为int 不那么安全。
     *      因为数据库中可能这个字段存的是null，而null不能赋值给基本类型，null可以赋值给引用类型，基本类型的包装类型。
     *      而且效率上现在包装类和基本类在底层运算上没有什么区别
     *
     *      //    private  int age ;
    */
    private  Integer age;
    private  String gender;

    public Person() {
    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

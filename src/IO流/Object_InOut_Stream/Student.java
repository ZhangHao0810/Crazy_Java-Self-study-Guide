package IO流.Object_InOut_Stream;

import java.io.Serializable;

/**
 * @Auther： ZhangHao
 * @Date： 2019/10/6 9:03
 * @Description：
 *  当类发生变化，
 *  类没有明确指定serialVersionUID，序列化的时候会默认根据字段和特定的算法生成一个serialVersionUID，
 *  当属性有变化时这个id发生了变化，所以反序列化的时候就会失败。
 *  抛出“本地classd的唯一id和流中class的唯一id不匹配”
 *          java.io.InvalidClassException: IO流.Object_InOut_Stream.Student; local class incompatible:
 *
 *  所以为了防止这个异常，最好手动指定final的UID。 用IDEA的插件即可。
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 5889928866258503837L;
    String name;
    int age;
//    String gender;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

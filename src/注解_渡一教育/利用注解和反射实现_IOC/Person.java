package 注解_渡一教育.利用注解和反射实现_IOC;

/**
 * @author ZhangHao
 * @date 2019/10/10 16:07
 * @Description：
 */
public class Person {




    private String name;
    private Integer age;
    private String sex;

    @MyAnnotation({"Zhanghao","18","男神"})
    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}


package 单元测试Test;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/19 9:41
 * @Description：建立要进行单元测试的方法的类。
 */
public class Student {
    private String name;
    private int id;
    private double score;

    Student(String name,int id,double score){
        this.id=id;
        this.name=name;
        this.score=score;
    }


    public void testJUnitGenerator_V2_0(){
        System.out.println("66666666666666666666");
    }




    public int testmethod (String name,int id) {
        System.out.println("name=" + name);
        id += 1;
        System.out.println("changed id =" + id);
        return id;
    }


}

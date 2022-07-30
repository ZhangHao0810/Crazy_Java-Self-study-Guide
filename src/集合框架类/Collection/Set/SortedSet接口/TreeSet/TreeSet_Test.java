package 集合框架类.Collection.Set.SortedSet接口.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/20 23:19
 * @Description：
 * TreeSet是SortedSet接口的实现类，他可以确保集合处于排序状态。
 * 他不是根据元素插入顺序进行排序的，而是根据元素实际值的大小进行排序的。
 * TreeSet支持自然排序和定制排序。
 *
 * 1.自然排序，
 * 要求待插入对象的类 实现 Comparable 接口，重写compareTO（Object obj）方法。返回一个整数值。
 * 实现了该接口的类的对象就可以比较大小。  obj.compareTo(obj2);
 * 返回0表示相等，返回正整数，表明obj1>obj2 。返回负整数，表明obj1<obj2
 * 包装类，Character 按字符的UNICODE值进行比较。
 * Boolean true>false
 * String 字符串的字符的Unicode
 * Date、Time 后面的时间，日期比前面的时间，日期大。
 *
 * 如果试图把对象添加到TreeSet，则对象的类必须实现Comparable接口，否则会报错。
 *
 * TreeSet的自然排序是升序排列。
 * 与HashSet类似的是，TreeSet包含了可变对象，当可变对象的实例被修改时
 * 会非常复杂。不要修改放入HashSet和TreeSet集合元素中的关键实例变量
 *
 * 2.定制排序，需要在创建TreeSet集合对象时，提供一个Comparator对象与 该TreeSet集合关联
 * 由Comparator对象负责集合元素的排列逻辑。Comparator是一个函数式接口。实现类的对象类似表达式。
 * TreeSet<Employee> employees = new TreeSet<> (comparator对象);
 */

public class TreeSet_Test  {


    /**
     * @author Zhanghao
     * @date 2019/9/21 16:19
     *
     * @Description:  要学会解耦。
    */

    /**
     * @author Zhanghao
     * @date 2019/9/21 17:01
     *
     *
     * @Description: 自然排序。
     * 让需要排序的类实现comparable接口，在其中重写compareTo（T  o）方法，并在其中定义排序规则，就可以直接用集合框架类来排列对象
     *
     * 用comparable的好处在于，直接在对象中就定义了排序的规则，不用再重新重新写比较器的实现类
    */
    public static void ZIRANSort(){
        TreeSet set1 = new TreeSet();
        Employee z1 = new Employee("1",6);
        set1.add(z1);
    //第二次添加同一个对象。add返回true/false 表示成功与否，这里是true
        //因为对象重写的的compareTo方法永远返回true，连自己都不相等，所以可以添加两个所谓相同的元素，
        //这就是comparable接口的好处，在创建集合框架类对象的时候，就利用加入对象的类的compareTo方法的内容定义好规则了。
        System.out.println(set1.add(z1));
    //下面将看到两个元素。
      System.out.println(set1);
    //修改第一个元素的age变量。
        ((Employee)(set1.first())).age = 9;
    //输出最后一个元素的age，将看到最后一个元素的age也变了。所以这两个元素实际上是同一个。所以添加重复元素只留一个，set的唯一性。
        System.out.println(((Employee)(set1.last())).age);

}

    /**
     * @author Zhanghao
     * @date 2019/9/21 17:39
     *
     * @Description: 创建Comparator比较器 可以用于对本身不支持排序的实体类进行排序。
     *
     * 实现Comparator接口的类的实例对象，他负责集合元素的排列逻辑。
     * Comparator是一个函数式的接口，所以他的对象可以用Lambda表达式来代替这个Comparator比较器。
     * 他是一个final类型的东西。
     */
    private static final Comparator<Employee> comparator = new Comparator<Employee>() {


        /**
         * @author Zhanghao
         * @date 2019/9/21 17:55

         * @Description: 本身的话，int compare（T o1,To2）函数是比较o1,o2的大小， 如果返回负值则意味着o1比o2小；否则o1等于o2；返回正值则意味着o1比o2大
         * 重写后的compare方法，返回的值若与原来的compare(T o1,T o2)函数同正负号则是升序排列，若正负号相反则降序排列
        */
        @Override
        public int compare(Employee o1, Employee o2) {
            int cr = 0;

            //按年龄降序排列
            int a = o1.getAge() - o2.getAge();
            if (a != 0)
                cr = (a > 0) ? -1 : 1;

            return cr;

        }
    };

    public static void main(String[] args) {
        ZIRANSort();

        TreeSet<Employee> employees = new TreeSet<> (comparator);

        employees.add(new Employee("zhangsan",18));
        employees.add(new Employee("lisi",80));
        employees.add(new Employee("wangwu",25));


        System.out.println(employees);

    }


}







package 集合框架类Test.Collection.Set.TreeSet;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/21 16:33
 * @Description： 用于测试TreeSet的类
 */
public class Employee implements Comparable {

        int age;
        String name;

        public Employee(String name,int age){
            this.name = name;
            this.age = age;
        }

        @Override//总是相等。
        public boolean equals(Object obj) {
            return false;
        }

        /**
         * @author Zhanghao
         * @date 2019/9/20 23:30
         *
         * @param o
         * @return int
         * @Description:
         * 重写compareTo(Object o) 时，应保持与hashCode()以及equals()的相同性判断保持一致！
         *  TreeSet判断两个对象相等的唯一标准就是：compareTo方法。
         *  首先按照compareTo()进行比较，一旦返回0，程序会认为这两个对象是相同的，进而后一个对象就不能添加进来。
         *
         *  obj.compareTo(obj2);
         * 返回0表示相等，返回正整数，表明obj1>obj2 返回负整数，表明obj1<obj2
         *
         * 我们必须对他进行重写，因为他的Super Method在Comparable接口中。
         * 比如String的比较就是重写了CompareTo()，它从第一位开始比较，遇到不同的字符，马上返回两字符的ASCII差值（int）。
         *
         */
        @Override//总是返回1，所以自己和自己也不相等。与equals方法结果不同
        public int compareTo(Object o) {
            return 1;
        }

        @Override
        public String toString() {
             return "Emp对象（姓名:"+name+"  年龄："+age+")";
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
}



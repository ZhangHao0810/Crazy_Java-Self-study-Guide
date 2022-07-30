package 集合框架类.Collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/24 20:49
 * @Description： 演示Collections类提供的用于查找，替换集合元素的类方法。
 *
 * 非常的吊，要会用，常看JavaAPI，不要重复造轮子。
 */
public class Collections_SearchTest {
    public static void main(String[] args) {
        ArrayList nums=new ArrayList();
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(0);
        nums.add(-9);
        nums.add(5);

        System.out.println(nums);

        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));
        Collections.replaceAll(nums,0,1);
        System.out.println(nums);

        System.out.println(Collections.frequency(nums,3));
        Collections.sort(nums);
        System.out.println(nums);

        System.out.println(Collections.binarySearch(nums,3));
    }
}

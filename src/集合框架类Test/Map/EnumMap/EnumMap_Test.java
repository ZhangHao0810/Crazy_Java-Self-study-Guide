package 集合框架类Test.Map.EnumMap;

import java.util.EnumMap;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 21:42
 * @Description：
 * 所有的key得是单个枚举类的枚举值
 */

enum Season {
    SPRING,SUMMER,FALL,WINTER
}

public class EnumMap_Test {
    public static void main(String[] args) {
        EnumMap enumMap = new EnumMap(Season.class);

        enumMap.put(Season.SUMMER,"烈日炎炎");
        enumMap.put(Season.SPRING,"春暖花开");

        System.out.println(enumMap);
    }
}

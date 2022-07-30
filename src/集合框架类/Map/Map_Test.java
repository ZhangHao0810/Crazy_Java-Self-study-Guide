package 集合框架类.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/22 19:39
 * @Description：
 */
public class Map_Test {

    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("1",109);
        map.put("2",10);
        map.put("3",8);
        System.out.println(map);
        //put重复的Key，新的value会覆盖旧的，并且返回被覆盖的value
        System.out.println(map.put("1",88));
        System.out.println(map);

        System.out.println("是否包含值为2的key："+map.containsKey("2"));
        System.out.println("是否包含值为8的value："+map.containsValue(8));

        //获取Map集合所有的Key组成的集合。通过遍历key来实现遍历所有的key-value对。
        for (Object key :map.keySet()) {
            //map.get(key)方法获取指定的key对应的value
            System.out.println(key+"--->"+map.get(key));
        }

        map.remove("1");
        System.out.println(map);


    }
}

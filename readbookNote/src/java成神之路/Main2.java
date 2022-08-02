package java成神之路;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @date 2021/12/22 4:03
 */
public class Main2 {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(1,0);
        map.put(5,0);
        map.put(10,0);

        System.out.println(map);
    }
}

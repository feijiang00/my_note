package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2022/1/13 10:37
 */
public class Q50_第一个只出现一次的字符 {

    class Solution {
            /*
            使用哈希表
             */
            public char firstUniqChar(String s) {
                Map<Character, Integer> frequency = new HashMap<Character, Integer>();
                for (int i = 0; i < s.length(); ++i) {
                    char ch = s.charAt(i);
                    frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
                }
                for (int i = 0; i < s.length(); ++i) {
                    if (frequency.get(s.charAt(i)) == 1) {
                        return s.charAt(i);
                    }
                }
                return ' ';
            }
    }
}

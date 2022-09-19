package 剑指offer;

/**
 * @date 2022/1/10 11:03
 */
public class Q58_II_左旋转字符串 {

    class Solution {
        public String reverseLeftWords(String s, int n) {
            /*
            StringBuilder遍历追加
             */
            StringBuilder sb = new StringBuilder();
            for (int i=n;i<s.length();i++){
                sb.append(s.charAt(i));
            }
            for(int i=0;i<n;i++){
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}

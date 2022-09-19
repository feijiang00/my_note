package 剑指offer;

/**
 * @date 2022/1/4 23:36
 */
public class Q05_替换空格 {

    class Solution {
        public String replaceSpace(String s) {
            /*
            这种作弊行为，我肯定是不会干滴
             */
//            return s.replace(" ","%20");
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == ' ')
                    stringBuilder.append("%20");
                else
                    stringBuilder.append(s.charAt(i));
            }
            return stringBuilder.toString();
        }
    }
}

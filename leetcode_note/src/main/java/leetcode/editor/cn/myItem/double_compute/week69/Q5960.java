package leetcode.editor.cn.myItem.double_compute.week69;

import java.net.Socket;
import java.util.Arrays;

/**
 * @date 2022/1/8 22:32
 */
public class Q5960 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.capitalizeTitle("First leTTeR of EACH Word"));
    }
    static class Solution {
        public String capitalizeTitle(String title) {
            String array[] = title.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<array.length;i++){
                if(array[i].length() >=3){
                    stringBuilder.append(toUpperCaseFirstOne(array[i].toLowerCase()));
                    if(i!=array.length-1)
                    stringBuilder.append(" ");
                }else{
                    stringBuilder.append(array[i].toLowerCase());
                    if(i!=array.length-1)
                    stringBuilder.append(" ");
                }
            }

            return String.valueOf(stringBuilder);
        }
        //首字母转小写
        public  String toLowerCaseFirstOne(String s){
            if(Character.isLowerCase(s.charAt(0)))
                return s;
            else
                return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
        //首字母转大写
        public  String toUpperCaseFirstOne(String s){
            if(Character.isUpperCase(s.charAt(0)))
                return s;
            else
                return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}

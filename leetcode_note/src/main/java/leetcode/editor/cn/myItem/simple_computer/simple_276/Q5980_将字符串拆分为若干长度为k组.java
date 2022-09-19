package leetcode.editor.cn.myItem.simple_computer.simple_276;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @date 2022/1/16 10:34
 */
public class Q5980_将字符串拆分为若干长度为k组 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.divideString("abcdefghij",3,'x')));
    }
    static class Solution {
        public String[] divideString(String s, int k, char fill) {
            /*
            拆分，直接遍历，使用builder就行了
            考察知识点substring的分割
             */
            int size = 0;
            if(s.length()%k == 0)
                size = s.length()/k;
            else
                size=s.length()/k+1;
           String[] strings = new String[size];
           int len=0,i=0;
           for(i=0;i<s.length();i++){
                if((i+1)%k == 0){
                    strings[len] = s.substring(i+1-k,i+1);
                    len++;
                }
            }
            //判断最后是否需要填充fill
            if(i%k != 0){
                strings[len] = s.substring(len*k,i);
                StringBuilder sb = new StringBuilder();
                sb.append(strings[len]);
                while (i%k != 0){
                    sb.append(fill);
                    i++;
                }
                strings[len] = sb.toString();
            }
            return strings;
        }
    }

}

package leetcode.editor.cn.myItem.simple_computer.simple_295;

import java.text.DecimalFormat;

/**
 * @date 2022/5/29 11:09
 */
public class Q6079 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.discountPrices("there are $1 $2 and 5$ candies in the shop",50);
    }

    /**
     * 找出表示价格的单词，$xx,然后替换减免一下，保留两位小数，送分题
     */
    static class Solution {
        public String discountPrices(String sentence, int discount) {
            double dis = (100-discount) * 0.01;
            DecimalFormat df = new DecimalFormat("#.00");
            String s[] = sentence.split(" ");
            String s2 = null;
            for (String s1 : s) {
                if(s1.matches("\\$?[0-9]+\\.*[0-9]*")){
                    String old = s1.substring(1,s1.length());
                    double num = Double.parseDouble(old);
                    num = num*dis;
                    String nnum = df.format(num);
                    String neww = String.valueOf(num);
                    s1.replace(old,neww);
                }
            }
            return s2;
        }
    }
}

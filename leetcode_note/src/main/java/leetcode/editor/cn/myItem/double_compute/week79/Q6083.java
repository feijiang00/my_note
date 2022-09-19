package leetcode.editor.cn.myItem.double_compute.week79;

/**
 * @date 2022/5/28 23:07
 */
public class Q6083 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.digitCount("1210");
        System.out.println(b);
    }

    /**
     * 下标即是数字，对应下标存储的数组即是整个数组中该下标对应数字出现的次数。暴力肯定可以，时间复杂度是n2
     *
     */
    static class Solution {
        public boolean digitCount(String num) {
            int tmp_key;//临时key
            int k = 0,kk = 0;
            for(int i=0;i<num.length();i++){
                k = Integer.parseInt(String.valueOf(num.charAt(i)));//k是i出现的次数
                //遍历num，找出真正的次数
                for(int j=0;j<num.length();j++){
                    if(i == Integer.parseInt(String.valueOf(num.charAt(j))))
                        kk++;
                }
                //如果有一个违反则返回false
                if(k!=kk)
                    return false;
                kk=0;
            }
            return true;
        }
    }
}

package 剑指offer;

import java.net.Socket;

/**
 * @date 2022/1/4 22:09
 */
public class Q03_数组中的重复数字 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        int n = solution.findRepeatNumber(nums);
        System.out.println(n);
    }
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了79.21%的用户
    内存消耗：45.9 MB, 在所有 Java 提交中击败了87.74%的用户
     */
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            /*
            如果使用桶下标，那么时间就是2on，空间on，显然这不是好办法，空间浪费太多啦
            但是我们并不是很重视空间
            on，我少看了题目，只需要输出，任意一个重复的数字即可，
             */
            int n = nums.length;
            int szy[] = new int[n];
            for(int i=0;i<n;i++){
                szy[nums[i]]++;
                if(szy[nums[i]] > 1)
                    return nums[i];
            }
            return -1;
        }
    }

}

package lc学习计划.算法;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 2022/1/8 14:41
 */
public class Q977_有序数组的平方 {

    public static void main(String[] args) {
        String s ="abc";
        s.intern();
        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a==b);
    }

    class Solution {
        public int[] sortedSquares(int[] nums) {
            /*
            暴力很简单，on平方，on2排序，但我此刻也想不出更快的算法，综合就是on2，但是java中的sort底层是快排，因此
            是nlogn时间复杂度
             */
            for(int i=0;i<nums.length;i++)
                nums[i] = nums[i]*nums[i];
            /*
            这让我想到了collections和collection的区别，collections中包含的都是一个静态方法，给集合调用的
             */
            Arrays.sort(nums);
            return nums;
        }
    }

}

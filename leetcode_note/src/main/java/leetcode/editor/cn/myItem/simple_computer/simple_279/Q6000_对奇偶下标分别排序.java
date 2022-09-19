package leetcode.editor.cn.myItem.simple_computer.simple_279;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 2022/2/6 10:42
 */
public class Q6000_对奇偶下标分别排序 {


    /**
     * 奇数下标递增，
     * 偶数下标递减
     * 思路，拿出数字，排序，然后放回原数组
     */
    class Solution {
        public int[] sortEvenOdd(int[] nums) {
            int[] a1 = new int[nums.length/2];
            int[] a2 = new int[nums.length/2];

            int f1=0,f2=0;
            for(int i=0;i<nums.length;i++){
                if(i%2 ==0)
                    a2[f2++]=nums[i];
                else
                    a1[f1++]=nums[i];
            }
            Arrays.sort(a1);

            return a1;
        }
    }
}

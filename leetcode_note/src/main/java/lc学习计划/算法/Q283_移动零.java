package lc学习计划.算法;

/**
 * @date 2022/1/8 15:39
 */
public class Q283_移动零 {

    class Solution {
        public void moveZeroes(int[] nums) {
            /*
            双指针yyds，
             */
            int left=0,right=0;
            while (right<nums.length){
                if(nums[right]!=0){
                    swap(nums,right,left);
                    left++;
                }
                right++;
            }
        }

        void swap(int[] nums,int a,int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}

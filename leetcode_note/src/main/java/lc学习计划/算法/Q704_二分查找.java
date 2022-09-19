package lc学习计划.算法;

import java.net.Socket;

/**
 * @date 2022/1/7 20:19
 */
public class Q704_二分查找 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12},2));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            /*
            送分
             */
            int left=0;
            int right=nums.length-1;
            int mid;
            while (left<=right){
                mid=(right-left)/2+left;
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid]>target)
                    right=mid-1;
                else
                    left=mid+1;
            }
            return -1;
        }
    }
}

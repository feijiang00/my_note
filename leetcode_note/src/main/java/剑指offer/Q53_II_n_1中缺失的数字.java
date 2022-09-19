package 剑指offer;

/**
 * @date 2022/1/13 9:44
 */
public class Q53_II_n_1中缺失的数字 {

    class Solution {
        public int missingNumber(int[] nums) {
            /*
            递增查找必然是二分，但是这道题连个查找的数字都没有，快速思考如何处理
            我这里只能想到循环遍历，判断nums[n] == n？ n++
            看了下官方的思路，可以直接二分写，要查找的数字就是mid的下标。。
             */
            int left = 0, right = nums.length - 1, mid = 0;
            while (left <= right) {
                mid = (right - left) / 2 + left;
                //肯定是找不到的
                if (mid < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            return left;
        }
    }
}

/**
 * 暴力
 *class Solution {
        public int missingNumber(int[] nums) {
            递增查找必然是二分，但是这道题连个查找的数字都没有，快速思考如何处理
            我这里只能想到循环遍历，判断nums[n] == n？ n++
            int i=0;
            for ( i = 0; i < nums.length; i++) {
        if(nums[i]!=i)
        return i;
        }
        return i;
        }
        } 
 */

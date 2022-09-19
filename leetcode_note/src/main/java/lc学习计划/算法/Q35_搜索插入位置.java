package lc学习计划.算法;

/**
 * @date 2022/1/8 14:17
 */
public class Q35_搜索插入位置 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert( new int[]{1, 3, 5, 6},2));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
                /*
                二分的变式罢了,理解二分的意义，二分是找这个target，找不到自然就
                返回-1，那么此刻思考left 和right在哪？
                比如[1,2,3,4,5,6,7,8,9,10]这样十个数，找不到的时候，left总是指向插入的位置，除了第一个数
                 */
            if(target<nums[0])
                return 0;
            int left=0;
            int right = nums.length-1;
            int mid;
            while (left<=right){
                mid = (right-left)/2 +left;
                if(target == nums[mid])
                    return mid;
                else if(target>nums[mid])
                    left=mid+1;
                else
                    right=mid-1;
            }
            return left;
        }
    }
}

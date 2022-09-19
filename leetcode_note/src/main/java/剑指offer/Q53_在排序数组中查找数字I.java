package 剑指offer;

/**
 * @date 2022/1/11 14:41
 */
public class Q53_在排序数组中查找数字I {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{2,2},3));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            /*
            二分找到后，左右摇摆去查找
             */
            int left=0,right= nums.length-1,mid;
            int cns=-1,count=0;
            if(nums.length==0)
                return 0;
            //记录cns的值
            while (left<=right){
                mid = (right-left)/2+left;
                if(nums[mid] == target){
                    cns=mid;
                    break;
                }else if(nums[mid] > target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            if (cns != -1) {
                int ccns = cns;
                while (cns< nums.length && cns>=0 && nums[cns] == target) {
                    cns++;
                    count++;
                }
                while (ccns< nums.length && ccns>=0 && nums[ccns] == target ) {
                    ccns--;
                    count++;
                }
                return count-1;
            }else {
                return 0;
            }
        }
    }
}

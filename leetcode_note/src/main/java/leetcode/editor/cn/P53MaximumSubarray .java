//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4120 👎 0


package leetcode.editor.cn;


/**
 * 最大子数组和
 * @author feijiang00
 * @date 2021-12-21 17:05:09
 */
class P53_MaximumSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P53_MaximumSubarray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
		//这题很久之前接触过，可以动态更新数组
		//因为数组连续的，那么拿到一组数，发现一个整数，直接加进来，
		//当发现一个负数加进来的时候，这时肯定会减少，但是如果减少到
		//比我们记录的最大值还有小，那么当前的这个数组就可以丢弃了，
		int sum=0;//求和
		int max=Integer.MIN_VALUE;//当前最大值
		for(int i=0;i<nums.length;i++){
			sum +=nums[i];
			//对该连续数组进行判断
			max = Math.max(max,sum);
			if(sum<0)
				sum=0;
		}
		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//历史版本

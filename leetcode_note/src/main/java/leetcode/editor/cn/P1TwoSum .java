//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 12857 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author feijiang00
 * @date 2021-12-13 17:54:41
 */
class P1_TwoSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1_TwoSum().new Solution();
	 	 int nums[] = {2,7,11,15};
	 	 int params[] = new int[2];
	 	 params = solution.twoSum(nums,9);
	 	 System.out.println(params[0] + "  " + params[1]);

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
		int parms[] = new int[2];
		int len = nums.length;
		//直接暴力
//		for(int i=0;i<len;i++)
//			for(int j=i+1;j<len;j++){
//				if(nums[i] + nums[j] == target){
//					parms[0] = i;
//					parms[1] = j;
//					return parms;
//				}
//			}
//		return null;

		//比on2小的，思路优化，之前查找就是循环找，没有用算法查找，经典的二分查找等等，
		//这里，用hasmap中的查找。为什么？
		//HashMap的底层主要是基于数组和链表实现的，它之所以有相当快的查询速度主要是因为它是通过计算散列码来决定存储位置的。
		//对吧，这不就很舒服嘛

		/**
		 * v1.0
		 * 这里我犯了一个错误，就是没设置谁是key，谁是value，hashmap最重要就是查找，而且只能根据key
		 * 查找出value，使用get这个方法，那么这里就需要给数值设置成key，下标为value
		 */
//		Map<Integer, Integer> map = new HashMap<>();
//		map.put(0,nums[0]);//k-v
//		for(int i=1;i<len;i++){
//			int value = target - nums[i];
//			if(map.containsValue(value)){
//				parms[0] = i;
//				parms[1] = map.get(value);
//				return parms;
//			}
//			map.put(i,nums[i]);
//		}
//		return null;

		/**
		 * v2.0
		 */
		Map<Integer,Integer> map = new HashMap<>();
		map.put(nums[0],0);
		for(int i=1;i<len;i++){
			int value = target - nums[i];
			if(map.containsKey(value)){
				parms[0] = i;
				parms[1] = map.get(value);
				return parms;
			}
			map.put(nums[i],i);
		}


		return null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}

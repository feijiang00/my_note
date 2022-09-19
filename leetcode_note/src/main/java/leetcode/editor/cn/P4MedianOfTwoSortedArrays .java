//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4772 👎 0


package leetcode.editor.cn;

/**
 * 寻找两个正序数组的中位数
 * @author feijiang00
 * @date 2021-12-14 15:34:34
 */
class P4_MedianOfTwoSortedArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	//如果是一个从小到大的数组，返回中位数，那就是o1
		//如果是查找一个数在一个从小到大的数组中，那二分就是ologn
		//那这么看，复杂度为o（log（m+n））是可行的
		//直接拼接两个正序数组，然后求中位数不久ok了？时间复杂度0（m+n）
		//显然不行，哪有这么简单，时间太久了
    	int m = nums1.length;
    	int n = nums2.length;

    	return 0.0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//历史版本

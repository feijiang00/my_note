//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3312 👎 0


package leetcode.editor.cn;

/**
 * 整数反转
 * @author feijiang00
 * @date 2021-12-14 09:50:17
 */
class P7_ReverseInteger{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P7_ReverseInteger().new Solution();
	 	 int n = solution.reverse(123);
	 	 System.out.println(n);
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			int pop = x % 10;
			if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			ans = ans * 10 + pop;
			x /= 10;
		}
		return ans;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}

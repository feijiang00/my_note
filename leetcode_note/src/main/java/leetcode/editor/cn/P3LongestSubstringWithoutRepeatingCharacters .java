//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6576 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author feijiang00
 * @date 2021-12-14 10:40:55
 */
class P3_LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
	 	 int max = solution.lengthOfLongestSubstring("pwwkew");
	 	 System.out.println(max);
	 }
//力扣代码

	/**
	 * 执行耗时:6 ms,击败了71.02% 的Java用户
	 * 内存消耗:38.3 MB,击败了78.88% 的Java用户
	 * 事实上，v1.0版本的两遍for循环确实可以优化，就abcabcaa这个字符串来说，
	 * 从选a开始，拿到abc，我们就可以给a去掉，
	 * 那么整个也就是遍历了一遍字符串，时间复杂度on+hashset查找，别忘了hashset的时间复杂度，
	 * hashset在每次添加的时候，都会去查找一遍，查找的底层基于散列表查找，是效率很高的一种查找
	 *
	 * 这种思想可以说是滑动窗口
	 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int lengthOfLongestSubstring(String s) {
		//abcacbb acb
		Set<Character> set = new HashSet<>();
		int len = s.length();
		int left = 0;//滑动窗口左指针起始点
		int max = 0;//最大长度
		for(int i=0;i<len;i++){
			if(i!=0)
				set.remove(s.charAt(i-1));
			//左指针移动
			while(left<len && !set.contains(s.charAt(left))){//abc
				set.add(s.charAt(left));
				left++;
			}
			max = Math.max(max,left-i);
		}
		return max;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * v1.0
 * 执行耗时:60 ms,击败了14.27% 的Java用户
 * 内存消耗:39 MB,击败了11.77% 的Java用户
 * 其实，这里的优化主要用了set的hash添加，但时间复杂度这么低，，空间低的原因
 * 肯定就是用了set，其实可以用桶标记，a-z对应数组26，将其下标++，当为2时则不满足
 * 那，能不能优化下两边for循环？
 */
class Solution1 {
	public int lengthOfLongestSubstring(String s) {
		//暴力，找出所有子串就是on2，每次判断子串是否成功on，嵌套，on3
		//优化，找子串，查找，必然是hashset，
		if(s.equals(" ")||s.length()==1)
			return 1;
		if(s.equals(""))
			return 0;
		Set<Character> set = new HashSet<>();
		int len = s.length();
		int i,j;
		int max = 0;
		for( i=0;i<len;i++){
			set.add(s.charAt(i));
			for( j=i+1;j<len;j++){
				if(!set.add(s.charAt(j))){
					//一但添加失败，那就是最长的一个子串,清空，break
					//记录长度
					if(max < set.size())
						max = set.size();
					set.clear();
					break;
				}
			}
			//当没添加失败的时候，比如abc这种，这里需要得到set长度
			if(max < set.size())
				max = set.size();
		}
		return max;
	}
}


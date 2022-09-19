//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7222 👎 0


package leetcode.editor.cn;

/**
 * 两数相加
 * @author feijiang00
 * @date 2021-12-14 10:28:59
 */
class P2_AddTwoNumbers{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2_AddTwoNumbers().new Solution();
	 }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 **/
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//这里我本来想着因为链表是尾插法的，就不需要头文件，只需要声明一个
		//res结点，后面直接res = res.next即可，按理这样就可以形成一个链表
		//但是我忘记了函数返回的链表你需要给一个指向该链表的首结点，而我这
		//个结点则是直接指向了尾部，肯定不行

		ListNode res = new ListNode();
		//后续声明头结点
		ListNode head = null;

		int nextSum = 0;//相加后是否进位
		int thisSum = 0;//相加后的留位数字

		while(l1!=null || l2!=null){
			//这里开始忽略了一种情况，当一个链表空了，一个不空的时候，还
			//继续访问的时候，就会出现访问空链表的情况了，这时需要在其长度
			//不够的链表后补0

			int x = l1!=null ? l1.val : 0;//当l1不为空的时候取l1，否则取0
			int y = l2!=null ? l2.val : 0;

			int p = x + y + nextSum;

			thisSum = p %10;

			if(head ==null){
				res.val = thisSum;
				head = res;

			}else{
				res.next = new ListNode(thisSum);
				res = res.next;
			}
			nextSum = p/10;
			//l1,l2链表向后移动

			if(l1!=null)
				l1 = l1.next;

			if(l2!=null)
				l2 = l2.next;

		}
		//最后进位，如果大于0，也就是1就进位保存
		if(nextSum>0)
			res.next = new ListNode(nextSum);
		return head;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}

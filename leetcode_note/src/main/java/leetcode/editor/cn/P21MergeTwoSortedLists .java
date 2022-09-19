//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2091 👎 0


package leetcode.editor.cn;

import java.util.List;

/**
 * 合并两个有序链表
 * @author feijiang00
 * @date 2021-12-15 10:24:01
 */
class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();
	 	 ListNode list1 = new ListNode();
	 	 ListNode list2 = new ListNode();
	 	 ListNode tmp = new ListNode();
	 	 list1.val=1;
	 	 tmp.val=2;
	 	 list1.next = tmp;
	 	 list1 = tmp;
	 	 tmp.val=4;
	 	 list1.next=tmp;
	 }
	 
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
	/**
	 * 执行耗时:0 ms,击败了100.00% 的Java用户
	 * 内存消耗:37.9 MB,击败了21.25% 的Java用户
	 * @param list1
	 * @param list2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1==null)
			return list2;
		else if(list2==null)
			return list1;
		//比如l1：1，3，4 l2：2，5
		else if(list1.val< list2.val){
			//第一次来到这的l1.next是指这个1结点
			list1.next = mergeTwoLists(list1.next,list2);
			//,最后返回1这个结点
			return list1;
		}else{
			list2.next = mergeTwoLists(list1,list2.next);
			return list2;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//历史版本

/**
 * v1.0
 * 我这里用的是迭代的方法，其实我对头结点的处理不是很好，
 * 我想着头结点的.next去保存,这样返回的时候就不好看了
 * 其实，直接给头结点指向node结点即可
 * node结点是一个变换结点，所以需要头结点去记录最初的值，保存
 * node.next = tmp
 * node = tmp
 * 即可实现结点的尾插法擦插入,
 * 见2.0递归实现
 */
class Solution_p21_1 {
	/**
	 * 执行耗时:0 ms,击败了100.00% 的Java用户
	 * 内存消耗:37.7 MB,击败了72.65% 的Java用户
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		//这题送分，既然要合并，那就合呗
		ListNode listNode = new ListNode();
		listNode.next=null;
		ListNode headNode =new ListNode();
		headNode=listNode;// 头结点保存第一个结点
		if(list1==null && list2==null)
			return null;
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;

		//一直循环直到有一个链表为null退出
		while (list1!=null && list2!=null){
//			listNode.val = list1.val <= list2.val? list1.val:list2.val;
			ListNode tmp = new ListNode();
			if(list1.val<= list2.val){
				tmp.val = list1.val;
				list1 = list1.next;
			}else{
				tmp.val = list2.val;
				list2 = list2.next;
			}
			listNode.next = tmp;
			listNode = tmp;
		}
		//给剩下的链表拼接上去
		listNode.next = list1!=null?list1:list2;
		return headNode.next;
	}
}
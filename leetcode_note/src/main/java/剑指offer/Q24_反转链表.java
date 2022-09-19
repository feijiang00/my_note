package 剑指offer;

import java.util.List;
import java.util.Stack;

/**
 * @date 2022/1/5 8:57
 */
public class Q24_反转链表 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        Solution solution = new Solution();
        ListNode node = solution.reverseList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            /*
            反转链表，构造一个新链表即可，送分
            不用栈，直接头插法试试
             */
            ListNode node = null;
            if (head == null)
                return null;
            while (head != null) {
                ListNode tmp = new ListNode();
                tmp.val = head.val;
                tmp.next = node;
                node = tmp;
                head = head.next;
            }
            return node;
        }
    }
}
/**
 * 栈写的效率很低，
static class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode node = new ListNode();
        ListNode hnode = node;//因为头结点要跑，所以这里复制它
        Stack<Integer> stack = new Stack<>();
        node.next =null;
        if(head == null)
            return null;
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        node.val = stack.pop();
        node.next = null;
        while (!stack.isEmpty()){
            ListNode tmp = new ListNode();
            tmp.next=null;
            tmp.val = stack.pop();
            node.next = tmp;
            node = tmp;
        }
        return hnode;
    }
}
*/
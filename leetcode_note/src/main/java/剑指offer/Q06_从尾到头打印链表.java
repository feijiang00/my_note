package 剑指offer;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @date 2022/1/4 23:47
 */
public class Q06_从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(3,new ListNode(2,null)));
        Solution solution = new Solution();
        int[] array = solution.reversePrint(listNode);
        System.out.println(Arrays.toString(array));
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public int[] reversePrint(ListNode head) {
            /*
            链表不可能从尾到头遍历，你只能从头到尾，这句话我说的！
            那么放入栈中，然后栈pop到数组中
             */
            Stack<Integer> stack = new Stack<>();
            while (head!=null){
                stack.push(head.val);
                head = head.next;
            }
            int array[] = new int[stack.size()];
            for(int i =0;i<array.length;i++){
                array[i] = stack.pop();
            }
            return array;
        }
    }

}

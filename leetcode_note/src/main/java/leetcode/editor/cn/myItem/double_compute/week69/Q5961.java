package leetcode.editor.cn.myItem.double_compute.week69;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @date 2022/1/8 22:47
 */
public class Q5961 {

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

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public int pairSum(ListNode head) {
            /*
            遍历结点，统计所有和，取最大
             */
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            if(head == null)
                return 0;
            while (head!=null){
                list.add(head.val);
                head = head.next;
            }
            int n =list.size();
            for (int i=0;i<n/2;i++){
                list1.add(list.get(i)+list.get(n-1-i));
            }
            Collections.sort(list1);
            return list1.get(list1.size()-1);
        }
    }
}

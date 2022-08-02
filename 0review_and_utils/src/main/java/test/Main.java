package test;

import java.util.*;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int nodeCount = in.nextInt();
            int headValue = in.nextInt();

            ListNode head = new ListNode(headValue, null);

            // 获取节点对
            int[][] nodeTuple = new int[nodeCount - 1][];
            for (int i = 0; i < nodeCount - 1; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                nodeTuple[i] = new int[]{v2, v1};
            }

            // 构建链表，使用类似LRU的思想，使用HashMap保存节点对前驱信息
            Map<Integer, ListNode> mp = new HashMap<>();
            mp.put(head.val, head);

            for (int i = 0; i < nodeTuple.length; i++) {
                int[] tuple = nodeTuple[i];
                ListNode pre = mp.get(tuple[0]);
                if (pre != null) {
                    ListNode node = new ListNode(tuple[1], null);
                    mp.put(tuple[1], node);

                    ListNode cur = pre;
                    node.next = cur.next;
                    cur.next = node;
                }
            }

            // 删除节点
            int delValue = in.nextInt();
            ListNode dummy = new ListNode(-1, head);
            ListNode first = dummy, second = head;
            while (second != null) {
                if (second.val == delValue) {
                    first.next = second.next;
                    second = first.next;
                } else {
                    first = second;
                    second = second.next;
                }
            }

            // 输出
            while (dummy.next != null) {
                System.out.print(dummy.next.val);
                System.out.print(" ");
                dummy = dummy.next;
            }
        }
    }
}
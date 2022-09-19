package 剑指offer;

import java.util.*;

/**
 * @date 2022/1/14 10:28
 */
public class Q32_从上到下打印二叉树 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] levelOrder(TreeNode root) {
            /*
            就是层序遍历二叉树，BFS,
            这里有个总计笔记，我本来想找java中的队列，没想到linkedList就是一个队列（双向链表）
            更多的要去理解和看看源码，为什么我不知道这是队列，以及声明使用Queue声明
             */
            if(root==null)
                return new int[]{};
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            queue.add(root);
            //这里说下思路，BFS就是借助队列是实现的一种遍历，将一个结点出对之前，找到其子节点，进队
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                ans.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            int[] cns = new int[ans.size()];
            for(int i=0;i<cns.length;i++){
                cns[i] = ans.get(i);
            }
            return cns;
        }
    }
}

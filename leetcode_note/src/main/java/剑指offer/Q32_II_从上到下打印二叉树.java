package 剑指offer;

import java.util.*;

/**
 * @date 2022/1/14 10:19
 */
public class Q32_II_从上到下打印二叉树 {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            /*
            这题和I类似，就是需要遍历的时候记住位置
             */
            List<List<Integer>> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null) return list;
            queue.add(root);
            int cns =0;
            while (!queue.isEmpty()){
                List<Integer> tmp = new ArrayList<>();
                //这里需要将tmp推入list，但不确定啥时候推进去,
                //这里借助大佬的思路，利用队列的size
                //思考一下，每次来到队列的时候，是不是都有个队列size，这个大小正是我们要poll的数字
                for(int i=queue.size();i>0;i--){
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }
                list.add(tmp);
            }
            return list;
        }
    }
}

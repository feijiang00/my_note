package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2022/1/17 15:44
 */
public class Q27_二叉树的镜像 {

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
        public TreeNode mirrorTree(TreeNode root) {
            //参考的官方答案的思路，哎，真的难受，
            if (root == null) {
                return null;
            }
            TreeNode left = mirrorTree(root.left);
            TreeNode right = mirrorTree(root.right);
            root.left = right;
            root.right = left;
            return root;

        }
    }
}

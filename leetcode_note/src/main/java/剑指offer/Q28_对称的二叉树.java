package 剑指offer;

import org.omg.PortableInterceptor.INACTIVE;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @date 2022/1/18 11:12
 */
public class Q28_对称的二叉树 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,null,new TreeNode(3,null,null)),
                new TreeNode(2,null,new TreeNode(3,null,null)));
        System.out.println(solution.isSymmetric(treeNode));

        //

    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        //掌握两个参数的递归，思路！！！
        public boolean dfs(TreeNode left, TreeNode right) {
            //一直递归到底，如果是对称的化最终会到null这里，返回true
            if(left == null && right == null ) return true;
            if(left == null|| right == null || right.val!=left.val) return false;
            return dfs(left.left,right.right)&& dfs(left.right,right.left);
        }

        public boolean isSymmetric(TreeNode root) {
            return root == null ? true : dfs(root.left,root.right);
        }
    }
}

/*
这个思路是过不了的，一个镜像二叉树的前序和后序数组是反转的，不对的，例如：
[1,2,2,null,3,null,3]   这个二叉树
class Solution {
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        void pre(TreeNode treeNode){
            if(treeNode == null)
                return;
            pre.add(treeNode.val);
            pre(treeNode.left);
            pre(treeNode.right);
        }
        void post(TreeNode treeNode){
            if(treeNode == null)
                return;
            post(treeNode.left);
            post(treeNode.right);
            post.add(treeNode.val);

        }
        public boolean isSymmetric(TreeNode root) {
            pre(root);
            post(root);
            Collections.reverse(post);
            String a = post.toString();
            String b = pre.toString();
            if(a.equals(b))
                return true;
            else
                return false;
        }
    }
 */

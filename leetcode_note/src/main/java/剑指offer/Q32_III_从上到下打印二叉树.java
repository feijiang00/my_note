package 剑指offer;

import java.util.*;

/**
 * @date 2022/1/15 8:27
 */
public class Q32_III_从上到下打印二叉树 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            /*
            理解之前的II就很好写了，拿到队列的大小，设置一个变量判断奇偶遍历
             */
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> list = new ArrayList<>();
            if(root == null)
                return list;
            int flag = 0;
            while (!queue.isEmpty()){
                List<Integer> tmp = new ArrayList<>();
                for(int i=queue.size();i>0;i--){
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }
                if(flag % 2 !=0)
                    Collections.reverse(tmp);
                list.add(tmp);
                flag++;
            }
            return list;
        }
    }
}

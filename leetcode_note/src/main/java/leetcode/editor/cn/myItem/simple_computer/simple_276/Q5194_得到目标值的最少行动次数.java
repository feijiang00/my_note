package leetcode.editor.cn.myItem.simple_computer.simple_276;

import javax.xml.transform.Source;

/**
 * @date 2022/1/16 11:11
 */
public class Q5194_得到目标值的最少行动次数 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minMoves(5,0);

    }


    static class Solution {

        public int minCount = Integer.MIN_VALUE;
        void dfs(int sum,int target,int maxDoubles,int minDepth){
           if(sum == target){
               //记录最小值
               minCount = Math.min(minCount,minDepth);
               return ;
           }

            //自增操作
           dfs(sum+1,target,maxDoubles,minDepth+1);
           //翻倍操作
            dfs(sum*2,target,maxDoubles,minDepth+1);
        }
        public int minMoves(int target, int maxDoubles) {
            /*
            一次行动中，我只能两个方式，要么翻倍，要么自增
             */
            dfs(1,target,maxDoubles,0);
            return minCount;
        }
    }
}

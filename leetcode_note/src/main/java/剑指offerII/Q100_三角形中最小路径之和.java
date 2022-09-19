package 剑指offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022/1/5 16:58
 */
public class Q100_三角形中最小路径之和 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(list));

    }
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            Integer dp[] = new Integer[triangle.size()+1];
            for(int i=0;i<triangle.size()+1;i++)
                dp[i]=0;
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[j] = (Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j));
                }
            }
            return dp[0];
        }
    }
}

/**
 *  递归过ac的写法，但是递归不够优雅，使用递推！！！
 *  static class Solution {
 *         private int dp[][] = new int[200][200];
 *         public int minSum(List<List<Integer>> triangle,Integer i,Integer j){
 *             if(dp[i][j] !=0)
 *                 return dp[i][j];
 *             //临界条件
 *             if(i == triangle.size()-1)
 *                 return triangle.get(i).get(j);
 *             else {
 *                 //递归调用
 *                 int x = minSum(triangle, i + 1, j);
 *                 int y = minSum(triangle, i + 1, j + 1);
 *                 dp[i][j] = Math.min(x, y) + triangle.get(i).get(j);
 *             }
 *             return dp[i][j];
 *         }
 *         public int minimumTotal(List<List<Integer>> triangle) {
 *             return minSum(triangle,0,0);
 *
 *         }
 *     }
 *
 */





/**
     * 递归没用动态数组存储，时间会超限
     * static class Solution {
     *         public int minSum(List<List<Integer>> triangle,Integer i,Integer j){
     *             //临界条件
     *             if(i == triangle.size()-1)
     *                 return triangle.get(i).get(j);
     *             //递归调用
     *             int x = minSum(triangle,i+1,j);
     *             int y = minSum(triangle,i+1,j+1);
     *             return Math.min(x,y) + triangle.get(i).get(j);
     *         }
     *         public int minimumTotal(List<List<Integer>> triangle) {
     *             return minSum(triangle,0,0);
     *
     *         }
     *     }
     */


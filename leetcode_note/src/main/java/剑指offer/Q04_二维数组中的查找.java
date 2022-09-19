package 剑指offer;

import java.net.Socket;

/**
 * @date 2022/1/4 22:28
 */
public class Q04_二维数组中的查找 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][] = {{-5}};
        System.out.println(solution.findNumberIn2DArray(matrix,-5));
    }
    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            /*
            遍历一遍，那就是o（m*n）的时间复杂度，显然不对
            每一行从左到右递增
            每一列从上到下递增
            递增想到的肯定是二分？但是平面二分，你真的看懂了吗？？我不会
            但是！，就这样放弃了？不
            斜角二分，
            最后细想了一下，不行，就这样放弃了吗？
            这里，我后面看了题解找到一个思路，就是从右上角开始找，
            欸，我怎么没想到，傻了
             */
            if(matrix.length <= 0 || matrix[0].length <= 0)
                return false;
            int rows = matrix.length;//rows的意思是一行
            int columns = matrix[0].length;//columns的意思是一列
            int row=rows-1,column=0,num;
            while (row>=0 && column<columns){
                num = matrix[row][column];
                if(target == num)
                    return true;
                else if(target > num)
                    column++;
                else
                    row--;
            }
            return false;
        }
    }

}

package leetcode.editor.cn.myItem.simple_computer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 2022/1/9 10:32
 */
public class Q5976_检查是否每一行每一列都包含全部整数 {

    class Solution {
        public boolean checkValid(int[][] matrix) {
            int n = matrix.length;
           Set<Integer> set = new HashSet<>();
           Set<Integer> set2 = new HashSet<>();
           for(int i=1;i<=n;i++)
                set.add(i);
           for(int i=1;i<=n;i++)
                set2.add(i);
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    if(!set.contains(matrix[i][j]))
                        return false;
                    if(!set2.contains(matrix[j][i]))
                        return false;
                    set.remove(matrix[i][j]);
                    set2.remove(matrix[j][i]);
                }
                for(int k=1;k<=n;k++)
                    set.add(k);
                for(int k=1;k<=n;k++)
                    set2.add(k);
            }
            return true;
        }
    }

}

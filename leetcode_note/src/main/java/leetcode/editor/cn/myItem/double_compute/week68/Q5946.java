package leetcode.editor.cn.myItem.double_compute.week68;

/**
 * @date 2021/12/25 22:37
 */
public class Q5946 {


    class Solution {
        public int mostWordsFound(String[] sentences) {
            String tmp[];
            int count = 0;
            for(int i=0;i<sentences.length;i++){
                tmp = sentences[i].split(" ");
                count = Math.max(tmp.length,count);
            }
            return count;
        }
    }

}



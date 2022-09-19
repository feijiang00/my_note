package leetcode.editor.cn.myItem.double_compute.week69;

/**
 * @date 2022/1/8 23:02
 */
public class Q5962 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String []strings = {"ab","ty","yt","lc","cl","ab"};
        System.out.println(solution.longestPalindrome(strings));

    }
    static class Solution {
        int max = Integer.MIN_VALUE;
        public boolean reverse(String s){
            // 用StringBuilder的reverse方法将字符串反转
            StringBuilder sb=new StringBuilder(s);
            String afterReverse=sb.reverse().toString();
            //判断反转后的字符串与原字符串是否相等，可用compareTo，equals，
            int isequal=afterReverse.compareTo(s);  //若相等则输出0
            if (isequal==0){
                return true;
            }else
                return false;
        }

        void dfs(String[] words,int []book,int step,StringBuilder builder){
            if(reverse(builder.toString())){
                //当是回文串的时候跟新
                max = Math.max(max,builder.length());
            }
            if(step == words.length){
//                builder.delete(0,builder.length());
                return;
            }
            for(int i=0;i<words.length;i++){
                if(book[i]==0){
                    builder.append(words[i]);
                    book[i]=1;
                    dfs(words,book,step+1,builder);
                    book[i]=0;
                    builder.delete(builder.length()-words[i].length(),builder.length());
                }
            }
        }
        public int longestPalindrome(String[] words) {

            int []book = new int[words.length];//标记数组
            StringBuilder stringBuilder = new StringBuilder();
            dfs(words,book,0,stringBuilder);
            return max;
        }
    }
}

package leetcode.editor.cn.myItem.simple_computer.simple_295;

import java.net.Socket;
import java.util.Arrays;

/**
 * @date 2022/5/29 10:35
 */
public class Q6078 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rearrangeCharacters("ilovecodingonleetcode","code");
    }
    /**
     * 存储到对应的字符数组里，然后取字符数组的最小值即可
     */
    static class Solution {
        public int rearrangeCharacters(String s, String target) {
            int st[] = new int[26];//字符数组,对应a-z
            int sn[] = new int[26];//tartget的字符数组
            for(int i=0;i<s.length();i++){
                //contains是判断字符串是否包含某个子串，因此这里将字符转为字符串
                if(target.contains(Character.toString(s.charAt(i)))){
                    st[s.charAt(i)-97]++;
                }
            }
            for(int i=0;i<target.length();i++)
                sn[target.charAt(i)-97]++;
//            Arrays.sort(st);这里发现排序是不行的，因为st数组只是表示target中存在的字符出现的次数，
//            新思路，：其实在s中统计字符得到s字符数组，在target中统计字符得到字符数组，两个数组对称减就行了

            int size =0;
            while (true){
            for(int i=0;i<26;i++){
                //减的前提是sn中不为0
                if(sn[i]!=0){
                    if(st[i] - sn[i] <0)
                        return size;
                    st[i] = st[i] - sn[i];
                }
            }
                size++;
            }

        }
    }
}

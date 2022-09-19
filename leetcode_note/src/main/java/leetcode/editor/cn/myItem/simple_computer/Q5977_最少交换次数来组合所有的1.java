package leetcode.editor.cn.myItem.simple_computer;

import javax.xml.transform.Source;
import java.util.stream.StreamSupport;

/**
 * @date 2022/1/9 10:53
 */
public class Q5977_最少交换次数来组合所有的1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSwaps(new int[]{1,1,0,0,1}));
    }
    static class Solution {
        public int minSwaps(int[] nums) {
            /*
            典序的滑动窗口，送分
             */
            int len = nums.length;
            int clen = 0;//滑动窗口长度
            int zeroc = 0;//统计0的数量
            int ans = Integer.MAX_VALUE;//最少0数量
            for (int i : nums) {
                if(i == 1)
                    clen++;
            }
            for(int i=0;i<len*2;i++){
                //求窗口内0数量
                if(i>=clen){
                    //当窗口是窗口的时候才会求
                    ans = Math.min(ans,zeroc);
                    //左窗口右移
                    if(nums[(i-clen)%len] ==0)
                        zeroc--;
                }
                //右窗口右移
                if(nums[i%len] ==0)
                    zeroc++;
            }
            return ans;
        }
    }

}

/**
 * 周赛写的未ac的版本
 * static class Solution {
 *         public int minSwaps(int[] nums) {
 *             int len = nums.length;
 *             int p=0,q=len-1,flag=0;
 *             int swap=0;
 *             while (p<=q){
 *                 if(nums[p] ==1)
 *                     flag=1;
 *                 if(nums[p]==0&&flag==1){
 *                     //找q指针去补
 *                     while (nums[q]==0){
 *                         q--;
 *                     }
 *                     //假装移动
 *                     q--;
 *                     swap++;
 *                 }
 *                 p++;
 *             }
 *             return swap;
 *         }
 *         public void swap(int[] nums,int a,int b){
 *             int tmp = nums[a];
 *             nums[a] = nums[b];
 *             nums[b] = nums[a];
 *         }
 *     }
 */

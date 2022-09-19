package 每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2022/1/19 10:21
 */
public class Q219_存在重复元素II {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2);
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /*
            滑动窗口写法
             */
            Set<Integer> set = new HashSet<Integer>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                if (!set.add(nums[i])) {
                    return true;
                }
            }
            return false;

        }
    }

    static class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /*
            看了下有哈希表的做法，我来试一下,
            没想出来
             */
            return false;
        }
    }
    /*
    执行用时：1251 ms, 在所有 Java 提交中击败了18.46%的用户
    内存消耗：50.3 MB, 在所有 Java 提交中击败了46.72%的用户
     */
    static class Solution1 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /*
            遍历，然后对每一个数，向前寻找k个
             */
            for(int i=0;i<nums.length;i++){
                int p = i;
                int count = k;
                while (count>0&&p>0){
                    p--;
                    if(nums[p] == nums[i])
                        return true;
                    count--;
                }
            }
            return false;
        }
    }
}

package lc学习计划.算法;

/**
 * @date 2022/1/8 19:15
 */
public class Q167_两数之和_输入有序数组 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            /*
            暴力，on2时间复杂度，
            或者使用hashmap，on的时间复杂度
            但是，有个条件没有用上，那就是递增序列，我说了，递增往二分想
             */
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (sum == target) {
                    return new int[]{low + 1, high + 1};
                } else if (sum < target) {
                    ++low;
                } else {
                    --high;
                }
            }
            return new int[]{-1, -1};
        }
    }
}

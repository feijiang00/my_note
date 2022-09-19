package 剑指offer;

import java.util.Arrays;

/**
 * @date 2022/1/5 10:31
 */
public class Q11_旋转数组的最小数字 {


    class Solution {
        /*
        鬼怪二分，这个我不太会
         */
        public int minArray(int[] numbers) {
            int low = 0;
            int high = numbers.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (numbers[pivot] < numbers[high]) {
                    high = pivot;
                } else if (numbers[pivot] > numbers[high]) {
                    low = pivot + 1;
                } else {
                    high -= 1;
                }
            }
            return numbers[low];
        }
    }

}


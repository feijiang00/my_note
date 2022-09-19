package lc学习计划.算法;

/**
 * @date 2022/1/8 15:20
 */
public class Q189_轮转数组 {

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] newArr = new int[n];
            for (int i = 0; i < n; ++i) {
                newArr[(i + k) % n] = nums[i];
            }
            System.arraycopy(newArr, 0, nums, 0, n);
        }
    }

//    class Solution {
//        public void rotate(int[] nums, int k) {
//            /*
//            最简单的方法就是开辟一个数组，把nums中的数全部+k后移到新数组，操作简单
//
//             */
//            int n = nums.length;
//            int p=0;
//            int q=p+k;
//            int tmp;
//            while (n>0){
//                tmp=nums[q];
//                nums[q]=nums[p];
//                nums[p]=tmp;
//                p=(p+1)%nums.length;
//                q=(q+1)%nums.length;
//                n--;
//            }
//        }
//    }
}

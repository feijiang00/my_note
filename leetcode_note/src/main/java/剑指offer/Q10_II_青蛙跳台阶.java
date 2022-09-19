package 剑指offer;

/**
 * @date 2022/1/5 9:58
 */
public class Q10_II_青蛙跳台阶 {

    class Solution {
        public int numWays(int n) {
            int a = 1, b = 1, sum;
            for(int i = 0; i < n; i++){
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return a;
        }
    }

}
/**
 * 这里其实是可以优化的，因为数组之前的数都没有用
 * 其实我这个写法叫动态规划，我会动态规划了哈哈哈哈哈哈哈哈哈哈哈哈哈哈
class Solution {
    public int numWays(int n) {
        if(n==0 || n==1)
            return 1;
        if(n==2)
            return 2;
        int array[] = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        for(int i=3;i<=n;i++){
            array[i] = (array[i-1] + array[i-2])%1000000007;
        }
        return array[n];
    }
}*/
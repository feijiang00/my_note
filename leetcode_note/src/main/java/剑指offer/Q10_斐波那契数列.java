package 剑指offer;

/**
 * @date 2022/1/4 13:09
 */
public class Q10_斐波那契数列 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(95));
    }
    static class Solution {
        public int fib(int n) {
            //既然递归超时，那就构造一个fib数列，送分题
            //安静聆听这命运的悲鸣吧
            long szy[] = new long[101];
            szy[0] = 0L;
            szy[1] = 1L;
            for(int i=2;i<=100;i++){
                szy[i] = (szy[i-1] + szy[i-2])%1000000007;
            }
            return (int) (szy[n]%1000000007);
        }
    }

}

/*
递归会超时
class Solution {
    public int fib(int n) {

        if(n == 0 || n==1)
            return n;
        return (fib(n-1) + fib(n-2)) % 1000000007;
    }
}*/

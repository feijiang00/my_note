package java成神之路;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @date 2021/12/22 1:06
 */
public class Main {
    public static void main(String[] args) {
        int n,m,k;
        Scanner sc=  new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int k_score = k;
        int[][] parm = new int[n][m];//存储分数数组
        int []score = new int[n+1];//记录总分数组
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());//找出排名
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                parm[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(parm[j][i],j+1);//这里n代表第n位选手的分数
            }
            //进行一遍统计
            k_score = k;
            for (Integer value : map.values()) {
                if(k_score<0)
                    k_score = 0;
                score[value] += k_score;//记录分数
                k_score--;//每遍历一次分数减一
            }
            map.clear();
        }
        for(int i=1;i<=n;i++){
            System.out.print(score[i]+" ");
        }
    }
}

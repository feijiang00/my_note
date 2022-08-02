package day01_base.sort;

import java.util.Arrays;

/**
 * @date 2021/12/16 9:13
 */
public class SelectSort {

    public static void main(String[] args) {
        int a[] ={12,44,656,23,11,2,34,878,566,4};
        selectSort(a);
    }

    public static void selectSort(int a[]){
        int len = a.length;

        for(int i=0;i<len-1;i++){
            //这里的i就代表有序数组的那一队
            int s = i;//记录最小值i
            for(int j=s+1;j<len;j++){
                if(a[j]<a[s]){
                    s=j;
                }
            }
            //这里做了优化，每趟只交换一次
            if(s!=i)
            swap(a,s,i);

            System.out.println(Arrays.toString(a));
        }
    }

    public static void swap(int c[],int a,int b){
        int tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}

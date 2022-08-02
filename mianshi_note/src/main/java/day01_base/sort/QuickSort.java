package day01_base.sort;

import java.util.Arrays;

/**
 * @date 2021/12/20 8:58
 */
public class QuickSort {
    /**
     * 手写快排，还有谁?
     * @param args
     */

    public static void main(String[] args) {
        int a[] ={12,44,656,23,11,2,34,878,566,4};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static int partition(int a[],int l,int r){
        //对l-r区间的元素进行划分
        //选取r作为基准点元素
        int tmp = a[r];
        //划分思路：i,j从起始点出发，取找比基准点小的元素
        int i=l,j;
        for(j=l;j<r;j++){
            if(a[j]<tmp){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,r);
        System.out.println(Arrays.toString(a)+" i="+i);
        return  i;
    }

    public static void quickSort(int a[],int l,int r){
        if(l>=r)
            return;
        int i;
        i = partition(a,l,r);
        quickSort(a,l,i-1);
        quickSort(a,i+1,r);

    }

    public static void swap(int c[],int a,int b){
        int tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

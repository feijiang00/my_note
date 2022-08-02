package day01_base.sort;

import java.util.Arrays;

/**
 * @date 2021/12/16 9:35
 */
public class InsertSort {
    public static void main(String[] args) {
        int a[] ={12,44,656,23,11,2,34,878,566,4};
        insertSort(a);

    }

    /**
     * 从第二个元素开始，将新加入的元素插入到有序数组中
     * @param a
     */
    public static void insertSort(int a[]){
        int len = a.length;
        int i,j;
        for(i=1;i<len;i++){
           int tmp = a[i];//要插入的数
            for(j=i;j>0&&a[j-1]>tmp;j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
            System.out.println(Arrays.toString(a));
        }
    }

    public static void swap(int c[],int a,int b){
        int tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

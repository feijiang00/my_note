package java刘意;

import java.util.Arrays;

/**
 * @author FeiJiang00
 * @date 2021/11/11 22:07
 */
public class ArraysUse {
    /**
     * Array类的使用，包含操作数据的各种方法
     * 手写冒泡排序
     */
    public static void main(String[] args) {

        int arr[] = {24,13,56,34,87};
        System.out.println("排序前；"+ Arrays.toString(arr));

        //使用java数据自带的sort函数
        Arrays.sort(arr);

        System.out.println("排序后："+Arrays.toString(arr));

        //使用自己写的冒泡排序
        int arr2[] = {24,13,56,34,87};
        System.out.println("排序前；"+ Arrays.toString(arr2));
        BubbleSort(arr2);
        System.out.println("排序后："+Arrays.toString(arr2));

    }

    public static void BubbleSort(int[] arr){

        int length = arr.length;
        for(int i=0;i<length-1;i++){
            //冒泡排序，排序n个数，比较n-1次
            for(int j=0;j<length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //如果前面的数比后面的大，则调换位置
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

}

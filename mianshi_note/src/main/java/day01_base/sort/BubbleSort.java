package day01_base.sort;

import java.util.Arrays;

/**
 * @date 2021/12/14 22:22
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] ={12,44,656,23,11,2,34,878,566,4};
        bubbleSort_v2(a);
        System.out.println("nihaoa");

    }

    /**
     * 把数组当成水池，前面的元素就和水池低的泡泡一样，浮到数组最后
     * 两点可以改进：1.当发现没有交换的时候，就是排序ok了，这时可以退出
     *            2.如果一个冒泡一轮过后，后面的数都有序了还需要比较吗？
     * @param a
     */
    public static void bubbleSort(int a[]){
        int len = a.length;
        boolean exchange;
        //执行len-1轮
        for(int i=0;i<len-1;i++){
            exchange = false;
            //每一轮冒泡
            for(int j=0;j<len-i-1;j++){
                if(a[j]<a[j+1]){
                    swap(a,j,j+1);
                    exchange=true;
                }
            }
            System.out.println(Arrays.toString(a));
            if(!exchange)
                return;
        }
    }

    /**
     * 优化了比较次数
     * 记录最后一次有序的位置，下次冒泡，就无需再次比较了！
     * @param a
     */
    public static void bubbleSort_v2(int a[]){
        int ll = a.length-1;
        while (true){
            int last = 0;
            for( int j=0;j<ll;j++){
                if(a[j]>a[j+1]){
                    System.out.println("比较次数:"+j);
                    swap(a,j,j+1);
                    last=j;
                }
            }
            System.out.println(Arrays.toString(a));
            ll = last;
            if(ll==0)
                break;
        }
    }

    public static void swap(int c[],int a,int b){
        int tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

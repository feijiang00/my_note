package zmyself.day01;

import java.util.Arrays;

/**
 * @date 2021/12/22 11:11
 */
public class Sort {


    public static void main(String[] args) {

        int a[] = {45,23,1,24,57,78,67,99};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void bubbleSort(int a[]){
        //当一趟没发生交换说明有序了退出
        //什么时候开始没发生交换了每一趟？下一趟是不是就不用跑全图了
        int key =a.length - 1;
        while(true) {
            int last = 0;
            for (int j = 0; j < key; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;//记录上一趟最后发生交换的位置
                }
            }
            key = last;
            if(key == 0)
                break;//当一趟没发生交换说明有序了退出,也就是上一趟没有在0的位置就没有发送交换了，退出
        }
    }

    public static void selectSort(int a[]){
        //选择排序从乱序中找最小的数逐个放到已排序中
        //那么肯定有游标，s就是已排序游标,乱序游标就是s+1
        for(int i=0;i< a.length-1;i++){
            int s=i;
            for(int j=s+1;j<a.length;j++){
                if(a[j]<a[s])
                    s=j;
            }
            if(s!=i)
                swap(a,s,i);
        }
    }

    public static void insertSort(int a[]){

        for(int i=0;i<a.length;i++){
            for (int j=0;j<a.length-1;j++){

            }
        }
    }

    public static void swap(int a[],int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] =tmp;
    }
}

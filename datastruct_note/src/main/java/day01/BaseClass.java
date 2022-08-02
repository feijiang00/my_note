package day01;

/**
 * @date 2022/1/21 10:39
 */
public class BaseClass {
    int []array = new int[]{4,8,6,7,2,1,5,9};

    /*
    交换算法
     */
    public void swap(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    /*
    输出算法
     */
    public void display(){
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

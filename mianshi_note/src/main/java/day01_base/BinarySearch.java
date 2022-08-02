package day01_base;

/**
 * @date 2021/12/14 21:54
 */
public class BinarySearch {

    public static void main(String[] args) {
        int a[] ={1,2,3,6,7,9,12,33,56,86,232};
        int position = binarySearch(a,2);
        System.out.println(position);
    }

    public static int binarySearch(int a[],int target){
        int len = a.length,mid;
        int left=0;
        int right=len-1;
        while(left<=right){
//            mid = left + (right-left)/2;//这样解决溢出不好
            mid = (left+right)>>>1;
            if(a[mid] == target)
                return mid;
            else if(a[mid] >target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}
/**
 * 拓展：
 *      如何快速在一组数据中，用二分查找找一个数，求出要查找的次数？
 *      直接比较，奇数二分取中间
 *              偶数二分取中间靠左
 *      这样，不用取数数，很快就可以求出来
 *
 *
 */

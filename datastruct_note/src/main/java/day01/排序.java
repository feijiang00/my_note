package day01;

import org.junit.Test;

/**
 * @date 2022/1/21 10:39
 */
public class 排序 extends BaseClass{

    /**
     * 外层for循环中的i就是起到了冒泡最顶层的标记作用kj
     * 可以优化，当我们发现遍历j的时候，一趟交换都不存在，那么直接break
     */
    @Test
    public void 冒泡排序(){

        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1])
                swap(array,j+1,j);
            }
            display();
        }
        display();
    }

    /**
     * 还可以继续优化，这里虽然一趟没有交换就可以排序成功了，但是考虑这样一个场景
     * 记录最后一次交换的地方，下次的交换就可以直接从这里进行交换，不好理解？举个例子
     * 5 4 3 2 5 7 8 9 10 比如这里当在5之后就没有发生交换了，这时下一趟也就没有必要再去判断5之后的数字
     *
     */
    @Test
    public void 冒泡排序2(){

        for(int i=0;i<array.length-1;i++){
            boolean flag = false;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    swap(array,j+1,j);
                    flag = true;
                }
            }
            display();
            if(!flag)
                break;;
        }
        display();
    }

    /**
     * 优化后的冒泡排序思路也很简单，就是冒泡的水面定位，动态定位水面
     */
    @Test
    public void 冒泡排序3(){
        int index = array.length-1;
        while (true){
           int last = 0;
           //index之后的不再进行交换，因此将i改成index,改完发现外层的for没有用了
            for(int j=0;j<index;j++){
                if(array[j]>array[j+1]){
                    System.out.println("比较次数："+j);
                    swap(array,j+1,j);
                    last = j;//记录最后一次交换的位置
                }
            }
            //输出中间结果
            display();
            //如果判断跳出？最后一次交换的位置和初始的位置相等，也就是一趟交换没有，退出
            index = last;
            if(index == 0)
                break;
        }
        display();
    }


    /**
     * 选择排序，思路
     * 从一组数据中找出一个最小的树，依次放到有序中，找出嘛，就是挑个最小的数
     */
    @Test
    public void 选择排序(){
        for(int i=0;i<array.length-1;i++){
            int index = i;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[index]){
                    index = j;
                    array[index] = array[j];//更新最小值
                }
            }
            System.out.println("第"+(i+1)+"躺");
            display();
            if(index != i)
                swap(array,i,index);
        }
        display();
    }

    /**
     *  思路和选择排序类似，即将前面的有序队列看作有序，然后从乱序数组选一个数，插入到适合的位置
     *
     */
    @Test
    public void 插入排序(){
        int i,j;
        for(i=1;i<array.length;i++){
            int k = array[i];
            for(j=i;j>0&&array[j-1]>k;j--){
                array[j] = array[j-1];
            }
            array[j] = k;
            System.out.println("第"+(i+1)+"躺");
            display();
        }
        display();
    }
}


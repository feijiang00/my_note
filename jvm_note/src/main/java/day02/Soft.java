package day02;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用的一个实际应用
 * 总结：引入软引用，在一些list等泛型内加上SoftReference的声明
 *      配置引用队列清楚软引用：
 *      1.声明引用队列
 *      2.软引用构造的时候，第二个参数带上队列，实现绑定
 *      3.在需要的时候，使用队列的poll方法拿到软引用，并且remove即可
 * @date 2022/1/3 21:54
 */
public class Soft {
    /*
    -Xmx20m 设置堆内存大小只有20m
     */
    public static void main(String[] args) {
        soft();
    }
    private static final int _4MB = 4 * 1024 *1024;

    public static void soft(){

        //在list集合中加入SoftReference，就可以表示这是个软引用了
        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for(int i=0;i<5;i++){
            //关联引用队列，当软引用所关联的byte[]被回收时，软引用自己会加入到queue引用队列中去
            //如何关联？只需要在其构造方法，加入第二个参数，表示队列
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        //从队列中获取无用的软引用对象
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null){
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("循环结束" + list.size());
        for (SoftReference<byte[]> softReference : list) {
            System.out.println(softReference.get());
        }
        /*
        当循环结束，如果不对软引用清空的话，打印出来的是这样：
        null
        null
        null
        null
        [B@677327b6

        这时，我们可以配合引用队列来清除null的软引用：
        [B@677327b6
         */
    }
}

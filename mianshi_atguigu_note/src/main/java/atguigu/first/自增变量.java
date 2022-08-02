package atguigu.first;

/**
 * @date 2022/1/14 21:16
 */
public class 自增变量 {

    public static void main(String[] args) {

        int i =1;
        i=i++;
        //如果你不能理解，那就记住就行了
        int j = i++;// j=1 i=2
        System.out.println(j);// j = 1

        int k = i + ++i * i++;
        System.out.println(k);


    }
}

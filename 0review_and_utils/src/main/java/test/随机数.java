package test;

import java.util.Random;

/**
 * @date 2022/4/2 3:20
 */
public class 随机数 {

    public static void main(String[] args) {

        Random random = new Random();
        int a = random.nextInt();
        System.out.println(a);
    }
}

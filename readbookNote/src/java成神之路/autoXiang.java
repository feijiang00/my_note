package java成神之路;

import org.testng.annotations.Test;

/**
 * @author FeiJiang00
 * @date 2021/11/11 16:14
 */
public class autoXiang {

    @Test
    public void test(){

        /**
         * 自动装箱：Integer.valueOf()
         * 自动拆箱：integer.intValue()
         */
        boolean flag = true;
        Integer i = 0;
        int j = 1;
        int k = flag? i:j;
    }
}

package day01.mytest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @date 2021/12/13 13:25
 */
public class Test {

    public static final Integer N = 1000000000;

    FutureTask<Integer> f1 = new FutureTask<>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {

            return null;
        }
    });
}

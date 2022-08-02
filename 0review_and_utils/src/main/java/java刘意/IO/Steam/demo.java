package java刘意.IO.Steam;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @date 2021/12/3 10:49
 */
public class demo {

    @Test
    public void test() throws UnsupportedEncodingException {

        String s = "中国";
        System.out.println(Arrays.toString(s.getBytes("gbk")));
    }
}

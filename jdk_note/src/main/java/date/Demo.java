package date;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @date 2022/1/18 14:52
 */
public class Demo {

    @Test
    public void test1(){
        //拿到当前的日期
        LocalDate date = LocalDate.now();
        System.out.println(date);

        //拿到当前的时间
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //ArrayIndexOutOfBoundsException
        int []array = new int[5];
        array[10] =1;//java.lang.ArrayIndexOutOfBoundsException: 10

    }
}

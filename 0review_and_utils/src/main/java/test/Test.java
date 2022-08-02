package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 输入年月，统计该月中的星期一的次数
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String validatetime = "2020-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date now = sdf.parse(validatetime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DATE, 1);
        if (calendar.get(Calendar.DAY_OF_WEEK) > 1) {
            calendar.add(Calendar.DATE, 7);
            calendar.set(Calendar.DAY_OF_WEEK, 2);
        }
        int count = 0;
        while (month == calendar.get(Calendar.MONTH)) {
            count++;
            calendar.add(Calendar.DATE, 7);
        }
        System.out.println(count);
    }
}
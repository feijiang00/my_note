package java刘意;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *SimpleDateFormat 继承自DateFormat类，有两个方法
 * format 将日期转为字符串
 * parse    将字符串转为日期
 *
 * 并且该类的构造函数使用了重载形式，传入的参数便是字符串的日期的格式
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {

        Date d = new Date();

        //创建一个日期格式对象
        //括号中不传参数，那就是默认的日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");

        System.out.println(d);//Sat Mar 27 12:50:51 CST 2021

        System.out.println(sdf.format(d));//2021/3/27 下午12:50

        System.out.println(sdf2.format(d));//2021年03月27日  12:52:45

        //从String到Date
        //将String字符串解析成日历时间
        String ss = "2007-05-24 12:00:00";

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dd = sdf3.parse(ss);

        System.out.println(dd);//Thu May 24 12:00:00 CST 2007



    }
}

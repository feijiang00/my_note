package java刘意.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        String s = "2048-08-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //为什么这里会报错？
        /**
         * public Date parse(String source) throws ParseException {     //交给上级处理
         *         ParsePosition pos = new ParsePosition(0);
         *         Date result = this.parse(source, pos);
         *         if (pos.index == 0) {
         *             throw new ParseException("Unparseable date: \"" + source + "\"", pos.errorIndex);    //抛出了异常
         *         } else {
         *             return result;
         *         }
         *     }
         */
        try{
            Date d = sdf.parse(s);
            System.out.println(d);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

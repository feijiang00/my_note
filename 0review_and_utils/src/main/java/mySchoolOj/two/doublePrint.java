package mySchoolOj.two;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class doublePrint {
        // 方法一
        public void test1() {
            double d = 0.3456789;
            BigDecimal bd = new BigDecimal(d);
            double test1 = bd.setScale(2, BigDecimal.ROUND_DOWN).doubleValue(); // 保留两位小数，不四舍五入(可选舍入模式)
            System.out.println("方法一：" + test1); //0.34
        }
//        setScale(newScale, roundingMode)
//        newScale:要返回的 BigDecimal 值的标度。
//        roundingMode:要应用的舍入模式。
//        返回:一个 BigDecimal，其标度为指定值，其非标度值可以通过此 BigDecimal的非标度值乘以或除以十的适当次幂来确定。


        // 方法二
        public void test2() {
            double d = 0.3456789;
            // #.00 表示两位小数
            DecimalFormat df = new DecimalFormat("#0.00"); // 保留两位小数，四舍五入
            System.out.println("方法二：" + df.format(d)); //0.35
        }

/*        0 阿拉伯数字
# 阿拉伯数字如果不存在就显示为空
                . 小数分隔符或货币小数分隔符
                - 减号
                , 分组分隔符
        E 分割科学技术法中的尾数和指数。在前缀和后缀中无需添加引号
        ; 分隔正数和负数子模式
                % 乘以100并显示为百分数
\u2030 乘以1000并显示为千分数
\u00A4 货币记号，由货币符号替换。如果两个同时出现，则用国际货币符号替换。如果出现在某个模式中，则使用货币小数分隔符，而不使
                用小数分隔符
        ' 用于在前缀或或后缀中为特殊字符加引号，例如 "'#'#" 将 123 格式化为 "#123"。要创建单引号本身，请连续使用两个单引号： "# o''clock"

        1.整数：若是n个0，就从个位开始向高位填充，如果有值就是原来的值，没有就填充0。
        若都是#，没有实际意义，不管是几个#，最后的结果都是原来的整数。0和#配合使用，只能是"##00",不能是"00##",就是#在前0在后。
        实现是上面的合集。
        2.小数：是可以保留小数点后几位的（几个0后或几个#）。 若n个0，就是保留n位小数，小数不足的部分用0填充。
        若n个#，就是保留n位小数，小数不足部分没有就是没有。*/

        // 方法三
        public void test3() {
            double d = 0.3456789;
            // %.2f %.表示 小数点前任意位数 2 表示两位小数 格式后的结果为f 表示浮点型
            System.out.println("方法三：" + String.format("%.2f", d));// 保留两位小数，四舍五入  //0.35
        }
//        字符串常规类型格式化的两种重载方式
//        format(String format, Object… args) 使用当前本地区域对象（locale.getDefault()）格式化字符串
//        format(Locale locale, String format, Object… args) 自定义本地区域对象格式化字符串


        // 方法四
        public void test4() {
            double d = 0.3456789;
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2); // 保留两位小数，四舍五入
            System.out.println("方法四：" + nf.format(d)); //0.35
        }
       /* NumberFormat.getInstance 返回当前缺省语言环境的缺省数值格式；
        NumberFormat.getCurrencyInstance 返回当前缺省语言环境的通用格式。
        NumberFormat.getPercentInstance 返回当前缺省语言环境的百分比格式。
        NumberFormat.getNumberInstance 返回指定语言环境的通用数值格式。
        setMinimumFractionDigits() 设置数值的小数部分允许的最小位数，不足的位数以0补位，超出的话按实际位数输出。
        setMaximumFractionDigits() 设置数值的小数部分允许的最大位数，不足不补0。
        setMaximumIntegerDigits() 设置数值的整数部分允许的最大位数。
        setMinimumIntegerDigits() 设置数值的整数部分允许的最小位数。*/

        // 方法五
        public void test5() {
            double d = 0.3456789;
            // 保留两位小数，四舍五入
            System.out.println("方法五：" + (double) Math.round(d * 100) / 100.0); //0.35
        }
      /*  如果参数的小数部分大于0.5，则舍入到相邻的绝对值更大的整数。
        如果参数的小数部分小于0.5，则舍入到相邻的绝对值更小的整数。
        如果参数的小数部分恰好等于0.5，则舍入到相邻的在正无穷（+∞）方向上的整数。
        例如，3.5 将舍入为 4.0，而 -3.5 将舍入为 -3.0。*/


    public static void main(String[] args){

    }
}

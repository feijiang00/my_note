package mySchoolOj.three;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class three2 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入要计算的运算：");
        Scanner scanner = new Scanner(System.in);
        System.out.println(saveNumber_Symbol(scanner.next()));
    }

    /*分割字符串存储运算符和数字分别到calcuStrList和numberList*/
    public static String saveNumber_Symbol(String str) {
        str+="$";  //加上"$"用于获取分割最后一个数字
        char[] strChar = str.toCharArray();
        List<String> calcuStrList = new ArrayList<>();//存储运算符号
        List<String> numberList = new ArrayList<>();//存储数字
        StringBuilder buff = new StringBuilder();
        int i = 0;
        for (char ch : strChar) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                calcuStrList.add(String.valueOf(ch));
                numberList.add(buff.toString());
                buff.delete(0, buff.length());
            } else if (ch == '$') {//判断是不是最后一个数
                numberList.add(buff.toString());
            } else {
                buff.append(ch);
            }
        }
        return calculationOrder(calcuStrList, numberList);
    }

    /*控制加减乘除的运算优先级顺序*/
    public static String calculationOrder(List<String> calcuStr, List<String> number) {
        if (calcuStr.size() > 0) {
            int multiply = calcuStr.indexOf("*");
            int except = calcuStr.indexOf("/");

            //除在前乘在后，或有除无乘，则先算除
            if ((-1 != multiply && -1 != except && except < multiply) || (calcuStr.contains("/") && !calcuStr.contains("*"))) {
                calcuResult("/", calcuStr, number);
            }
            //乘在前除在后，或有乘无除，先算乘
            if ((-1 != multiply && -1 != except && multiply < except) || (calcuStr.contains("*")&& !calcuStr.contains("/"))) {
                calcuResult("*", calcuStr, number);
            }
            //无乘除只有加减，则从左往右计算
            if (calcuStr.size() > 0) {
                calcuResult(calcuStr.get(0), calcuStr, number);
            }
        }
        return number.get(0);
    }

    /*通过symbol找到运算符在calcuStr出现的位置,根据位置在number中找到符号前后的两个数进行计算*/
    public static String calcuResult(String symbol, List<String> calcuStr, List<String> number) {
        int position = calcuStr.indexOf(symbol);
        BigDecimal a = new BigDecimal(number.get(position));
        BigDecimal b = new BigDecimal(number.get(position + 1));

        String calculateNumber = "";
        switch (symbol) {
            case "-":
                calculateNumber = String.valueOf(a.subtract(b));
                break;
            case "*":
                calculateNumber = String.valueOf(a.multiply(b));
                break;
            case "/":
                calculateNumber = String.valueOf(a.divide(b, 2, RoundingMode.HALF_UP));//除法保留两位小数
                break;
            default:
                calculateNumber = String.valueOf(a.add(b));
        }
        number.set(position, calculateNumber);//两个数运算完后将计算结果覆盖到第一个数的位置
        calcuStr.remove(position);//每用完一个运算符就删除该运算符
        number.remove(position + 1);//两个数运算完后删除后面的数
        return calculationOrder(calcuStr, number);
    }
}

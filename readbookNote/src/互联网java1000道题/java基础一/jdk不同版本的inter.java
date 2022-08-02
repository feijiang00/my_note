package 互联网java1000道题.java基础一;

/**
 * @date 2021/12/24 9:50
 */
public class jdk不同版本的inter {
    public static void main(String[] args) {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern());
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}

package java刘意.exception;

/**
 * 自定义异常步骤：
 * 1.写好自定义的异常类，继承Exception
 * 2.在代码某处，抛出这个自己定义的异常类即可
 *
 *
 *      Exception 编译异常和运行时异常的父类
 *      * RuntimeException 运行时异常的父类
 *      * 自定义异常需要继承这两大异常的一种
 *
 *
 *      1.声明类a 继承其中一种
 *      2.throw new ExceptionDemo2("你给的分数有误，分数在0-100之间"); 在需要的地方抛出异常，给出提示信息
 *
 *      编译异常和运行异常：
 *          编译异常是需要进行处理的： 1、throws ExceptionDemo2 抛出去
 *
 *          2、try捕捉
 *          try {
 *             t.checkScore(score);
 *         } catch (ExceptionDemo2 exceptionDemo2) {
 *             exceptionDemo2.printStackTrace();
 *         }
 *     }
 */
public class TeacherExceptionTest {
    public static void main(String[] args) throws ExceptionDemo2 {
        int score = 101;

        TeacherException t = new TeacherException();

//        t.checkScore(score);

        try {
            t.checkScore(score);//new throwable 然后和下面的catch匹配
        } catch (ExceptionDemo2 exceptionDemo2) {
            exceptionDemo2.printStackTrace();
        }
    }
}

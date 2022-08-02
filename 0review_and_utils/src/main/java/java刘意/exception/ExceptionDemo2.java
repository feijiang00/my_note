package java刘意.exception;

/**
 * Exception 编译异常和运行时异常的父类
 * RuntimeException 运行时异常的父类
 * 自定义异常需要继承这两大异常的一种
 */
public class ExceptionDemo2 extends  Exception{

    /**
     * public class Exception extends Throwable {
     *     static final long serialVersionUID = -3387516993124229948L;
     *
     *     public Exception() {
     *     }
     *
     *     public Exception(String message) {
     *         super(message);
     *     }
     *
     *     public Exception(String message, Throwable cause) {
     *         super(message, cause);
     *     }
     *
     *     public Exception(Throwable cause) {
     *         super(cause);
     *     }
     *
     *     protected Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
     *         super(message, cause, enableSuppression, writableStackTrace);
     *     }
     * }
     */

    /**
     * public Throwable(String message) {
     *         this.stackTrace = UNASSIGNED_STACK;
     *         this.suppressedExceptions = SUPPRESSED_SENTINEL;
     *         this.fillInStackTrace();
     *         this.detailMessage = message;
     *     }
     */
    //无参构造
    public ExceptionDemo2() {
    }
    //带参构造方法
    public ExceptionDemo2(String message) {
        super(message);
    }
}

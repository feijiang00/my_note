package myself_test.泛型;

/**
 *
 * @date 2022/3/11 21:48
 */
public class 泛型 {

    /**
     * 泛型的测试
     * @param args
     */
    public static void main(String[] args) {

        /*
        一句话解释泛型
        泛型的根本意义：在把类型明确的工作推迟到创建对象或调用方法的时候采取明确的特殊的类型
        除了这里的例子，再给出比如 List 中，List指定String类型中，里面就只能存放String类型
         */
        Stud<Integer> stud = new Stud<>();
        stud.a = 2;
        System.out.println(stud.getA().getClass());
    }

}

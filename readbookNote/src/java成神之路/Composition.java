package java成神之路;

/**
 * @author FeiJiang00
 * @date 2021/11/10 1:20
 *
 * 什么时候使用继承？什么适合使用组合？
 *
 * 先思考这样一个场景
 * 昆虫类，有两个方法，一个攻击，一个移动
 * 然后蜜蜂，继承昆虫，问题来了：移动的话，蜜蜂类中对移动方法进行重写，但是攻击呢？
 * 蜜蜂类中可以这样：
 * public void attack() {
 *         move();
 *         super.attack();
 *     }
 * 直接使用 super.attack()调用父类的攻击方法，
 * 但是这样会出现”两次移动“！
 * 那么有人会说，我重写蜜蜂类中的攻击方法！
 * public void attack() {
 *     move();
 *     System.out.println("Attack");
 * }
 * 会怎么样？：不符合复用思想，代码冗余重复！
 *
 * 造成以上问题的根本原因是父类昆虫中attack攻击包含移到这个方法
 *
 * 这时可以使用组合，所谓组合就是将attack方法和父类昆虫平行，将父类中的attack抽取出来
 * 写一个接口attack，然后用一个类attackImpl去实现该接口
 * 然后蜜蜂去继承昆虫类和实现attack接口，
 */

public class Composition {


}







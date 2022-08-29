package 类


/**
 * Kotlin 当中的接口，被设计得更加强大了，它拥有了部分抽象类才有的特性，同时还可以灵活使用接口组合的特性
 * kotlin中的继承和实现接口 都是 ： 符号
 */
interface Behavior {
    // 接口内的可以有属性
    val canWalk: Boolean

    // 接口方法的默认实现
    fun walk() {
        if (canWalk) {
            // do something
        }
    }
}

class Person2(val name: String): Behavior {
    // 重写接口的属性
    override val canWalk: Boolean
        get() = true
}

fun main(){

}
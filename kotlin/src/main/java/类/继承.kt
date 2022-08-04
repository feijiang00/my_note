package 类

/**
 * kotlin中的继承，和java相反，默认是封闭的，java默认是开放的
 */
//没有声明类型，默认为超类
class AnyB{

}

//继承
open class Ab(){
    open fun walk(){
        println("ab 会走路")
    }
}

class Abc : Ab() {
    //kotlin中，重写，则不是override注解 而是关键字
    override fun walk(){
        println("abc 会走路")
    }
}

fun main(){
    val a = AnyB() //
    //超类中有以下三个函数
    println(a.hashCode())
    println(a.toString())
    println(a.equals("a"))

    val l = Abc()
    println(l.walk())
}
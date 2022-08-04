package 类

import com.sun.webkit.perf.WCFontPerfLogger.log

/**
 * kotlin 类两个显著特点 自定义 setter 和 getter
 */
class Person(val name: String) {
    val isAdult: Boolean
        get() {
            // do something else
            return age >= 18
        }
    var age:Int = 0
        set(value:Int){
            println("age 一旦被赋值 ，我就被会告知，这就是setter方法，: $value")
            field = value // field表示 age
        }


}

fun main(args:Array<String>){
    println("hello kotlin.........")

    val a = Person("shawu")
    a.age =19
    println(a.isAdult)

}
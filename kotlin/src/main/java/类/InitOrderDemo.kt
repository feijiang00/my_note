package 类

/**
 * kotlin一个类中可以包含如下：
 *  构造函数与初始化块
    函数
    属性
    嵌套类与内部类
    对象声明
 */
//sampleStart
class InitOrderDemo(name: String) {
    //声明类的属性
    val name:String = "shawu"
    val age:Int = 12


    //主构造函数
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    //次要构造函数
    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}
//sampleEnd

fun main() {
//    InitOrderDemo("hello")

    val shawu = InitOrderDemo("hello shawu")
    println( shawu.age)
    println( shawu.name)

}
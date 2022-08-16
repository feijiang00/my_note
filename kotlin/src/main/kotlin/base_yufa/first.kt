val PI = 3.14 //不可重新赋值
var x = 0  //可重新赋值

fun add(a:Int, b:Int) = a+b; //函数也可以是表达式，返回值推断出来

fun printSum(a: Int, b: Int): Unit {  //Unit返回类型可以省略
    println("sum of $a and $b is ${a + b}") //输出语句输出变量
}

fun main(args: Array<String>) {
    println(add(1,1))
    printSum(-1, 8)

    println("Hello World!")

    //sampleStart
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"

    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    //sampleEnd
    println(s2)
}



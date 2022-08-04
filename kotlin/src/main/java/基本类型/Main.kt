package 基本类型

fun main(args:Array<String>){

    //在kotlin中所有的都是对象
    val a = 1.1
    println(a.javaClass) //kotlin大部分不需要声明变量的类型，而是可以直接自动识别

    val b:Double = 1.toDouble() //kotlin中所有即对象，没有整型变量

    val baseInt : Int = 9;
    println(baseInt);

    val baseDouble : Double = 9.9;
    println(baseDouble)

    val baseBuEr :Boolean = false;
    println(baseBuEr);

    val str = "1111asdadwsad";
    println(str);

    //kotlin中简洁的字符串模板
    val ab = "shawu"
    println("hello i love $ab ") //字符串模板，变量直接在字符串中输出

    //原始字符串
    val abc = """ 我是什么样子，
        |你给我打印出来就是啥样子
        |你信不
    """.trimMargin()

    println(abc)

}

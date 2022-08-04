package 函数


/*
关键字    函数名          参数类型   返回值类型
 ↓        ↓                ↓       ↓      */
fun helloFunction(name: String): String {
    return "Hello $name !"
}/*   ↑
   花括号内为：函数体
*/


//需要注意一点，kotlin
class Test {

    //单一表达式函数
    fun helloFunction(name: String = "xiao shawu"): String = "Hello $name !"

    //此外kotlin的两个函数魅力：命名参数 和 参数默认值

}

fun main(args:Array<String>){


    println(helloFunction("shawu"))

    //命名参数
    helloFunction(name = "shawu")



}

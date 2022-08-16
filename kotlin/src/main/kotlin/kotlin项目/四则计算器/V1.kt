package kotlin项目.四则计算器

import kotlin.system.exitProcess


val help = """
--------------------------------------
使用说明：
1. 输入 1 + 1，按回车，即可使用计算器；
2. 注意：数字与符号之间要有空格；
3. 想要退出程序，请输入：exit
--------------------------------------""".trimIndent() //三引号格式模板

fun main() {
    while (true) {
        println(help)

        val input = readLine() ?: continue //自动识别，input为字符串类型
        if (input == "exit") exitProcess(0)

        val inputList = input.split(" ") //列表类型
        val result = calculate(inputList)

        if (result == null) {
            println("输入格式不对")
            continue
        } else {
            println("$input = $result") //字符串模板，打印变量
        }
    }
}

private fun calculate(inputList: List<String>): Int? {
    if (inputList.size != 3) return null

    val left = inputList[0].toInt()  //kotlin统一了数组和集合的元素访问操作
    //                           ①
    //                           ↓
    val operation = Operation.valueOf(inputList[1])
    val right = inputList[2].toInt()

    return when (operation) {
//        使用when表达式的时候尽量使用 枚举 和 密封类 类型
        Operation.ADD -> left + right
        Operation.MINUS -> left - right
        Operation.MULTI -> left * right
        Operation.DIVI -> left / right
    }
}

enum class Operation(val value: String) {
    ADD("+"),
    MINUS("-"),
    MULTI("*"),
    DIVI("/")
}
package kotlin项目.四则计算器

import kotlin.system.exitProcess


fun main() {
    while(true) {
        // 初始化，打印提示信息
        println("请输入标准的算式，并且按回车; \n" +
                "比如：1 + 1，注意符合与数字之间要有空格。\n" +
                "输入exit，退出程序。")

        // 第一步，读取输入命令；
        var input = readLine()
        if (input == null) continue
        // 第二步，判断命令是不是exit，如果是则直接退出程序；
        if (input == "exit") exitProcess(0)

        // 第三步，解析算式，分解出“数字”与“操作符”：“1”“+”“2”；
        var inputList = input.split(" ")
        // 第四步，根据操作符类型，算出结果：3；
        var result = calculate(inputList)

        // 第五步，输出结果：1 + 2 = 3；
        if (result == null) {
            println("输入格式不对")
            continue
        } else {
            println("$input = $result")
        }

        // 第六步，进入下一个while循环。
    }
}

// 具体计算逻辑
private fun calculate(inputList: List<String>): Int? {
    if (inputList.size != 3) return null

    // 第七步，取出数字和操作符
    var left = inputList.get(0).toInt()
    var operation = inputList.get(1)
    var right = inputList.get(2).toInt()

    // 第八步，根据操作符的类型，执行计算
    when(operation) {
        "+" -> return left + right
        "-" -> return left - right
        "*" -> return left * right
        "/" -> return left / right
        else -> return null
    }
}
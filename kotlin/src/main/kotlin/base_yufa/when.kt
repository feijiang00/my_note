package base_yufa

/*
    when语句,这里when中的判断是可以写表达式的，很好用
 */
//sampleStart
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
//sampleEnd

fun main() {

    val i: Int = 1
    when(i) {
        1 -> println("一")
        2 -> println("二")
        else -> println("i 不是一也不是二")
    }

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
}
package 类

/**
 * 数据类
 */
// 数据类当中，最少要有一个属性
data class Person3(val name: String, val age: Int)


//枚举类
enum class Human {
    MAN, WOMAN
}

//这里相当于把参数Human代入when表达式中
fun isMan(data: Human) = when(data) {
    Human.MAN -> true
    Human.WOMAN -> false
    // 这里不需要else分支，编译器自动推导出逻辑已完备
}

//密封类
sealed class Result<out R> {
    data class Success<out T>(val data: T, val message: String = "") : Result<T>()

    data class Error(val exception: Exception) : Result<Nothing>()

    data class Loading(val time: Long = System.currentTimeMillis()) : Result<Nothing>()
}

fun display(data: Result<*>) = when(data) {
    is Result.Success<*> -> displaySuccessUI(data)
    is Result.Error -> showErrorMsg(data)
    is Result.Loading -> showLoading()
}

fun showLoading() {

}

fun showErrorMsg(data: Result.Error) {

}

fun displaySuccessUI(data: Result.Success<*>): Any? {
    return null
}

fun main(){

    val tom = Person3("Tom", 18)
    val jack = Person3("Jack", 19)

    println(tom.equals(jack)) // 输出：false
    println(tom.hashCode())   // 输出：对应的hash code
    println(tom.toString())   // 输出：Person(name=Tom, age=18)

    val (name, age) = tom     // name=Tom, age=18
    println("name is $name, age is $age .")

    val mike = tom.copy(name = "Mike")
    println(mike)             // 输出：Person(name=Mike, age=18)


    //----------------------------------------------------------
    //密封类处理



}


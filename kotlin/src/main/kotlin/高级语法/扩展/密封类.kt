package 高级语法.扩展

class 密封类 {
}

sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

fun main(){

    fun getResultMsg(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> "Error is ${result.error.message}"
    }
}
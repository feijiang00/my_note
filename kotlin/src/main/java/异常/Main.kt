package 异常

/**
kotlin中 Unit 类似 java 中函数的void
//下面的几种方法是等价的
fun unitReturn1() {

}
fun unitReturn2() {
return Unit
}
fun unitReturn3(): Unit {
}
fun unitReturn4(): Unit = Unit
 */
fun t():Unit{
    //值得关注的是，kotlin是没有受检异常的，这段代码如果在java中是根本无法运行的
    throw Exception("Hi There!")
}
fun main(array: Array<String>){
    /**
     * Kotlin 中所有异常类继承自 Throwable 类。 每个异常都有消息、堆栈回溯信息以及可选的原因。
     *
     */
    //sampleStart
    try{
       t();
    }catch (e:Throwable){ //kotlin所有的异常都来自Throwable
        println(e.message)
    }finally {
        println("test一下异常")
    }
    //sampleEnd
}
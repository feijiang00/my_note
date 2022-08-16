package base_yufa

/**
 * 针对kotlin中的判空和java中的不同
 */
class NullClass{
    fun nullFun(){}
}
fun main(){

    val nullClass: NullClass? = null
    //  下面是java中的判空逻辑
//    if (nullClass != null) {
//        ullClass.nullFun()
//    }

    nullClass?.nullFun()  //?.表示判空，如果nullClass为空，这行代码不执行
    nullClass!!.nullFun()  //!!.判空，如果为空，不执行，还会抛出错误

    //ps 但是如果想要?.有点作为，那就需要上?: 了
    nullClass?.nullFun()?: println("nullClass 是空的，我有点作为了")
}
package 高级语法.object关键字

/*
object关键字的用法：
    1.
 */
fun main(){

    /*
    kt和java不同的是，不仅可以继承某个类，还可以实现接口

    我们需要继承某个类，同时还要实现 某些接口，为了达到这个目的，我们不得不定义一个内部类，然后给它取个名字。但这样
    的类，往往只会被用一次就再也没有其他作用了。
     */
    val item = object : C(), A,B{
        override fun funA() {
            TODO("Not yet implemented")
        }

        override fun funB() {
            TODO("Not yet implemented")
        }

        override fun funC() {
            TODO("Not yet implemented")
        }

    }
}
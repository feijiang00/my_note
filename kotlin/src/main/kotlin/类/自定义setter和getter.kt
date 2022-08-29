package 类

/**
 * kotlin 类两个显著特点 自定义 setter 和 getter
 * 这里自定义getter，如何理解？
 * 这个是可以改变getter的返回值，比如返回age，但却可以返回 > age ，age+10 等等
 *  但需要注意的是在，这里的getter看似一个方法，确实附着在属性下，因此需要真正理解，比如返回>age 可以定义一个是否成年属性
 */
class Person(val name: String) {
    //是否成年属性
    val isAdult: Boolean
        get() {
            // do something else
            return age >= 18
        }
    var age:Int = 0
        set(value:Int){
            println("age 一旦被赋值 ，我就被会告知，这就是setter方法，: $value")
            field = value // field表示 age
        }


}

fun main(args:Array<String>){
    println("hello kotlin.........")

    val a = Person("shawu")
    a.age =19
    println(a.isAdult)

}
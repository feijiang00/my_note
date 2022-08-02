package base_yufa

class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2
}
fun main() {
//sampleStart
    val rectangle = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")
//sampleEnd

//sampleStart
        val items = listOf("apple", "banana", "kiwifruit")
        for (item in items) {
            println(item)
        }
//sampleEnd

}
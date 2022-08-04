package 控制流程

fun main(array: Array<String>){

    //when 流程判断语句
    val a:Int = 1
    when(a){
        1->{ println("我是 1")}
        2->{
            println("我是 2")
        }
        else->{
            println("我啥也不是")
        }
    }

    //for遍历迭代区间
    for (item in 1..10 step 2){
        println(item)
    }


    //kotlin中的if还可以当做表达式来使用
    val ab = if(a >1) "shawu" else "wusha"
    println(ab)
}

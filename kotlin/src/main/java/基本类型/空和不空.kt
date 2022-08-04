package 基本类型

fun main(){

    var i: Double = 1.0
    var j: Double? = null

//    i = j  // 编译器报错
//    j = i  // 编译通过

    if(j != null){
        i = j
    }

}
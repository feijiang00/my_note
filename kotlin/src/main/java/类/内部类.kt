package 类

class A{
    var a = 1
    //默认的内部类是静态的
    class B{
//        val b = a  无法访问
    }

    //加上inner关键字后，C才是A的内部类
    inner class C{
       val b = a
    }


    /*
    这种设计也是为了规避，java中默认内部类持有对外部的引用，防止内存泄漏
     */
}
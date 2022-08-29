package 类

/**
 * 分析kotlin代码的原理的时候，我们可以将其转为java代码进行对比分析
 *
 * 转换流程： tools中  ——》 kotlin  ——》 show kotlin Bytecode  ——》然后转换出来 Decompile反编译得到java代码
 */
fun main(){
/*
这里给个例子，对于变量的声明，java和kotlin中：
kotlin没有基本类型都是对象，真的是这样么？转为java代码研究看看！
 */
// kotlin 代码

// 用 val 定义可为空、不可为空的Long，并且赋值
    val a: Long = 1L
    val b: Long? = 2L

// 用 var 定义可为空、不可为空的Long，并且赋值
    var c: Long = 3L
    var d: Long? = 4L

// 用 var 定义可为空的Long，先赋值，然后改为null
    var e: Long? = 5L
    e = null

// 用 val 定义可为空的Long，直接赋值null
    val f: Long? = null

// 用 var 定义可为空的Long，先赋值null，然后赋值数字
    var g: Long? = null
    g = 6L

}

/**
 * 对应的java 代码如下：
 *
long a = 1L;
long b = 2L;
long c = 3L;
long d = 4L;

Long e = 5L;e = (Long)null;
Long f = (Long)null;
Long g = (Long)null;g = 6L;


 那么得到结论： kotlin中虽然没有原始类型，，但是通过编译反编译后的java代码中发现，其实在jvm层会自动处理成基本类型
                处理的原则是什么？  只要变量曾经被赋值为null，那么kotlin就无法对其进行优化了
只要基础类型的变量可能为空，那么这个变量就会被转换成 Java 的包装类型。
反之，只要基础类型的变量不可能为空，那么这个变量就会被转换成 Java 的原始类型。

 */
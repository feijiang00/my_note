package 高级语法.扩展


fun String.getLastChar():Char?{ //这里需要加一个问号，因为Char可能会是空
    if(this.isEmpty())
        return null

    return this[this.length - 1] //这里的this 代表具体的“String对象” ，谁调用，就是谁
}

fun main(){
    val str =  "shawu"
    //如果想给str添加新的方法，在java中是不可行的，无法对第三方sdk进行修改，但是kotlin扩展函数可以

    println(str.getLastChar())

    /*
    那么，这个扩展函数的实现原理是什么？总不可能真的对第三方sdk进行修改吧！！！ 老规矩，看看java代码
    public static final Character getLastChar(@NotNull String $this$getLastChar) {
      Intrinsics.checkNotNullParameter($this$getLastChar, "$this$getLastChar");
      CharSequence var1 = (CharSequence)$this$getLastChar;
      return var1.length() == 0 ? null : $this$getLastChar.charAt($this$getLastChar.length() - 1);
   }

   由于 JVM 不理解 Kotlin 的扩展语法，
   所以 Kotlin 编译器会将扩展函数转换成对应的静态方法，而扩展函数调用处的代码也会被转换成静态方法的调用。

     */

}
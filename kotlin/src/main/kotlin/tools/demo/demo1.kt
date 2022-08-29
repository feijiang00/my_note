package tools.demo


/*
针对kotlin中，类的成员变量的get()的本质的研究
 */
class Person1(val name: String, var age: Int) {
    //isAdult本质是一个方法，
//    public final boolean isAdult() {
//        return this.age >= 18;
//    }
    val isAdult
        get() = age >= 18
}


class Person2(val name: String, var age: Int) {
    //isAdult本质是一个final变量
    //private final boolean isAdult;
    val isAdult = age >= 18
}

//其对应的转为java代码后如下：

/*

public final class Person1 {
   @NotNull
   private final String name;
   private int age;

   public final boolean isAdult() {
      return this.age >= 18;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final int getAge() {
      return this.age;
   }

   public final void setAge(int var1) {
      this.age = var1;
   }

   public Person1(@NotNull String name, int age) {
      Intrinsics.checkNotNullParameter(name, "name");
      super();
      this.name = name;
      this.age = age;
   }
}


public final class Person2 {
   private final boolean isAdult;
   @NotNull
   private final String name;
   private int age;

   public final boolean isAdult() {
      return this.isAdult;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final int getAge() {
      return this.age;
   }

   public final void setAge(int var1) {
      this.age = var1;
   }

   public Person2(@NotNull String name, int age) {
      Intrinsics.checkNotNullParameter(name, "name");
      super();
      this.name = name;
      this.age = age;
      this.isAdult = this.age >= 18;
   }
}



 */
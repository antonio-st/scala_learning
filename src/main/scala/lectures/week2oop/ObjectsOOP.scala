package lectures.week2oop

object ObjectsOOP extends App {

  println(Number.Pi)

  // экземпляр объекта
  val newObj = Numbers
  println(newObj.Pi)


  // Компаньоны
  // Объект имеет доступ ко всем полям и методам своего класса-компаньона (в том числе и private)
  println(MyString.apply("hello", "scala").getString) // перепишет MyString
  println(MyString.apply("welcome").getString) // перепишет только поле str в MyString
  // println(MyString("hello", "scala")) //
  // println(MyString("welcome")) //

  // Фабричный метод
  // У объекта отсутствуют передаваемые параметры, метод позволяет передать эти параметры

  val numA = new Number(1)
  val numB = new Number(2)

  val numC = Number(numA, numB)
  println(numA.num, numB.num, numC.num)


}

// Объект

object Numbers {
  val Pi = 3.14
}


// Компаньоны

class MyString(val str: String) {
  private var extra = "extraData"

  def getString: String = str + extra
  // override def toString: String = str + extr
  // можно так чтобы не прописывать .getString
}

object MyString {
  def apply(base: String, extras: String): MyString = {
    val s = new MyString(base)
    s.extra = extras
    s
  }

  def apply(base: String) = new MyString(base)
}



// Фабричный метод

class Number(val num: Int)

object Number {
  val Pi = 3.14

  def apply(x: Number, y: Number): Number = new Number(x.num + y.num)


  // Каков результат выполнения кода:


  object A {
    val a: String = "value a"
    println("object A")
  }

  val aVal = A
  val anotherVal = A

  println(aVal.a)
  println(anotherVal.a)

  // object A
  //value a
  //value a

}



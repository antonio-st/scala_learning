package lectures.week1basics

// все в Scala является выражением (это когда мы возвращаем какое-то, как правило, вычисленное значение)
object Expressions extends App {

  // if-Выражение
  // сразу пишем значение, которое хотим присвоить

  val aCondition = true
  val ifExpressionValue = if (aCondition) "True Condition" else "False Condition"
  println(ifExpressionValue)

  val youStudent = true
  println(if (youStudent) "It's student" else "It not student")


  // Тип Unit
  // Значения нет, а возможность написать, например, вот такой код

  val someVal: Unit = println("I just want to print")


  // задания

  val aNumber = println(if (('1' +: "23").toInt == 24) 24 else 123)

  val myStr = "string".length
  val myRes = if (myStr == 6 & 1 < 2) 1234
  println(myRes)

  println(someVal)



  // Блок кода (Code block)
  // Блок кода - это все те строки кода, что мы пишем в фигурных скобках.
  //Блок кода также является выражением, результат(и тип) которого равен результату(и типу)
  // последнего описанного внутри блока кода выражения.

  val aCodeBlock = {
    val x = 1
    val y = 1 + 7

    if (y - x > 1) true
    else
      false
  }

  println(aCodeBlock)


  val aCodeBlock_2 = {
    val x = 1
    val y = 1 + 7

    if (y - x > 1) true
    else
      false
    "String to return"
  }

  // aCodeBlock_2  вывод поменяется на String - последняя строчка
  println(aCodeBlock.getClass, aCodeBlock_2.getClass)


}

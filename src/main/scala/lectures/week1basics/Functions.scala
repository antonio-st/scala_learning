package lectures.week1basics

// Функции

// Начинается все с ключевого слова def
// За которым следует имя функции
// В круглых скобках (при необходимости) указываются параметры и их типы
// После скобок ставится двоеточие и конкретизируется тип возвращаемого значения


object Functions extends App {
  // можно в одну строку
  def aPerson(appeal: String, surname: String): String = s"$appeal $surname"

  println(aPerson("Mr.", "Smith"))

  // можно с выражением в {}
  def aPerson_2(appeal: String, surname: String) = {
    println(s"Hello, $appeal $surname")
  }

  aPerson_2("Mr.", "Smith")



  // Функция без параметров

  def aParameterLessFunction() = println("Function without parameters")

  // можно вызвать и без скобочек
  aParameterLessFunction
  aParameterLessFunction()



  // Параметры по умолчанию для функции

  def aFunctionDefaultParameter(x: Int, text: String = "I'm default parameter from function") = {
    println(s"x = $x, text = $text")
  }

  aFunctionDefaultParameter(10)
  aFunctionDefaultParameter(10, "None default parameter")



  // Вызов по имени(call-by-name) vs Вызов по значению(call-by-value)

  // Вызов по значению: вычисляем значение 1 раз и используем в функции
  def callByValue(x: Long): Unit = {
    println(s"Call by value: x1 = $x")
    println(s"Call by value: x2 = $x")
  }

  // Вызов по имени: вызывается в момент исполнения, поэтому x2 отличается , прошли доли секунды с момента вызова x1
  def callByName(x: => Long): Unit = {
    println(s"Call by name: x1 = $x")
    println(s"Call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())


  // задания

  def someFunc(): Int = 2 * someFunc() + 1

  def callSomeFunc(x: Int, y: => Int) = println(x)

  // callSomeFunc(someFunc(), 1) // ошибка StackOverflowError
  callSomeFunc(1, someFunc()) // 1 - так как мы используем вызов по имени и рекурсивная функция не запустится.


  // Вложенные функции
  // возможность определить функцию или даже несколько функций внутри одной функции и там же ее(или их) вызвать
  def aMainFunction(): Unit = {
    def aHelpFunction(): Unit = println("I'm here to help")

    aHelpFunction()

  }

  aMainFunction()

  // задание

  def multiply(y: Int) = y * 3

  def aCondition(): Boolean = if (1 < 2) true else false

  def someFunc_2(x: => Int, y: => Int) = {
    if (aCondition) x * 2
    else multiply(y)

  }

  println(someFunc_2(3, 4))


}



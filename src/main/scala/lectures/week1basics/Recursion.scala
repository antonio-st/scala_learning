package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {

  // Циклы
  var i = 0
  while (i < 3) {
    println(s"Hello, i = ${i}")
    i += 1
  }

  // задание whileVal тип Unit

  var j = 0
  val whileVal: Unit = while (j < 3) {
    println(s" Hello #2 , j = ${j}")
    j += 1
  }

  // Рекурсия

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s" Имеем число $n, для которого вычисляем факториал ${n - 1}")
      var res = n * factorial(n - 1)
      // 3 * factorial(2) -> 2 * factorial(1) -> 1 * factorial(1)
      println(s"Вычислили факториал: ${n}")
      res
    }
  }

  println(factorial(3))



  // Хвостовая рекурсия (Tail Recursion) - функциональная форма циклов

  /*
  Как писать функции в стиле хвостовой рекурсии
    1. Определяете функцию. Назовем ее основной.
    2. Внутри основной функции прописываете еще одну функцию. Назовем ее вспомогательной.
    3. В качестве аргументов вспомогательной функции указываете число вызовов (этот аргумент совпадает с одним из
    аргументов основной функции) - плюс аккумулятор, который будет содержать конечный результат.
    4.  Прописываете код с рекурсией в теле вспомогательной функции с использованием аккумулятора
    (так, чтобы значение постепенно накапливалось)
    5. Вызываете вспомогательную функцию из основной функции. Не забудьте указать начальное значение аккумулятора,
     задающее отправную точку всех вычислений. Используйте аргумент по умолчанию для оптимизации кода.
  * */

  def factorialWithTailRecursion(n: Int) = {
    @tailrec
    def loop(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else {
        loop(x - 1, x * acc)
        // 1 -> x = 3 , acc = 3 (3 * 1)
        // 2 -> x = 2, acc = 6 (3 * 2)
        // 3 -> x = 1, acc = 6 (6 * 1)
      }
    }

    loop(n, 1)
  }

  println(factorialWithTailRecursion(3))

  // Вывод слова n раз

  def repeatWord(word: String, n: Int) = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
      // 1 -> 3, Scala(word) Scala(acc)
      // 2 -> 2, Scala(word)  (Scala Scala) - acc
      // 3 -> 1, acc = Scala Scala Scala
    }

    loop(n)
  }

  println(repeatWord("Scala", 3))

  // задание
  // Напишите функцию powerOfTwo, вычисляющую степень двойки.

  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def loop(x: Int, acc: BigInt): BigInt = {
      if (n == x) acc
      else loop(x + 1, 2 * acc)
    }

    loop(0, 1)
  }

  println(powerOfTwo(3))


  println("задание 2")

  /* задание 2
    написать программу, которая:
    увеличивает заданное число x на число y n-ое количество раз
    выводит на экран полученное на шаге 1 число столько раз, сколько в нем цифр, и фразу is the result
  * */

  val fArgs = Array(10, 100, 10)

  def calcDigits(x: Int, y: Int, n: Int) = {
    def loop(i: Int = n, acc: Int = x): Int = {
      if (i <= 0) acc
      else loop(i - 1, acc + y)
    }

    loop()

    def printDig(n: Int = loop().toString.length, acc: String = loop().toString): String = {
      if (n <= 1) s"$acc"
      else printDig(n - 1, s"$acc ${loop().toString}")
    }

    printDig()

  }

  println(s"${calcDigits(fArgs(0), fArgs(1), fArgs(2))} is the result")

  println("задание")
  // задание
  // От вас требуется модифицировать поданную на вход строку так,
  // чтобы слова в ней разместились в обратном порядке. Например,
  // строка I like     Scala должна трансформироваться в Scala like I

  val input = "I like     Scala"

  def reverseWordsOrder(phrase: String) =
    (phrase.
      // разбить и собрать строку
      split("\\s+").
      mkString(" ").
      trim().
      reverse.
      split(" ", -1).
      map(_.reverse))
      .mkString(" ")

  println(reverseWordsOrder(input))

}

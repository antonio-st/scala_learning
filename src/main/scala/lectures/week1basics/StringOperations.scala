package lectures.week1basics

object StringOperations extends App {

  val aString = "Hello, scala !"

  // длина строки  - выведет 17
  println(aString.length)

  // вывод символа по номеру  - "e"
  println(aString.charAt(1))

  // вывод подстроки "scala"
  println(aString.substring(7, 12))

  // разделить строку по пробелу
  println(aString.split(" ").toList)

  // начало строки = "He" : выведет true
  println(aString.startsWith("He"))

  // замена символа
  println(aString.replace("!", " :-)"))

  // перевод в нижний и верхний регистры
  println(aString.toLowerCase())
  println(aString.toUpperCase())

  // обратный вывод
  println("scala".reverse)

  // первые 3 элемента
  println(aString.take(3))

  // выбираем подстроку и выводим 5 элементов
  println(aString.substring(7, 14).take(5))

  println(aString.substring(13, 14))

  // задания
  println("*** TASKS*** \n")

  val aString2 = "Scala course"
  println(aString2.take(5).toUpperCase())
  println(aString2.substring(0, 5).toUpperCase())

  println("*** Конвертируем строку в число и число в строку *** \n")

  val aNumber = "42".toInt
  println(s"$aNumber, ${aNumber.getClass}")

  val aNumber_2 = 28.toString
  println(s"$aNumber_2, ${aNumber_2.getClass} ")


  println("***   Добавление в начало и конец *** \n")
  // +: Добавление в начало
  // 'a' - char : одинарные кавычки
  // "bc" - string : двойные кавычки
  println('a' +: "bc")

  // оператор +: присоединяет только значения типа Char
  println('1' +: "42" :+ '3')

  // оператор ++ указывает, что присоединять будем несколько элементов
  println("a" ++ "bc" ++ "de")

  // оператор + : подойдут любые значения
  println("48" + "de" + '1')

  // добавит элемент в начало List
  println(1 +: List(2, 3))

  // ++ присоединит несколько List
  println(List(1, 2) ++ List(3, 4))

  // оператор +: добавит список в начало
  println(List(1, 2) +: List(3, 4))

  // оператор +: добавит список в конец
  println(List(1, 2) :+ List(3, 4))

  // s-интерполятор и raw
  // /n перенос на след строку /t пробел
  println("***   интерполяторы  *** \n")

  val name = "John"
  val surname = "Anderson"
  println(s"Hello, Mr. ${name} $surname")

  // выполняет переносы в строке
  val someString = "This is \n simple string"
  println(raw"$someString")

  val someString_2 = "This is \t simple string # 2"
  println(raw"$someString_2")

  //задание
  val link = "https://stepik.org"
  println(s"The link is \t $link")
  println(s"The link is $link.toUpperCase")
  println(raw"The link is \t $link")
  println(link :++ "/catalog")
}

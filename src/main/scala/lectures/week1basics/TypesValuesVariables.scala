package lectures.week1basics

object TypesValuesVariables extends App {

  val aLong = 11L
  val bFloat = 28F
  val someFloatVal = 53.249
  println(someFloatVal.getClass)
  println(bFloat.getClass)

  var anInt = 1
  anInt += 1
  println(anInt)

  // символ только через одинарные кавычки
  val aChar = 'c'
  println(s"${aChar}, ${aChar.getClass}")
}



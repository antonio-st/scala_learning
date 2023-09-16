package lectures.week2oop


// Обобщения (Generics)


object Generics extends App {
  def countSum(nums: List[Int]): Int = {
    nums.sum
  }

  val myList = List.fill(50)(util.Random.nextInt(50)).sorted.distinct
  println(countSum(myList))


  // Обобщения - это такая штука, которая позволяет нам использовать один и тот же код, но для разных типов данных.

  def createElement[A](el: A): A = el

  println(createElement("It's scala !"))
  println(createElement(10))
  println(createElement(3.14))
  println(createElement(true))

  // можно подаить любой тип , в том числе с объекта класса
  case class Vehicle(name: String)

  val aVechile = Vehicle("Generics")
  println(createElement(aVechile.name))

  // создайте обобщенный метод
  def getElementType[A](el: A): A = {
    println(s"argument of ${el.getClass.getSimpleName} type")
    el
  }

  getElementType("test")
  getElementType(3.14)

  // работа со списками
  // метод, рандомно выбирающий число из целочисленного списка:

  def randomItem[A](items: List[A]): A = {
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }

  println(randomItem(List(2, 4, 8, 12)))
  println(randomItem(List(3.14, 9.18, 10)))
  println(randomItem(List("apple", "orange", "banana")))


}


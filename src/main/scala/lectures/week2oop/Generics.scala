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
  case class Vehicles(name: String)

  val aVechile = Vehicles("Generics")
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

  // обобщения применяются к классам(class), трейтам(trait),  но никак не к объектам (object)

  class SomeClass[T] {
    def someFunc(aVal: T) = println(s"${aVal} generic class is used")
  }

  val someClass = new SomeClass["test"]
  println(someClass.someFunc("test"))


  // пример на парковках

  trait Thing

  class Vehicle extends Thing

  class Car extends Vehicle

  class Ambulance extends Car

  class Taxi extends Car

  class Jeep extends Car

  class Bicycle extends Vehicle

  class Tricycle extends Bicycle

  // нам необходимо прописать класс Parking, который бы позволил вести учет припаркованного транспорта,
  // причем класс должен быть универсальным и должен уметь работать с транспортом всех указанных типов -
  // а это означает, что при написании класса придется задействовать обобщения:

  class Parking[T](val vechile: T)

  val parking = new Parking[Bicycle](new Bicycle)
  val jeep = new Parking[Jeep](new Jeep)

  // Ограничения типов (верхнее <: и нижнее >:)

  class Parking2[T <: Vehicle](val vechile: T) // допускается использовать либо непосредственно сам тип Vehicle, либо его подтипы, те Car, Ambulance, Taxi...

  class Parking3[T >: Vehicle](val vechile: T) // в качестве Т мы ожидаем либо сам тип Vehicle, либо его супертипы те Thing
  

}


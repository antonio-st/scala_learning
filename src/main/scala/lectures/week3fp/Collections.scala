package lectures.week3fp

// Коллекции (Collections)
object Collections extends App {

  /*
  Set(т.е.без дубликатов или повторяющихся элементов)
  Seq(т.е.у каждого элемента свой индекс, например - Vector, Range, List, Array)
  Map(т.е.пары ключ -значение)
*/

  //  Set

  val emptySet: Set[Int] = Set()
  val aSet = Set(10, 20, 30, 40)
  val anotherSet = Set(30, 40, 50, 60)

  println(aSet.isEmpty)

  // head и tail
  println(emptySet.isEmpty)
  println(aSet.head, aSet.tail)

  println(aSet.min, aSet.max) // Set(30, 40)

  // вхождение множеств
  println(aSet.intersect(anotherSet)) // Set(30, 40)

  println(aSet ++ anotherSet) // HashSet(10, 20, 60, 50, 40, 30)


  // Array
  val anArray: Array[String] = Array("h", "e", "l", "l", "o", ".")

  // обновление элемента
  anArray(5) = "!"
  println(anArray(5))

  println(anArray.mkString("-")) // h-e-l-l-o-!

  val numberSeq: Seq[String] = anArray
  println(numberSeq) // ArraySeq(h, e, l, l, o, !)

  // Tuple (кортежи)

  val aTuple: (Int, String) = ((100, "Scala"))

  val sameTuple: (Int, String, String) = Tuple3(100, "Scala", "Test")

  println(aTuple.getClass.getSimpleName)
  println(sameTuple.getClass.getSimpleName)

  // обращение к элементам

  println(aTuple._1)
  println(sameTuple._3)

  // Range

  val aRange = 1 until 3
  aRange.foreach(x => print(x)) // 12

  (1 to 3).foreach(x => println("Hello ")) // вывести несколько раз на экран что либо

  val aRangeVector: Vector[Int] = (1 to 10).toVector
  println(aRangeVector, aRangeVector(2))

  // map, flatMap, filter

  val fruits = List("apple", "banana")
  val mapRes = fruits.map(_.toUpperCase() + ".") // List(APPLE., BANANA.)
  val flatMapRes = fruits.flatMap(_.toUpperCase() + ".") // List(A, P, P, L, E, ., B, A, N, A, N, A, .)

  println(mapRes)
  println(flatMapRes)

  // пройтись по списку(ам)

  val list_1 = List(1, 2)
  val list_2 = List("a", "b", "c")

  val forCombinations = for {
    i <- list_1
    j <- list_2
  } yield i + j

  println(forCombinations) // List(1a, 1b, 1c, 2a, 2b, 2c)

  // аналог foreach

  val combinations = list_1.flatMap(i => list_2.map(j => i + j))
  println(combinations) // List(1a, 1b, 1c, 2a, 2b, 2c)

  // filter
  val combinationsFilter = list_1.filter(_ > 1).flatMap(i => list_2.map(j => i + j)) // List(2a, 2b, 2c)
  println(combinationsFilter)


  // Для каждого элемента списка мы хотим вычислить длину строки.
  // В результате у нас должен получиться список туплов

  val progLanguages2 = List("java", "scala", "python")

  val outTup = progLanguages2.map(x => (x, x.length))
  println(outTup)

  //  теперь вместо списка туплов мы хотим получить просто список языков программирования

  val outList = progLanguages2.map(_.toUpperCase()) // List(JAVA, SCALA, PYTHON)
  println(outList)

  val outList2 = for { //List(JAVA, SCALA, PYTHON)
    lng <- progLanguages2
  } yield lng.toUpperCase

  println(outList2)

  val outList3 = for (lng <- progLanguages2) yield lng.toUpperCase // List(JAVA, SCALA, PYTHON)
  println(outList3)

  // совместить 2 списка по совпадению аббревиатур

  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")

  val out_len = for {
    x <- lngAbbrev
    y <- progLanguages if (x == y.substring(0, x.length).toUpperCase())
  } yield (x, y)

  println(out_len)

  // Что выведет код
  println(Seq(3, 4, 3, 3).sorted.search(3)) // Found(0)


  println(Array.ofDim[String](1).foreach(println)) // null
  println(Array.ofDim[Boolean](1).foreach(println)) // false
  println(Array.ofDim[Int](1).foreach(println)) // 0

  // Что выведет код
  val sampleTuple = new Tuple2(2, "Hello, World")
  println(sampleTuple.copy(_2 = "Scala").swap._1 + 5) // заменит 2 элемент при копировании, потом возьмет 1 и прибавит 5 // Scala5
  // .swap - поменяли элементы местами, получили (Scala,2)


  // Укажите для каждого кода соответствующий ему результат, если имеем:

  val list = List(1, 2, 3)
  val doubler = (x: Int) => List(x, x * 2)

  println(list.flatMap(doubler)) // List(1, 2, 2, 4, 3, 6)
  println(doubler(5)) // List(5, 10)
  println(list.map(doubler)) // List(List(1, 2), List(2, 4), List(3, 6))

  // Какой код позволит получить результат List(80, 800, 8000, 90, 900, 9000, 100, 1000, 10000) для списков

  val nums1 = List(1, 2, 3)
  val nums2 = List(4, 6, 7)
  val nums3 = List(10, 100, 1000)

  println(nums1.flatMap(a => nums2.filter(_ % 2 == 1).flatMap(b => nums3.map(c => a + b * c)))) // List(71, 701, 7001, 72, 702, 7002, 73, 703, 7003)
  println(nums1.flatMap(a => nums2.filter(_ % 2 == 1).flatMap(b => nums3.map(c => (a + b) * c)))) // совпадает
  println(for {
    a <- nums1
    b <- nums2
    c <- nums3
  } yield (a + b) * c) // -

  println(nums1.flatMap(a => nums2.flatMap(b => nums3.filter(_ % 2 == 1).map(c => (a + b) * c)))) // пустой

  println(for {
    a <- nums1
    b <- nums2 if b % 2 == 1
    c <- nums3
  } yield (a + b) * c) // совпадает
}




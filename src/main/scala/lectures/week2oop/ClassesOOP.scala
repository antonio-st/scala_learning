package lectures.week2oop

object ClassesOOP extends App {

  // ====== Классы / Конструктор класса / Тело класса

  val student = new Student(1, "Anderson")
  student.someFunc()
  println(student.name) // сначала напечатает то, что в классе, а потом выполнит эту инструкцию



  // ====== Методы класса
  println("Методы класса \n")

  // this позволяет компилятору различать параметры класса и параметры метода класса.

  val student_2 = new Student_2(2, "Anastasia")
  println(student_2.getId("Svetlana", 3)) // напечатает 2 раза параметры переданные в метод класса
  println(student_2.getIdFromThis("Svetlana", 3)) // напечатает сначала то, что передали в метод, потом поля класса (this.)



  // ====== Перегрузка метода(Overloading)
  println("Перегрузка метода(Overloading) \n")

  val student_3 = new Student_3(4, "Lydmila")
  // вызов одинаковых методов с разными полями
  println(student_3.getIdFromThis("Anton", 5))
  println(student_3.getIdFromThis)


  // ====== Перегруженные конструкторы
  println("Перегруженные конструкторы \n")
  val student_4 = new Student_4(name = "Lyudmila")
  println(student_4.name)

}

class Student(id: Int, val name: String) {
  // Student(id: Int, val name: String) - конструктор класса
  // чтобы сделать например name членом класса(определяется через точку), нужно добавить var или val
  println("Print from class Students") // печать при создании экземпляра класса

  def someFunc() = {
    println(s"| id: $id | name: $name |")
  }

}


class SomeClass(a: Int, b: Int, val c: Int) {
  def someFunc(): Int = b
}

/*
a - существует только в качестве локальной переменной конструктора.Тогда доступность / недоступность объясняется областью видимости
b - использовано в функции(ключевое слово -функция) внутри класса
    ,поэтому доступность / недоступность объясняется тем
    ,что b является private полем
c - наличие val делает с полем класса , для которого существует геттер , что и объясняет доступность вне класса

 */


class Student_2(id: Int, val name: String) {
  def getId(name: String, id: Int): String = s"$name has ID $id and $name has ID $id"

  def getIdFromThis(name: String, id: Int): String = s"$name has ID $id and ${this.name} has ID ${this.id}"
}


class Student_3(id: Int, val name: String) {
  def getIdFromThis(name: String, id: Int): String = s"$name has ID $id and ${this.name} has ID ${this.id}"

  // перегрузка метода getIdFromThis
  def getIdFromThis: String = s"here is $name ID $id"
}


class Student_4(id: Int = 0, val name: String = "NoName") {
  // def this(name: String) = this(0, name) // перегрузка id (значение по умолчанию)
  // def this() = this(0, "NoName") // перегрузка name
  println(id)
  // лучше сделать проще, указав параметры по умолчанию
  //class Student_4(id: Int = 0, val name: String = "NoName")

}




/* ============= Наследование  =============

 Благодаря наследованию - класс может получить доступ к полям и методам другого класса
 (с условием, что те не отмечены, как private). Наследование производится посредством ключевого слова extends.

 При наследовании у нас появляется доступ ко всем полям и методам родительского класса, которые не являются private.

* protected
 protected работает немного по другому, делая отмеченные поля и методы доступными для класса и его подкласса,
 но недоступными вне их тел

 * private
 посредством private контролируется видимость конструктора класса, т.е. мы позволяем создание экземпляра класса только через методы объекта.
 для .toString существует синтаксический сахар, поэтому println(pizza) на самом деле println(pizza.toString

 * Переопределение (override)
 Применяется, когда для подкласса хотим применить метод из родительского класса, но с имплементацией, отличной от начальной.
 Либо когда необходимо изменить значение переменной родительского класса.

* Полиморфизм
Полиморфизм подразумевает замену типов

* Защита от переопределения
  - использование ключевого слова final перед членами класса, для которых нужно запретить override
  - использование ключевого слова final для целого класса (что вообще запретит extends этого класса )
  - использование ключевого слова sealed для класса
  (это более мягкая версия final, поэтому допускается extends в текущем файле, но воспрещается вне этого файла)

* Абстрактные классы (abstract classes)
  - Бывают ситуации, когда небходимо в классе задать только поле или метод, а имплементацию прописывать в подклассах,
    подстраивая ее под каждый конкретный случай.
  - В абстрактном классе абстрактные поля мы оставляем пустыми, а абстрактные методы без тела.
  - Это значит, что мы не можем создать экземпляр абстрактного класса, пока абстрактные методы и поля не прописаны должным образом.

* Анонимные классы (Anonymous classes)
  Мы отметили, что мы не можем создать экземпляр абстрактного класса, пока абстрактные методы и поля не прописаны должным образом

* Трейты (traits)
    трейты не могут задаваться с параметрами
    можно указать несколько трейтов для одного класса
    трейты описывают конкретное поведение для конкретной ситуации



*/
object Inheritance extends App {

  val student = new Students
  println(student.greet)
  // println(student.greet_private) не сработает, так как метод приватный


  // extend для класса с параметрами
  val studentsInfo = new Students_2(35, "Neo", 1)

  val studOverride = new Student_3("Lyuda", 28, 2, "female")
  println(studOverride.greet)
  println(studOverride.gender)


  // Полиморфизм (polymorphism) объект типа Person_3 , но вызвали переопределенный метод greet класса Student_3
  val aPerson: Person_3 = new Student_3("Nastya", 35, 3, "female")
  println(aPerson.greet)


  // Анонимные классы (Anonymous classes)
  val someSorce = new BaseDataSource("someDS") {
    override val user: String = "someUser"

    override def connect: String = "someUserConection"
  }
  println(someSorce.getClass)

  // Трейты

  val checkConnection = new SomeDataSource("someUser")
  println(checkConnection.checkCredentials, checkConnection.connect)


}


// супер класс (от него отнаследовались)
class Person {
  def greet: String = "Hi, it scala !"

  private def greet_private: String = "Hi, it private func !"

  // вызвать извне не получится
  protected def greet_protected: String = "Hi, it protected func !"
}

// класс Student, расширяющий ранее созданный класс Person.
// greet_protected сработает, protected позволит использовать метод внутри класса
class Students extends Person {
  println(greet_protected)
}


// при создании экземпляра класса Student - сначала потребуется совершить вызов конструктора из родительского класса.
// Чтобы все заработало - необходимо доуказать пропущенные параметры
class Person_2(age: Int, name: String) {
  // def this() = this(35, "Neo")  - тогда можно параметры при наследовании не указывать

  def greeting = println(s"Hello $name, $age")
}

class Students_2(age: Int, name: String, id: Int) extends Person_2(age, name) {
  println(greeting)
}

// Полиморфизм (polymorphism)

class Person_3(name: String, age: Int) {
  val gender = "n/a"

  def greet: String = "Hello"

  def this() = this("John", 30)
}

class Student_3(name: String, age: Int, id: Int, studGender: String) extends Person_3 {
  override def greet: String = s"${super.greet} $name "

  // вызвали метод из суперкласса
  override val gender: String = studGender
}


// Защита от переопределения
sealed class Person_4(name: String, age: Int) { // запретит наследование класса при вызове из других файлов
  // final class Person_4(name: String, age: Int) {  запретит наследование класса
  val gender = "n/a"

  // final def greet: String = "Hello"  запретить override
  def greet: String = "Hello"

  def this() = this("John", 30)
}

class Student_4(name: String, age: Int, id: Int, studGender: String) extends Person_4 {
  override def greet: String = s"${super.greet} $name "

  // вызвали метод из суперкласса
  override val gender: String = studGender
}

// абстракция

abstract class BaseDataSource(dataSourceName: String) {
  // реализованные методы в классе
  def save: String = {
    s"Save method implemented"
  }

  def delete: String = {
    s"Delete method implemented"
  }

  // пустые абстрактные поля
  val user: String

  def connect: String
}

class PublicDataSource(ds: String) extends BaseDataSource(ds) {
  // override можно пропустить
  val user: String = "publicUser"

  def connect: String = "Public Data Source, no password needed"
}


// Трейты (traits)

trait PublicCon {
  def showNotificator: String
}

trait PrivateConnection {
  def checkCredentials: Boolean
}

// можно наследовать только 1 супер класс и трейты больше одного
class SomeDataSource(ds: String) extends BaseDataSource(ds) with PublicCon with PrivateConnection {
  val user: String = "publicUser"

  def connect: String = "Public Data Source, no password needed"

  override def showNotificator: String = s"This connection is Public"

  override def checkCredentials: Boolean = true

}
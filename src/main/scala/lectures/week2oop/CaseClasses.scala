package lectures.week2oop

// Классы образцы (Case classes)

object CaseClasses extends App {

  /* Любой case класс имеет объект-компаньон. В таком объекте-компаньоне всегда присутствует метод apply.
  т.е можно создать объект без new
  */

  case class Person(name: String, occupation: String)

  /* Параметры класса по умолчанию являются val полями
  Это значит, что вы автоматически получаете к ним доступ без дополнительных манипуляциий
*/
  val bob = Person("Bob", "Developer")
  println(bob.name, bob.occupation) // (Bob,Developer)


  // Метод toString (который имеет свой синтаксический сахар, поэтому можно обойтись вообще без явного
  // прописывания имени этого метода в коде) избавляет вас от абракадабры, выводимой в обычном классе.

  println(bob) // Person(Bob,Developer)

  /* Доступен метод equals

   Обычно при обсуждении метода equals(==) принято говорить о reference level equality и content level equality.Одним из свойств
   case class’ов является обязательное наличие списка параметров (пусть даже пустого)
   , что объясняет существование прописанного специально для них метода equals
   , представляющего content level equality и позволяющего производить сравнение по структуре
   , а не по ссылкам
  */
  val bob_clone = Person("Bob", "Developer")
  println(bob == bob_clone) // true

  /* Доступен метод copy
 Метод позволяет как полностью скопировать экземпляр класса, так и скопировать с измененными аргументами конструктора.
*/
  val another_bob = bob.copy("Bob", "QA")
  println(another_bob) // Person(Bob,QA)


  case class Course(title: String, instructor: String)

  object Course {
    def apply(instructor: String): Course = Course("AdvancedScala", instructor)
  }

  val scalaCourse = Course("Scala", "Bob")

  // val course = new Course("Scala")
  val course = new Course("Scala", "Bob")
  val course2 = scalaCourse.copy("AdvancedScala")
  val course3 = scalaCourse.copy()
  val course4 = Course("Alice")
  val course5 = Course("Scala", "Bob")
}

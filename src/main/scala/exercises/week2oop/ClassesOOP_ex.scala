package exercises.week2oop

object CaseClasses_ex extends App {

  // ==== 1 Расположите значения, выводимые принтом, в порядке их появления на экране.
  println("Задание 1 \n")
  val courses = new Courses("Scala", "Bob")
  val student = new Student("Sam")

  // выведет первым print при создании экземпляра класса Course, а потом уже поля класса по порядку для Student
  // потом для Course
  println(student.name)
  println(courses.title)
  println(courses.instructor)
  // ==== 1

  // ==== 2
  println("Задание 2 \n")
  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")




  // ====  3
  println("Задание 3 \n")

  println("* instructor *")

  val instructor = new Instructor(1, "tHOMas", "AndersoN")
  println(instructor.fullName()) // Thomas Anderson
  println(instructor.id) // 1

  println("* Course *")

  val course = new Course(2, "ASOU", "2008", instructor)
  println(course.getID()) // 12 (1 + 2 str)

  println(course.isTaughtBy(new Instructor(11, "Nevel", "Dolgopups"))) // false
  println(course.isTaughtBy(instructor)) // true


  println(course.copyCourse("2009").releaseYear) // 2009
  println(course.releaseYear) // 2008


}


// КЛАССЫ


// ==== 1
class Student(val name: String)

class Courses(val title: String, val instructor: String) {
  val id = "cs_101"
  println(id)
}
// ==== 1


// ==== 2 Дан код, в котором пропущена строка:
// Что именно надо дописать, чтобы на выходе было John's salary is 0.0?

class Employee(val name: String, var salary: Double) {
  // здесь пропущена строка кода
  def this(name: String) = this(name, 0.0)

  def this() = this("John", 0.0)

}
// ===================== 3 задание =================

// .toLowerCase.capitalize
// "is There any other WAY".split(' ').map(_.capitalize).mkString(" ")
// "is There any other WAY".toLowerCase.split(' ').map(_.capitalize).mkString(" ")


class Instructor(val id: Int, name: String, surname: String) {
  def fullName() = { // находим 1 символ и переводим его в верхний регистр

    val firstCharName =
      (name.
        trim.
        substring(0, 1).
        toUpperCase()
        )

    val nameFiltered = firstCharName + // находим подстроку со 2го символа, и переводим в нижний регистр
      // Суммируем 1 символ и полученную строку
      (name.
        trim.
        toLowerCase().
        substring(1)
        )
    val firstCharSurname = (
      surname.
        trim.
        substring(0, 1).
        toUpperCase()
      )
    val surnameFiltered = firstCharSurname +
      (
        surname.
          trim.
          toLowerCase().
          substring(1)
        )

    s"$nameFiltered $surnameFiltered"
  }
}


class Course(courseID: Int, title: String, val releaseYear: String, instructor: Instructor) {

  def getID() = {
    // - getID: возвращает id в формате courseID + instructor.id
    // (например, если courseId = 1, а instructor.id = 2, то метод вернет 12)
    s"${instructor.id.toString + courseID.toString}"
  }

  def isTaughtBy(instructor: Instructor) = {
    // проверяет, является ли указанный человек инструктором курса
    // т.е передаем экземпляр класса Instructor на вход
    if (this.instructor.id == instructor.id) true
    else false
  }

  def copyCourse(newReleaseYear: String): Course = {
    new Course(this.courseID, this.title, newReleaseYear, this.instructor)
  }
}







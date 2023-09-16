package lectures.week2oop

object Traits extends App {

  val myColor = new MixedColor
  println(myColor.color)
  println(myColor.color("orange"))

}

trait Color {
  def color: Unit
}

trait Red extends Color {
  override def color: Unit = println("red color")
}

trait Green extends Color {
  override def color: Unit = println("green color")
}

class MixedColor extends Red with Green {
  override def color: Unit = super.color // println("mixed color")

  def color(color: String): String = s"i am mixed color with $color"
}
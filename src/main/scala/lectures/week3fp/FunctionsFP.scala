package lectures.week3fp

object FunctionsFP extends App {

  val strlen = (enterStr: String) => enterStr.length

  println(strlen("Hello, world!"))

  val randomGenerator = new scala.util.Random
  println(randomGenerator.nextInt(600))

  val randomGenerator2 = new scala.util.Random
  println(Seq.fill(100)(randomGenerator2.nextInt(600)))

}

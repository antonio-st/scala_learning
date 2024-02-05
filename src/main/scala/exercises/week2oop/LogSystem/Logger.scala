package exercises.week2oop.LogSystem

import scala.annotation.tailrec

class Logger(val msgNum: Int = 0) {
  // система логирования
  def info = {
    new Logger(msgNum + 1)
    println("INFO New Message")
  }

  def info(msgCount: Int): Logger = {
    @tailrec
    def loop(msgCount: Int = msgCount, acc: Int = msgNum): Logger = {
      if (msgCount <= 0) new Logger(acc)
      else {
        println("INFO New Message")
        loop(msgCount - 1, acc + 1)
      }
    }

    loop()
  }

}

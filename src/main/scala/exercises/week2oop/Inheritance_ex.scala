package exercises.week2oop

object Inheritance_ex extends App {

  val button = new Button("radio")
  println(button.click())
  val roundedButton = new RoundedButton("menu")
  println(roundedButton.click())
  val testButton = new TestButton
  println(testButton.click())
}

// Какой код необходимо прописать перед // пропущенный код, чтобы все работало и
// This is pizza успешно выводилась на экран: -

// посредством private контролируется видимость конструктора класса, т.е. мы позволяем создание экземпляра класса только через методы объекта.
// для .toString существует синтаксический сахар, поэтому println(pizza) на самом деле println(pizza.toString)


class Pizza private {
  override def toString = "This is pizza"
}

object Pizza {
  val pizza = new Pizza

  def getInstance: Pizza = {
    pizza
  }
}

object TestPizza extends App {

  val pizza = Pizza.getInstance // ваш код здесь

  println(pizza)
}


/* ========================================================================
Ваша задача - реализовать два класса: Button и RoundedButton.

Для класса Button

предусмотрите возможность указания label типа String при создании экземпляра класса
  пропишите метод def click(): String, возвращающий строку, в которой указан label,
  заданный при создании кнопки:  button -label- has been clicked


Для RoundedButton

предусмотрите наледование от Button реализуйте метод click, который похож на родительский метод click,
но в отличие от него содержит слово rounded перед button: rounded button -label- has been clicked


Учтите, что в коде задан еще один класс: TestButton. И выглядит этот класс следующим образом: class TestButton extends Button.
 В классе прописан только метод click, больше ничего.

 Для этого класса метод click (отметим еще раз, класс TestButton уже содержит реализацию данного метода )
 всегда выводит test button -test- has been clicked
Убедитесь, что вы написали весь необходимый код, чтобы такое задание класса TestButton было возможно.



*/


class Button(label: String = "test") {
  def click(): String = s"button -${label}- has been clicked"
}

class RoundedButton(label: String) extends Button(label) {
  override def click(): String = s"rounded ${super.click()}"
}

class TestButton extends Button {
  override def click(): String = s"test ${super.click()}"
}


// ====================


object Polimorfizm_1 extends App {
  abstract class Event {
    def trigger(eventName: String): Unit
  }

  class Listener(val eventName: String, var event: Event) {
    def register(evt: Event) {
      event = evt
    }

    def sendNotification() {
      event.trigger(eventName)
    }
  }

  val notification: Listener = new Listener("mousedown", null)

  val newEvent = new Event {
    override def trigger(eventName: String) = {
      s"mousedown"
    }
  }

  notification.register(newEvent)
  println(notification.sendNotification())
}



// ==========================


//trait Configs {
//  val ACCOUNT_TYPE_DEFAULT = "free"
//  val ACCOUNT_TYPE_PAID = "paid"
//  val SUBSCRIPTION_STATUS = "active"
//}
//
//object Settings {
//  case class AccountSettings(
//                              email: String,
//                              password: String,
//                              picture: String)
//
//  case class SubscriptionSettings(
//                                   payment: String,
//                                   notifications: String,
//                                   expiration: String)
//}
//
//abstract class Subscriber {
//  def subscribe(settings: Settings.SubscriptionSettings): Unit = println("subscribed")
//}
//
//abstract class Unsubscriber {
//  def unsubscribe(): Unit = println("unsubscribed")
//}
//
//abstract class Account(accountID: String, settings: Settings.AccountSettings) {
//  def info(): Unit
//}
//
//class FreeAccount extends Configs(
//  accountID: String,
//  settings: Settings.AccountSettings) {
//
//  override def info(): Unit = println(s"Account Type: $ACCOUNT_TYPE_DEFAULT")
//}
//
//class PaidAccount(
//                   accountID: String,
//                   settings: Settings.AccountSettings)
//  extends Account {
//
//  override def info(): Unit = {
//    println(s"Account Type: $ACCOUNT_TYPE_PAID")
//    println(s"Subscription Status: $SUBSCRIPTION_STATUS")
//  }
//}
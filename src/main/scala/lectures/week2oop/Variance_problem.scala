package lectures.week2oop

// Вариативность (Variance problem)

object Variance_problem {

  class Fruit

  class Apple extends Fruit

  class Banana extends Fruit

  // Инвариантность(Invariance)

  class InvariantList[A]

  // т.е. тип, указанный слева, должен совпадать с типом в правой части
  val invariantListFruit: InvariantList[Fruit] = new InvariantList[Fruit]


  // Ковариантность (Contravariance)
  // Ковариантность подразумевает, что раз Apple наследуется от Fruit, то и List[Apple] можно
  // рассматривать как потомка List[Fruit]

  class CovariantList[+A]

  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]

  // Контравариантность (Contravariance)

  class ContravariantList[-A]

  val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]
}

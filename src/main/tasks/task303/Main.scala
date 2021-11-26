package tasks.task303

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val as = Vector.fill(n)(sc.nextInt)
  val ans = (1 until n).foldLeft(Vector.empty[Int] :+ 0) {
    case (costs, i) =>
      if (i == 1) {
        costs :+ as(i)
      } else {
        val c1 = as(i) + costs(i - 1)
        val c2 = 2 * as(i) + costs(i - 2)
        costs :+ c1.min(c2)
      }
  }
  println(ans.last)
}

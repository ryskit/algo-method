package tasks.task323

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val ds = Vector.fill(m)(sc.nextInt)
  val dp = new Array[Boolean](n + 1)
  dp.update(0, true)
  (1 to n).foreach { i =>
    (0 until m).foreach { j =>
      if (i - ds(j) >= 0 && dp(i - ds(j))) {
        dp.update(i, true)
      }
    }
  }
  println(if (dp(n)) "Yes" else "No")
}

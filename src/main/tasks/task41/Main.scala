package tasks.task41

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val as = Vector.fill(n)(Vector.fill(3)(sc.nextInt))

  val dp = (1 until n).foldLeft(Vector(as.head)) {
    case (dp, i) =>
      val dp0 = dp(i - 1)(1).max(dp(i - 1)(2)) + as(i)(0)
      val dp1 = dp(i - 1)(0).max(dp(i - 1)(2)) + as(i)(1)
      val dp2 = dp(i - 1)(0).max(dp(i - 1)(1)) + as(i)(2)
      dp :+ Vector(dp0, dp1, dp2)
  }

  println(dp(n - 1)(0).max(dp(n - 1)(1)).max(dp(n - 1)(2)))
}

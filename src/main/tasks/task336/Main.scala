package tasks.task336

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val as = Vector.fill(n - 1)(sc.nextInt)
  val dp: Array[Array[Boolean]] = Array.ofDim(n, m)
  dp(0)(0) = true
  (0 until n - 1).foreach { i =>
    (0 until m - 1).foreach { j =>
      if (dp(i)(j)) {
        val moveX = as(i) + j
        dp(i + 1)(j) = true
        if (moveX <= m - 1) {
          dp(i + 1)(moveX) = true
        }
      }
    }
  }
  val ans = dp(n - 1).foldLeft(0) {
    case (sum, res) => if (res) sum + 1 else sum
  }
  println(ans)
}

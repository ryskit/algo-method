package tasks.task334

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val as = Vector.fill(n)(Vector.fill(n)(sc.nextInt))
  val dp: Array[Array[Int]] = Array.ofDim(n, n)
  dp(0)(0) = as(0)(0)

  (0 until n).foreach { i =>
    (0 until n).foreach { j =>
      // 上から
      if (i - 1 >= 0) {
        val prev = dp(i - 1)(j)
        val current = as(i)(j)
        dp(i)(j) = dp(i)(j).max(prev + current)
      }
      // 左から
      if (j - 1 >= 0) {
        val prev = dp(i)(j - 1)
        val current = as(i)(j)
        dp(i)(j) = dp(i)(j).max(prev + current)
      }
    }
  }
  println(dp(n - 1)(n - 1))
}

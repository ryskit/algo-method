package tasks.task341

// https://algo-method.com/tasks/341
object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val as = Vector.fill(n - 1)(sc.nextInt)
  val bs = Vector.fill(n - 1)(sc.nextInt)
  val dp: Array[Array[Long]] = Array.fill(n)(Array.fill(m)(-1L))

  dp(0)(0) = 0

  (0 until n - 1).foreach { i =>
    (0 until m).foreach { j =>
      if (dp(i)(j) != -1) {
        dp(i + 1)(j) = dp(i + 1)(j).max(dp(i)(j) + 0)
        val right = as(i) + j
        if (right <= m - 1) {
          dp(i + 1)(right) = dp(i + 1)(right).max(dp(i)(j) + bs(i))
        }
      }
    }
  }
  println(dp(n - 1)(m - 1))
}

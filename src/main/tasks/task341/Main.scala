package tasks.task341

// https://algo-method.com/tasks/341
object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val as = Vector.fill(n - 1)(sc.nextInt)
  val bs = Vector.fill(n - 1)(sc.nextInt)
  val dp: Array[Array[Boolean]] = Array.ofDim(n, m)
  val score: Array[Array[Long]] = Array.ofDim(n, m)

  dp(0)(0) = true
  score(0)(0) = 0

  (0 until n - 1).foreach { i =>
    (0 until m).foreach { j =>
      if (dp(i)(j)) {
        dp(i + 1)(j) = true
        score(i + 1)(j) = score(i + 1)(j).max(score(i)(j) + 0)
        val right = as(i) + j
        if (right <= m - 1) {
          dp(i + 1)(right) = true
          score(i + 1)(right) = score(i + 1)(right).max(score(i)(j) + bs(i))
        }
      }
    }
  }
  println(if (dp(n - 1)(m - 1)) score(n - 1)(m - 1) else - 1)
}

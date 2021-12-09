package tasks.task335

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val as = Vector.fill(n)(Vector.fill(n)(sc.nextInt))
  val dp: Array[Array[Int]] = Array.ofDim(n, n)
  (0 until n).foreach { i =>
    (0 until n).foreach { j =>
      dp(i)(j) = Int.MaxValue
    }
  }

  dp(0)(n - 1) = as(0)(n - 1)

  (0 until n).foreach { i =>
    (n - 1 to 0 by - 1).foreach { j =>
      // 上から
      if (i - 1 >= 0) {
        val prev = dp(i - 1)(j)
        val current = as(i)(j)
        dp(i)(j) = dp(i)(j).min(prev + current)
      }

      // 右から
      if (j != n - 1) {
        val prev = dp(i)(j + 1)
        val current = as(i)(j)
        dp(i)(j) = dp(i)(j).min(prev + current)
      }
    }
  }
  println(dp(n - 1)(0))
}

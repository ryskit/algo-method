package tasks.task333

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val ss = Vector.fill(n)(sc.next.toVector)
  val dp: Array[Array[Int]] = Array.ofDim(n, n)
  dp(0)(0) = 1
  (0 until n).foreach { i =>
    (0 until n).foreach { j =>
      if (i - 1 >= 0 && ss(i - 1)(j) != '#') dp(i)(j) += dp(i - 1)(j)
      if (j - 1 >= 0 && ss(i)(j - 1) != '#') dp(i)(j) += dp(i)(j - 1)
    }
  }
  println(dp(n - 1)(n - 1))
}

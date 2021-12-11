package tasks.task337

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val ws = Vector.fill(n)(sc.nextInt)
  val dp: Array[Array[Boolean]] = Array.ofDim(n + 1, m + 1)
  dp(0)(0) = true

  (0 until n).foreach { i =>
    (0 to m).foreach { j =>
      if (dp(i)(j)) {
        dp(i+1)(j) = true
        if (j + ws(i) <= m) {
          dp(i+1)(j + ws(i)) = true
        }
      }
    }
  }
  println(if (dp(n)(m)) "Yes" else "No")
}

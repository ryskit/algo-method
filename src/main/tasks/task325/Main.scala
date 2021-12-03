package tasks.task325

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val as = Vector.fill(n)(sc.nextInt)
  val dp = (1 until n).foldLeft(Vector.empty[Vector[Int]] :+ as) {
    case (acc, i) =>
      val r = (0 until n).foldLeft(Vector.empty[Int]) {
        case (row, j) =>
          var sum = 0
          if (acc(i - 1).isDefinedAt(j - 1)) {
            sum += acc(i - 1)(j - 1)
          }
          if (acc(i - 1).isDefinedAt(j)) {
            sum += acc(i - 1)(j)
          }
          if (acc(i - 1).isDefinedAt(j + 1)) {
            sum += acc(i - 1)(j + 1)
          }
          row :+ sum % 100
      }
      acc :+ r
  }

  println(dp(n - 1)(n - 1))
}


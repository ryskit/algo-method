package tasks.task324

// https://algo-method.com/tasks/324
object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val a0, a1, a2, a3 = sc.nextInt
  val dp = (1 to 3).foldLeft(Vector.empty[Vector[Int]] :+ Vector(a0, a1, a2, a3)) {
    case (acc, i) =>
      val r = (0 to 3).foldLeft(Vector.empty[Int]) {
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
          row :+ sum
      }
      acc :+ r
  }
  println(dp(3)(3))
}

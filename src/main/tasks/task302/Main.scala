package task302

object Main {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val x, y = sc.nextInt
    println(solve(x, y, n - 1, 2))
  }

  @scala.annotation.tailrec
  def solve(prev: Int, current: Int, n: Int, count: Int): Int = {
    count match {
      case c if c < n => solve(current, (prev + current) % 100, n, count + 1)
      case _ => (prev + current) % 100
    }
  }
}

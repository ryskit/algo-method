package tasks.task304

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val f = new Array[Int](n + 1)

  f.update(0, 1)
  f.update(1, 1)

  (2 to n).foreach { i =>
    f.update(i, f(i - 2) + f(i - 1))
  }
  println(f(n))

//  def solve(start: Int, n: Int): Int = {
//    if (start == n) 1
//    else if (n < start) 0
//    else {
//      val c1 = solve(start + 1, n)
//      val c2 = solve(start + 2, n)
//      c1 + c2
//    }
//  }
}


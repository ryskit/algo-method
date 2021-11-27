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
}


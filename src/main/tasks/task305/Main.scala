package tasks.task305

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val t = new Array[Int](n + 1)
  t.update(0, 1)

  (1 to n).foreach { i =>
    if (i - 1 >= 0) t.update(i, t(i - 1))
    if (i - 2 >= 0) t.update(i, t(i - 2))
    if (i - 3 >= 0) t.update(i, t(i - 3))
  }
}

package tasks.task306

object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val as = Vector.fill(n)(sc.nextInt)
  val t = new Array[Int](n)
  val ans = as.zipWithIndex.tail.foreach {
    case (a, i) =>
      val maxM = if (i < m) i else m
      val mint = (1 to maxM).foldLeft(Int.MaxValue) {
        case (min, mi) =>
          min.min(t(i - mi) + (a *  mi))
      }
      t.update(i, mint)
  }
  println(t.last)
}

package sierikov.adventofcode

object Runner extends App {
  val year = args.headOption.map(_.toInt).getOrElse(2020)
  val day = args.lift(1).map(_.toInt).getOrElse(0)

  val problemsM: Map[Int, Map[Int, Problem[_, _]]] =
    Map(
      2020 -> Map(
        1 -> y2020.Day01
      )
    )

  run(problemsM, year, day)

  def resource(year: Int, day: Int): String = s"$year/day-${"%02d" format day}.txt"

  def run(problems: Map[Int, Map[Int, Problem[_, _]]], year: Int, day: Int): Unit = {
    problems get year match {
      case None => println(s"Problems for $year year are not solved!")
      case Some(y) => y get day match {
        case Some(p) => solve(p, year, day)
        case None =>
          if (day > 0) println(s"Problem for Day $day (Year $year) is not yet solved!")
          else for {
            p <- y
            day = p._1
            prob = p._2
          } yield solve(prob, year, day)
      }
    }
  }

  def solve(problem: Problem[_, _], year: Int, day: Int): Unit = {
    print(s"Solving puzzle for Day $day (Year $year)")
    val res = resource(year, day)
    val result = problem.solve(res)
    println(s" - result: $result")
  }

}

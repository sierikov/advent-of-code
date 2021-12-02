package sierikov.adventofcode

import scala.language.existentials

object Runner extends App {
  val year = args.headOption.map(_.toInt).getOrElse(2020)
  val day = args.lift(1).map(_.toInt).getOrElse(0)

  val problemsM: Map[Int, Map[Int, Problem[_, _]]] =
    Map(
      2015 -> Map(
        1 -> y2015.Day01,
      ),
      2020 -> Map(
        1 -> y2020.Day01,
        2 -> y2020.Day02,
        3 -> y2020.Day03
      ),
      2021 -> Map(
        1 -> y2021.Day01,
        2 -> y2021.Day02
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
    println(s"Solving puzzle for Day $day (Year $year)")
    val res = resource(year, day)
    val (res1, res2) = problem.solve(res)
    println(s" - result stage 1: $res1")
    println(s" - result stage 2: $res2")
  }

}

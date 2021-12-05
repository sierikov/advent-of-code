package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.adventofcode.y2021.ocean.Vent
import sierikov.common.Point
import sierikov.utils.Files

import scala.util.matching.Regex

object Day05 extends Problem[Vector[Vent], Int] {

  val pattern: Regex = """(\d+),(\d+) -> (\d+),(\d+)""".r

  override def parse(res: String): Vector[Vent] =
    Files.read(res).map {
      case pattern(x0, y0, x1, y1) => Vent(Point(x0.toInt, y0.toInt), Point(x1.toInt, y1.toInt))
    }.toVector

  def overlaps(vents: Vector[Vent]): Int = vents
      .flatMap(_.points)
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .count(_._2 > 1)

  override def first(input: Vector[Vent]): Int =
    overlaps(input.filterNot(_.isDiagonal))

  override def second(input: Vector[Vent]): Int =
    overlaps(input)


}

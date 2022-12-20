package sierikov.adventofcode.y2022

import sierikov.adventofcode.Problem
import sierikov.adventofcode.y2022.domain.*
import sierikov.utils.Files


object Day04 extends Problem[List[String], Int] {


  private def toRange(s: String): Range = s.split("-").map(_.toInt).toList match
    case f :: t :: Nil => Range.inclusive(f, t)
    case _ => Range(0, 0)


  override def parse(res: String): List[String] =
    Files.read(res)

  override def first(input: List[String]): Int =
    input
      .map(str => str.split(","))
      .map(pair => pair.map(toRange))
      .count(ranges =>
        ranges.head.indexOfSlice(ranges.last) != -1 || ranges.last.indexOfSlice(ranges.head) != -1
      )


  override def second(input: List[String]): Int = input
    .map(str => str.split(","))
    .map(pair => pair.map(toRange))
    .count(ranges =>
      ranges.head.intersect(ranges.last).nonEmpty
    )


}

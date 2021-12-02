package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.util.Try

object Day01 extends Problem[List[Int], Int] {

  override def parse(res: String): List[Int] =
    Files
      .read(res)
      .flatMap(row => Try(row.toInt).toOption)

  override def first(input: List[Int]): Int =
    input.zip(input.tail).count(p => p._1 < p._2)

  override def second(input: List[Int]): Int =
    first(input.sliding(3).map(list => list.sum).toList)
}

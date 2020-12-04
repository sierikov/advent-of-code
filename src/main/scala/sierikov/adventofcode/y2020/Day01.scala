package sierikov.adventofcode.y2020

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.util.Try

object Day01 extends Problem[Seq[Int], Int] {
  val target = 2020
  val size = 2

  override def parse(res: String): Seq[Int] =
    Files
      .read(res)
      .flatMap(row => Try(row.toInt).toOption)
      .toList.sortWith(_ > _)

  override def eval(list: Seq[Int]): Int = {
    list
      .flatMap {
        a => list.filter {
          b => a + b == 2020
        }
      }.product
  }

}

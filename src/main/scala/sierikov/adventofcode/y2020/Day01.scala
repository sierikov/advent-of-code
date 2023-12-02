package sierikov.adventofcode.y2020

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.util.Try

object Day01 extends Problem[List[Int], Int] {
  val target = 2020
  val size   = 2

  override def parse(res: String): List[Int] =
    Files
      .read(res)
      .flatMap(row => Try(row.toInt).toOption)
      .sortWith(_ > _)

  override def first(input: List[Int]): Int =
    input.flatMap { a =>
      input.filter { b =>
        a + b == 2020
      }
    }.product

  override def second(input: List[Int]): Int =
    (for {
      a <- input
      b <- input
      c <- input if a + b + c == 2020
    } yield a * c * b).head

}

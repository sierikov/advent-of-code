package sierikov.adventofcode.y2022

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec
import scala.util.Try

object Day01 extends Problem[List[Int], Int] {

  override def parse(res: String): List[Int] =
    Files
      .read(res)
      .map {
        case row if row.isBlank => 0
        case row => row.toInt
      }


  override def first(input: List[Int]): Int =
    splitBy0(input).map(_.sum).max



  override def second(input: List[Int]): Int =
    splitBy0(input).map(_.sum).sortWith(_ > _).take(3).sum


  @tailrec
  private def splitBy0(input: List[Int], acc: List[List[Int]] = List.empty): List[List[Int]] =
    if (input.isEmpty) acc
    else {
      val delimiterLength = 1
      val group = input.takeWhile(_ != 0)
      val tail = input.drop(group.length + delimiterLength)

      val update = acc :+ group

      splitBy0(tail, update)
    }
}

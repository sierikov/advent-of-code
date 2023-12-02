package sierikov.adventofcode.y2015

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec

object Day01 extends Problem[List[Char], Int] {

  override def parse(res: String): List[Char] =
    Files
      .read(res)
      .map(row => row.toList)
      .head // there is only one row in the file

  def convert(list: List[Char]): List[Int] = list.map {
    case '(' => 1
    case ')' => -1
  }

  override def first(input: List[Char]): Int =
    convert(input).sum

  override def second(input: List[Char]): Int =
    helper(convert(input))

  @tailrec
  def helper(list: List[Int], floor: Int = 0, index: Int = 0): Int =
    list match {
      case Nil           => index
      case value :: tail => if (floor == -1) index else helper(tail, floor + value, index + 1)
    }

}

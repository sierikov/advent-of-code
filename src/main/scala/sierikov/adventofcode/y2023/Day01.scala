package sierikov.adventofcode.y2023

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec

object Day01 extends Problem[List[String], Int] {

  private val numberMap = Map(
    "one"   -> "o1e",
    "two"   -> "t2o",
    "three" -> "t3e",
    "four"  -> "f4r",
    "five"  -> "f5e",
    "six"   -> "s6x",
    "seven" -> "s7n",
    "eight" -> "e8t",
    "nine"  -> "n9e"
  )

  override def parse(res: String): List[String] = Files.read(res)

  override def first(input: List[String]): Int =
    input.view.map(leaveDigits).map(combineFirstAndLast).sum

  override def second(input: List[String]): Int = input.view
    .map(replaceTextNumbersWithDigits)
    .map(leaveDigits)
    .map(combineFirstAndLast)
    .sum

  private def leaveDigits(str: String): List[Int] =
    str.filter(_.isDigit).split("").map(_.toInt).toList

  @tailrec
  private def replaceTextNumbersWithDigits(text: String): String =
    numberMap.keySet.find(text.contains) match {
      case Some(key) =>
        replaceTextNumbersWithDigits(text.replaceAll(key, numberMap(key)))
      case None => text
    }

  private def combineFirstAndLast(list: List[Int]): Int =
    s"${list.head}${list.last}".toInt
}

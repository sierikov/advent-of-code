package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.utils.Files
import sierikov.utils.StringExtensions._

import scala.annotation.tailrec
import scala.collection.MapView
import scala.util.matching.Regex

object Day03 extends Problem[List[List[Int]], Int] {

  val pattern: Regex = """(down|up|forward) (\d)""".r

  override def parse(res: String): List[List[Int]] =
    Files
      .read(res)
      .map(row => row.toList.map(_.asDigit))

  def rotate(matrix: List[List[Int]]): List[List[Int]] =
    matrix.head.indices.toList map { column =>
      matrix.indices.toList map { row =>
        matrix(row)(column)
      }
    }

  def getNumbersOccurrences(list: List[Int]) : MapView[Int, Int] = {
    list.groupBy(identity)
      .view
      .mapValues(_.size)
  }

  def findMostCommonNumberIn(list: List[Int]): Option[Int] = {
    val map = getNumbersOccurrences(list)
    if (map.values.toList.distinct.size > 1)
      Some(map.maxBy(_._2)._1)
    else
      None
  }

  def findLeastCommonNumberIn(list: List[Int]): Option[Int] = {
    val map = getNumbersOccurrences(list)
    if (map.values.toList.distinct.size > 1)
      Some(map.minBy(_._2)._1)
    else
      None
  }

  def inverse(str: String): String =
    str.map {
      case '0' => '1'
      case '1' => '0'
    }

  override def first(input: List[List[Int]]): Int = {
    val gamma = rotate(input).map(seq => findMostCommonNumberIn(seq).getOrElse(0)).mkString
    val epsilon = inverse(gamma)
    gamma.b * epsilon.b
  }

  override def second(input: List[List[Int]]): Int = {
    val oxygen = helper(input, findMostCommonNumberIn, 1)
    val scrubber = helper(input, findLeastCommonNumberIn,  0)
    oxygen.b * scrubber.b
  }

  @tailrec
  def helper(original: List[List[Int]], f: List[Int] => Option[Int], solver: Int, index: Int = 0): String = {
    val mostCommon: Int = f(rotate(original)(index)).getOrElse(solver)
    if (index < original.head.size - 1 && original.size > 1) {
      helper(original.filter(row => row(index) == mostCommon), f, solver, index + 1)
    } else {
      val result = if(original.size == 1) original else original.filter(row => row(index) == mostCommon)
      result.head.mkString
    }

  }

}

package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec

object Day07 extends Problem[List[Int], Int] {
  override def parse(res: String): List[Int] = {
    Files
      .read(res)
      .head
      .split(",")
      .map(_.toInt)
      .toList
  }

  def range(input: List[Int]): Range.Inclusive = input.min to input.max

  @tailrec
  def recSum(distance: Int, cost: Int = 0): Int =
    distance match {
      case 0 => cost
      case _ => recSum(distance - 1, cost + distance)
    }

  // https://de.wikipedia.org/wiki/Gau%C3%9Fsche_Summenformel
  def gausSum(distance: Int): Int = distance * (distance + 1) / 2

  def calculateCosts(points: List[Int], current: Int, f: Int => Int): Int =
    points.map(point => current - point).map(_.abs).map(f(_)).sum

  override def first(input: List[Int]): Int =
    range(input).map(value => calculateCosts(input, value, d => d)).min

  override def second(input: List[Int]): Int =
    range(input).map(value => calculateCosts(input, value, d => recSum(d))).min // also works with Gauss Sum
}

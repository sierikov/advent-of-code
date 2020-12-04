package sierikov.adventofcode.y2020

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.util.Try

object Day01 extends Problem[Seq[Int], Int] {
  val target = 2020
  val size = 2

  override def parse(res: String): Seq[Int] =
    Files.read(res).flatMap(row => Try(row.toInt).toOption)

  override def eval(raw: Seq[Int]): Int = {
    sums(raw.sortWith(_ > _).toList) match {
      case Some(result) => result
      case None => 0
    }
  }

  def subLists(list: List[Int]): List[List[Int]] = {
    list match {
      case Nil => List.empty
      case head :: tail => List(List(head, tail.lastOption.getOrElse(0))) ++ subLists(tail)
    }
  }

  def sums(list: List[Int]): Option[Int] =
    subLists(list)
      .collectFirst {
        case x if x.sum == target => x.product
      }

}

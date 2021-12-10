package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec

object Day06 extends Problem[Map[Int, Long], Long] {
  override def parse(res: String): Map[Int, Long] = {
    Files.read(res).head
      .split(",")
      .map(_.toInt)
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .mapValues(_.toLong)
      .toMap
  }

  override def first(input: Map[Int, Long]): Long = generation(input, 80)

  override def second(input: Map[Int, Long]): Long = generation(input, 256)

  def countFish(generation: Map[Int, Long], daysUntilBirth: Int, fishAmount: Long): Map[Int, Long] =
    daysUntilBirth match {
      case 0 => Map(
        6 -> (fishAmount + generation.getOrElse(6, 0L)),
        8 -> (fishAmount + generation.getOrElse(8, 0L))
      )
      case _ => Map(daysUntilBirth - 1 -> (fishAmount + generation.getOrElse(daysUntilBirth - 1, 0L)))
    }

  def generate(fishies: Map[Int, Long]): Map[Int, Long] =
    fishies.foldLeft(Map.empty[Int, Long]) {
      case (next, (daysUntilBirth, fishAmount)) => next ++ countFish(next, daysUntilBirth, fishAmount)
    }

  @tailrec
  def generation(fishies: Map[Int, Long], until: Int, day: Int = 1): Long = {
    if (day > until) fishies.values.sum
    else generation(generate(fishies), until, day + 1)
  }
}

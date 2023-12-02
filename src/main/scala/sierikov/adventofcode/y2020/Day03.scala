package sierikov.adventofcode.y2020

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec

object Day03 extends Problem[List[String], Long] {
  val tree = '#'

  case class Position(y: Int, x: Int)
  case class Slope(right: Int, down: Int)

  @tailrec
  def count(acc: Long, pos: Position, slope: Slope, grid: List[String]): Long = {
    val newPos = Position(pos.y + slope.down, (pos.x + slope.right) % grid.head.length)

    if (newPos.y >= grid.size) acc
    else
      count(
        if (isTree(newPos, grid)) acc + 1
        else acc,
        newPos,
        slope,
        grid
      )
  }

  def isTree(pos: Position, grid: List[String]): Boolean =
    grid(pos.y)(pos.x) == tree

  def count(slope: Slope, input: List[String]): Long =
    count(0, Position(0, 0), slope, input)

  override def parse(res: String): List[String] =
    Files.read(res)

  override def first(input: List[String]): Long =
    count(Slope(3, 1), input)

  override def second(input: List[String]): Long =
    List(Slope(1, 1), Slope(3, 1), Slope(5, 1), Slope(7, 1), Slope(1, 2))
      .map(count(_, input))
      .product
}

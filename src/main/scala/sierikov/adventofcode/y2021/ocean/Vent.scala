package sierikov.adventofcode.y2021.ocean

import sierikov.common.Point

case class Vent(start: Point, end: Point) {
  val dx: Int             = end.x - start.x
  val dy: Int             = end.y - start.y
  def isDiagonal: Boolean = dx.sign * dy.sign != 0
  def points: Vector[Point] =
    Range
      .inclusive(0, math.max(dx.abs, dy.abs))
      .map(step => Point(start.x + dx.sign * step, start.y + dy.sign * step))
      .toVector
}

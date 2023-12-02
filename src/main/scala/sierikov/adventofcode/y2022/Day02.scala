package sierikov.adventofcode.y2022

import sierikov.adventofcode.Problem
import sierikov.adventofcode.y2022.domain._
import sierikov.utils.Files

object Day02 extends Problem[List[Array[String]], Int] {

  override def parse(res: String): List[Array[String]] =
    Files
      .read(res)
      .map(str => str.split(" "))

  override def first(input: List[Array[String]]): Int =
    input
      .map(_.map(Shape.apply))
      .map { case Array(shape1, shape2) => score(shape1, shape2) }
      .map(outcome => outcome.shape.value + outcome.value)
      .sum

  override def second(input: List[Array[String]]): Int =
    input
      .map(arr => (Shape.apply(arr.head), arr.last))
      .map(pair => secretScore(pair._1, pair._2))
      .map(outcome => outcome.shape.value + outcome.value)
      .sum

  def score(shape1: Shape, shape2: Shape): Outcome =
    if (shape1 == shape2) Draw(shape2)
    else if (shape1.winns == shape2) Lost(shape2)
    else Win(shape2)

  private def secretScore(shape: Shape, code: String): Outcome = code match {
    case "X" => Lost(shape.winns)
    case "Y" => Draw(shape)
    case "Z" => Win(shape.loses)
  }

}

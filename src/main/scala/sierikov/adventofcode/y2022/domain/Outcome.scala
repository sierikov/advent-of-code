package sierikov.adventofcode.y2022.domain

sealed trait Outcome {
  val value: Int
  val shape: Shape
}

case class Lost(shape: Shape) extends Outcome {
  val value = 0
}
case class Draw(shape: Shape) extends Outcome {
  val value = 3
}
case class Win(shape: Shape) extends Outcome {
  val value = 6
}

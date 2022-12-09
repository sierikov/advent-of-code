package sierikov.adventofcode.y2022.domain

sealed trait Shape {
  val value: Int
  def winns: Shape
  def loses: Shape

  override def equals(obj: Any): Boolean =
    this.value == obj.asInstanceOf[Shape].value
}
object Shape {
  def apply(str: String): Shape = str match {
    case "A" | "X" => Rock
    case "B" | "Y" => Paper
    case "C" | "Z" => Scissors
  }
}
case object Rock extends Shape {
  override val value = 1
  override def winns: Shape = Scissors
  override def loses: Shape = Paper
}
case object Paper extends Shape {
  override val value = 2
  override def winns: Shape = Rock
  override def loses: Shape = Scissors
}
case object Scissors extends Shape {
  override val value = 3
  override def winns: Shape = Paper
  override def loses: Shape = Rock
}

package sierikov.adventofcode.y2021.submarine

sealed trait Command
case class Up(value: Int)      extends Command
case class Forward(value: Int) extends Command
case class Down(value: Int)    extends Command

package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.annotation.tailrec
import scala.util.matching.Regex

sealed trait Command
case class Up(value: Int) extends Command
case class Forward(value: Int) extends Command
case class Down(value: Int) extends Command

object Day02 extends Problem[List[Command], Int] {

  val pattern: Regex = """(down|up|forward) (\d)""".r

  def toCommand(row: String): Command = row match {
    case pattern("up", value) => Up(Integer.parseInt(value))
    case pattern("forward", value) => Forward(Integer.parseInt(value))
    case pattern("down", value) => Down(Integer.parseInt(value))
  }

  override def parse(res: String): List[Command] =
    Files
      .read(res)
      .map(row => toCommand(row))

  override def first(input: List[Command]): Int =
    helper(input)

  override def second(input: List[Command]): Int =
    helper2(input)

  @tailrec
  def helper(list: List[Command], depth: Int = 0, horizontal: Int = 0): Int =
    list match {
      case command :: rest =>
        command match {
          case Up(value) => helper(rest, depth - value, horizontal)
          case Down(value) => helper(rest, depth + value, horizontal)
          case Forward(value) => helper(rest, depth, horizontal + value)
        }
      case Nil => depth * horizontal
    }

  @tailrec
  def helper2(list: List[Command], aim: Int = 0, depth: Int = 0, horizontal: Int = 0): Int =
    list match {
      case command :: rest =>
        command match {
          case Up(value) => helper2(rest, aim - value, depth, horizontal)
          case Down(value) => helper2(rest, aim + value, depth, horizontal)
          case Forward(value) => helper2(rest, aim, depth + aim * value, horizontal + value)
        }
      case Nil => depth * horizontal
    }

}

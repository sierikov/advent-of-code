package sierikov.adventofcode.y2020

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.util.matching.Regex

object Day02 extends Problem[List[String], Int] {
  case class Rule(min: Int, max: Int, ch: Char)

  val extractRule: Regex ="""(\d+)-(\d+) ([a-z])""".r

  override def parse(res: String): List[String] =
    Files.read(res)

  def toRule(x: String): Rule =
    x match {
      case extractRule(min, max, ch) => Rule(min.toInt, max.toInt, ch.charAt(0))
    }

  def divide(x: String): (Rule, String) =
    x.split(": ") match {
      case Array(x, y) => (toRule(x), y)
    }

  def check(rule: Rule, password: String): Boolean = {
    val amount = password.count(x => rule.ch == x)
    amount >= rule.min && amount <= rule.max
  }

  def check2(rule: Rule, password: String): Boolean =
    password(rule.min - 1) == rule.ch ^ password(rule.max - 1) == rule.ch

  override def first(input: List[String]): Int =
    input.count(x => check(divide(x)._1, divide(x)._2))

  override def second(input: List[String]): Int =
    input.count(x => check2(divide(x)._1, divide(x)._2))
}

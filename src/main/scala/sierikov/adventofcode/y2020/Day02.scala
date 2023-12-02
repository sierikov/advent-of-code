package sierikov.adventofcode.y2020

import sierikov.adventofcode.Problem
import sierikov.utils.Files

import scala.util.matching.Regex

object Day02 extends Problem[List[String], Int] {
  case class Rule(min: Int, max: Int, ch: Char)
  type Password = String

  val extract: Regex = """(\d+)-(\d+) ([a-z]): (\w+)""".r

  override def parse(res: String): List[String] =
    Files.read(res)

  def convert(line: String): (Rule, Password) =
    line match {
      case extract(max, min, ch, password) =>
        (Rule(max.toInt, min.toInt, ch.charAt(0)), password)
    }

  def check(rule: Rule, password: Password): Boolean = {
    val amount = password.count(x => rule.ch == x)
    amount >= rule.min && amount <= rule.max
  }

  def check2(rule: Rule, password: Password): Boolean =
    password(rule.min - 1) == rule.ch ^ password(rule.max - 1) == rule.ch

  override def first(input: List[String]): Int =
    input.count(x => {
      val (rule, pass) = convert(x)
      check(rule, pass)
    })

  override def second(input: List[String]): Int =
    input.count(x => {
      val (rule, pass) = convert(x)
      check2(rule, pass)
    })
}

package sierikov.adventofcode.y2022

import sierikov.adventofcode.Problem
import sierikov.adventofcode.y2022.domain._
import sierikov.utils.Files

object Day03 extends Problem[List[String], Int] {

  private val alphabet               = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
  private def score(char: Char): Int = alphabet.indexOf(char) + 1

  override def parse(res: String): List[String] =
    Files.read(res)

  override def first(input: List[String]): Int =
    input
      .map(str => str.splitAt(str.length / 2))
      .map(pair => findShared(pair._1, pair._2))
      .map(score)
      .sum

  override def second(input: List[String]): Int =
    input
      .grouped(3)
      .map(group => findShared(group.head, group(1), group.last))
      .map(score)
      .sum

  private def findShared(str1: String, str2: String): Char =
    str1.filter(value => str2.contains(value)).head

  private def findShared(str1: String, str2: String, str3: String): Char =
    str1.filter(value => str2.contains(value) && str3.contains(value)).head
}

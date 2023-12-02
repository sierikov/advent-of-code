package sierikov.adventofcode.y2023

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2023.Day01.*

class Day01Test extends AnyFunSuite {

  val res = "2023/day-01.txt"

  test("Day01 - Default 1") {
    assert(first(Values.Default.input) == Values.Default.result1)
  }

  test("Day01 - Must process 2fourseven1oneights correctly") {
    assert(second(List("2fourseven1oneights")) == 28)
  }

  test("Day01 - Default 2") {
    assert(second(Values.Default.input2) == Values.Default.result2)
  }

  test("Day01 ---- Part 1") {
    assert(first(parse(res)) == Values.result1)
  }

  test("Day01 ---- Part 2") {
    assert(second(parse(res)) == Values.result2)
  }

  object Values {

    object Default {
      val input: List[String] =
        List("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")
      val input2: List[String] = List(
        "two1nine",
        "eightwothree",
        "abcone2threexyz",
        "xtwone3four",
        "4nineeightseven2",
        "zoneight234",
        "7pqrstsixteen"
      )

      val result1: Int = 142
      val result2: Int = 281
    }

    val result1: Int = 55090
    val result2: Int = 54845
  }

}

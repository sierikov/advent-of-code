package sierikov.adventofcode.y2022

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2022.Day04.*

class Day04Test extends AnyFunSuite {

  val res = "2022/day-04.txt"

  test("Day04 - Default 1") {
    assert(first(Values.Default.input) == Values.Default.result1)
  }

  test("Day04 - Default 2") {
    assert(second(Values.Default.input) == Values.Default.result2)
  }

  test("Day04 ---- Part 1") {
    assert(first(parse(res)) == Values.result1)
  }

  test("Day04 ---- Part 2") {
    assert(second(parse(res)) == Values.result2)
  }

  object Values {

    object Default {
      val input: List[String] = List(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8"
      )

      val result1: Int = 2
      val result2: Int = 4
    }

    val result1: Int = 532
    val result2: Int = 854
  }

}

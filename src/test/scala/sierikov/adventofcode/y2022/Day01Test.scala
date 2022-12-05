package sierikov.adventofcode.y2022

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2022.Day01._

class Day01Test extends AnyFunSuite {

  val res = "2022/day-01.txt"

  test("Day01 - Default 1") {
    assert(first(Values.Default.input) == Values.Default.result1)
  }

  test("Day01 - Default 2") {
    assert(second(Values.Default.input) == Values.Default.result2)
  }

  test("Day01 ---- Part 1") {
    assert(first(parse(res)) == Values.result1)
  }

  test("Day01 ---- Part 2") {
    assert(second(parse(res)) == Values.result2)
  }

  object Values {

    object Default {
      val input: List[Int] = List(
        1000,
        2000,
        3000,
        0,
        4000,
        0,
        5000,
        6000,
        0,
        7000,
        8000,
        9000,
        0,
        10000
      )

      val result1: Int = 24000
      val result2: Int = 45000
    }

    val result1: Int = 68292
    val result2: Int = 203203
  }

}

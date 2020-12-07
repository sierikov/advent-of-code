package sierikov.adventofcode.y2020

import sierikov.adventofcode.y2020.Day01._
import org.scalatest.funsuite.AnyFunSuite

class Day01Test extends AnyFunSuite {

  val res = "2020/day-01.txt"

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
        1721,
        979,
        366,
        299,
        675,
        1456,
      )

      val result1: Int = 514579
      val result2: Int = 241861950
    }

    val result1: Int = 744475
    val result2: Int = 70276940
  }

}


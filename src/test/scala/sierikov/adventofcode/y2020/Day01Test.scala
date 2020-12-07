package sierikov.adventofcode.y2020

import sierikov.adventofcode.y2020.Day01._
import org.scalatest.funsuite.AnyFunSuite

class Day01Test extends AnyFunSuite {

  test("Day01 - Default 1") {
    assert(first(Values.Default.input) == Values.Default.result1)
  }

  test("Day01 - Default 2") {
    assert(second(Values.Default.input) == Values.Default.result2)
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

    val result1: Int = 514579
    val result2: Int = 241861950
  }
}


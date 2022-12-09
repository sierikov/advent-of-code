package sierikov.adventofcode.y2022

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2022.Day02._
import sierikov.adventofcode.y2022.domain.Shape

class Day02Test extends AnyFunSuite {

  val res = "2022/day-02.txt"

  test("Day02 - Default 1") {
    assert(first(Values.Default.input) == Values.Default.result1)
  }

  test("Day02 - Default 2") {
    assert(second(Values.Default.input) == Values.Default.result2)
  }

  test("Day02 ---- Part 1") {
    assert(first(parse(res)) == Values.result1)
  }

  test("Day02 ---- Part 2") {
    assert(second(parse(res)) == Values.result2)
  }

  object Values {

    object Default {
      val input: List[Array[String]] = List(
        "A Y",
        "B X",
        "C Z"
      ).map(str => str.split(" "))

      val result1: Int = 15
      val result2: Int = 12
    }

    val result1: Int = 13005
    val result2: Int = 11373
  }

}

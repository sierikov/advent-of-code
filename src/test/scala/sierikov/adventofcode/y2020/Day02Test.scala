package sierikov.adventofcode.y2020

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2020.Day02._

class Day02Test extends AnyFunSuite {

  val res = "2020/day-02.txt"

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
      val input: List[String] = List(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
      )

      val result1: Int = 2
      val result2: Int = 1
    }

    val result1: Int = 536
    val result2: Int = 558
  }

}


package sierikov.adventofcode.y2023

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2023.Day02.*
import sierikov.adventofcode.y2023.Day02.Domain.*

class Day02Test extends AnyFunSuite {

  val res = "2023/day-02.txt"

  test("Day02 - Should parse input correctly") {
    val str      = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    val expected = Game(1, Configuration(Some(4), Some(2), Some(6)))

    assert(Game.fromString(str) == expected)
  }

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
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
      )

      val result1: Int = 8
      val result2: Int = 2286
    }

    val result1: Int = 3035
    val result2: Int = 66027
  }

}

package sierikov.adventofcode.y2020

import org.scalatest.funsuite.AnyFunSuite
import sierikov.adventofcode.y2020.Day03._

class Day03Test extends AnyFunSuite {

  val res = "2020/day-03.txt"

  test("Day03 - Default 1") {
    assert(first(Values.Default.input) == Values.Default.result1)
  }

  test("Day03 - Default 2") {
    assert(second(Values.Default.input) == Values.Default.result2)
  }

  test("Day03 ---- Part 1") {
    assert(first(parse(res)) == Values.result1)
  }

  test("Day03 ---- Part 2") {
    assert(second(parse(res)) == Values.result2)
  }

  object Values {

    object Default {
      val input: List[String] = List(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
      )

      val result1: Long = 7
      val result2: Long = 336
    }

    val result1: Long = 228
    val result2: Long = 6818112000L
  }

}

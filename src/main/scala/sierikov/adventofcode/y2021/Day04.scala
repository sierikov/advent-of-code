package sierikov.adventofcode.y2021

import sierikov.adventofcode.Problem
import sierikov.adventofcode.y2021.submarine.bingo.{Board, BoardCell, WiningRecord}
import sierikov.utils.Files

import scala.annotation.tailrec
import scala.collection.SortedMap

object Day04 extends Problem[List[Board], Int] {
  var numbers: List[Int] = List()
  override def parse(res: String): List[Board] = {
    val data = Files.read(res)
    this.numbers = data.head.split(",").map(s => Integer.parseInt(s)).toList
    data.drop(1)
      .filter(_.nonEmpty)
      .grouped(5)
      .map(values =>
        Board(values.map(row =>
          row.trim.replaceAll(" +", " ")
            .split(" ")
            .map(Integer.parseInt)
            .map(BoardCell(_))
            .toList
        ))
      ).toList
  }

  @tailrec
  def winningTable(boards: List[Board], numbers: List[Int], round: Int = 0, map: SortedMap[Int, WiningRecord] = SortedMap()): SortedMap[Int, WiningRecord] =
    if (numbers.nonEmpty) {
      val marked = boards.map(_.mark(numbers.head))
      val winners = marked.filter(_.completed).map(win => WiningRecord(win, numbers.head))
      if (winners.isEmpty) winningTable(marked, numbers.tail, round, map)
      else winningTable(marked.filterNot(_.completed), numbers.tail, round + 1, map + (round -> winners.head))
    } else map

  def findCompletedBoard(boards: List[Board], numbers: List[Int], index: Int): Int = {
    val map = winningTable(boards, numbers)
    if (index >= 0) map.get(index).map(_.score).getOrElse(0)
    else map.last._2.score
  }

  override def first(input: List[Board]): Int = findCompletedBoard(input, this.numbers, 0)
  override def second(input: List[Board]): Int = findCompletedBoard(input, this.numbers, -1)

}

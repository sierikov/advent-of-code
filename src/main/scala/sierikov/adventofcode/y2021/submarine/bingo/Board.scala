package sierikov.adventofcode.y2021.submarine.bingo

import sierikov.utils.Transform.reverse

case class Board(list: List[List[BoardCell]]) {
  def mark(number: Int): Board = Board(
    list.map(row => row.map(cell => cell.compare(number)))
  )

  def sumUnmarked: Int = list.map(row => row.filterNot(_.marked).map(_.value).sum).sum

  def existsCompletedRow: Boolean    = list.exists(_.forall(_.marked))
  def existsCompletedColumn: Boolean = reverse(list).exists(_.forall(_.marked))

  def completed: Boolean = existsCompletedRow || existsCompletedColumn

}

package sierikov.adventofcode.y2021.submarine.bingo

case class BoardCell(value: Int, marked: Boolean = false ) {
  def mark: BoardCell  = BoardCell(value, marked = true)
  def unmark: BoardCell = BoardCell(value)
  def compare(x: Int): BoardCell = if(value == x) this.mark else this
}

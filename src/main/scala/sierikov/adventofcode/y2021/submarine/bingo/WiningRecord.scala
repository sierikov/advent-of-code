package sierikov.adventofcode.y2021.submarine.bingo

case class WiningRecord(board: Board, number: Int) {
  def score: Int = board.sumUnmarked * number
}

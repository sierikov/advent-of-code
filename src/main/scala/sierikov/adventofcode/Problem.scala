package sierikov.adventofcode

trait Problem[P, R] {
  def parse(res: String): P
  def eval(raw: P): R
  def solve(res: String): R = eval(parse(res))
}

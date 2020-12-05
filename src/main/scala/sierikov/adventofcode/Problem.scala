package sierikov.adventofcode

trait Problem[P, R] {
  def parse(res: String): P

  def first(input: P): R

  def second(input: P): R

  def eval(raw: P): (R, R) = (first(raw), second(raw))

  def solve(res: String): (R, R) = eval(parse(res))
}

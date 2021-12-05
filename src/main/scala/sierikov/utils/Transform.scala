package sierikov.utils

import scala.annotation.tailrec
import scala.io.Source

object Transform {
  /**
   * Transponder level 2 nested lists
   *
   * @param matrix Nested lists of elements
   * @return transponder matrix
   */
  def rotate[A](matrix: List[List[A]]): List[List[A]] =
    matrix.head.indices.toList map { column =>
      matrix.indices.toList map { row =>
        matrix(row)(column)
      }
    }


  @tailrec
  def reverse[A](list: List[List[A]], result: List[List[A]] = Nil): List[List[A]] = list match {
    case List(Nil, _*) => result
    case _ => reverse(list.map(_.tail), list.map(_.head) :: result)
  }

}

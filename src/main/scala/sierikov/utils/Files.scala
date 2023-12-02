package sierikov.utils

import scala.io.Source

object Files {

  /**
   * Read a file with input data
   *
   * @param resource Path to the resource
   * @return Sequence of Strings
   */
  def read(resource: String): List[String] =
    Source.fromInputStream(getClass.getClassLoader.getResourceAsStream(resource)).getLines().toList
}

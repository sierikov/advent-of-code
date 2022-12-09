package sierikov.utils

object StringExtensions {

  implicit class IntToBase(val digits: String) extends AnyVal {
    private def base(b: Int): Int = Integer.parseInt(digits, b)

    def binaryToInt: Int = base(2)
    def octalToInt: Int = base(8)
    def hexToInt: Int = base(16)
  }
}

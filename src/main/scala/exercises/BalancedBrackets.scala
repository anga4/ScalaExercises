package exercises

import scala.annotation.tailrec

object BalancedBrackets {

  /*
      Solution Logic
      1 - separate the string that is (s) into a list of bracket pairs(stringToBracketPairs)
          from exterior going in
      2 - Count the number of balanced brackets in the resulting list
      3 - if all bracket pairs in the list are balanced, then the string (s)
          is balanced so return YES, else return NO
     */

  val listOfBalancedBraces: List[String] = List("[]", "{}", "()")

  def isBalanced(s: String): String = {

    @tailrec
    def stringToBracketPairs(x: String, acc: List[String]): List[String] = {
      val strLen: Int = x.length
      if (strLen == 0 || strLen % 2 != 0) acc
      else {
        val firstAndLastChars: String = s"${x.head}${x.last}"
        if (strLen == 2) acc :+ firstAndLastChars
        else stringToBracketPairs(x.tail.dropRight(1), acc :+ firstAndLastChars)
      }
    }

    // separating string into list of bracket pairs
    val allBracketPairsInString = stringToBracketPairs(s, List())
    if (allBracketPairsInString.isEmpty) "NO"
    else {
      val numOfBalancedBracketsInString = allBracketPairsInString.count(listOfBalancedBraces.contains)
      if (numOfBalancedBracketsInString == allBracketPairsInString.length) "YES"
      else "NO"
    }
  }
}

object BalancedBracketsApplication extends App {
  @tailrec
  def getListOfStrings(n: Int, i: Int = 1, list: List[String] = List()): List[String] = {
    val getLine = scala.io.StdIn.readLine()
    if (i >= n) list :+ getLine
    else getListOfStrings(n, i + 1, list :+ getLine)
  }

  @tailrec
  def checkIfBracketsAreBalanced(list: List[String], i: Int = 0): Unit = {
    if (i >= list.length) ()
    else {
      println(BalancedBrackets.isBalanced(list(i)))
      checkIfBracketsAreBalanced(list, i + 1)
    }
  }

  val numOFStrings: Int = {
    println("Enter number of strings")
    scala.io.StdIn.readInt()
  }

  val listOfStrings: List[String] = getListOfStrings(numOFStrings)

  println("\nResults\n")
  checkIfBracketsAreBalanced(listOfStrings)
}
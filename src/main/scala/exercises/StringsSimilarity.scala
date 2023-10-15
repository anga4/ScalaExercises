package exercises

import scala.annotation.tailrec

object StringsSimilarity {
  /*
    Solution Logic
    - Define similarity function for two strings
    - Compare the given string with each of its suffixes
      using the defined similarity function and return the sum
   */

  def calculateSimilarity(str: String): Int = {
    val strToLC = str.toLowerCase

    @tailrec
    def prefixSimilarity(a: String, b: String, i: Int = 0, result: Int = 0): Int = {
      val aLen: Int = a.length
      val bLen: Int = b.length
      if (i >= Math.min(aLen, bLen)) result
      else if (a(i) != b(i)) result
      else prefixSimilarity(a, b, i + 1, result + 1)
    }

    @tailrec
    def suffixSimilarityHelper(suffix: String, i: Int = 0, result: Int = 0): Int = {
      if (i >= strToLC.length) result
      else suffixSimilarityHelper(strToLC.substring(i + 1, strToLC.length), i + 1, result + prefixSimilarity(strToLC, suffix))
    }

    if (strToLC.isEmpty) 0
    else suffixSimilarityHelper(strToLC)
  }
}

object StringsSimilarityApplication extends App {
  val numOfTestCases: Int = scala.io.StdIn.readInt()
  val listOfStrings: List[String] = getListOfStrings(numOfTestCases)
  println("\nOutput\n")
  checkStringsSimilarity(listOfStrings)

  @tailrec
  def getListOfStrings(n: Int, i: Int = 1, list: List[String] = List()): List[String] = {
    val getLine = scala.io.StdIn.readLine()
    if (i >= n) list :+ getLine
    else getListOfStrings(n, i + 1, list :+ getLine)
  }

  @tailrec
  def checkStringsSimilarity(list: List[String], i: Int = 0): Unit = {
    if (i >= list.length) ()
    else {
      println(StringsSimilarity.calculateSimilarity(list(i)))
      checkStringsSimilarity(list, i + 1)
    }
  }
}

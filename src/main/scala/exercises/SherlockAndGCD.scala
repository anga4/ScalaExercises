package exercises

import scala.annotation.tailrec

object SherlockAndGCD {
  /*
    Solution Logic
    1 - If the given array contains 1 and the last element is
        greater than 1 then there exist a subset that satisfies
        the given condition.
    2 - If any two numbers in the given array are relatively prime
        and the element in first position is less than the second,
        then there exist a subset that satisfies the given condition.
        So, we start checking from the
        (1st and 2nd)elem, (2nd and 3rd)elem ... (last two)elem
   */

  def checkIfRelativelyPrimeSubsetExists(array: Array[Int]): String = {

    def gcdOfTwoNumbers(a: Int, b: Int): Int = b match {
      case 0 => a
      case n => gcdOfTwoNumbers(b, a % b)
    }

    def checkIfAnyTwoElementsSatisfy(array: Array[Int], x: Int = 0, y: Int = 1): String = {
      if (y >= array.length) "NO"
      else {
        val a = array(x)
        val b = array(y)
        if (a < b && gcdOfTwoNumbers(a, b) <= 1) "YES"
        else checkIfAnyTwoElementsSatisfy(array, x + 1, y + 1)
      }
    }

    if (array.init.contains(1) && array.last > 1) "YES"
    else checkIfAnyTwoElementsSatisfy(array)
  }
}

object SherlockAndGCDApplication extends App {

  val numOfTestCases: Int = scala.io.StdIn.readInt()
  val listOfTestCases: List[(Int, Array[Int])] = getListOfTestCases(numOfTestCases)
  println("\nOutput\n")
  listOfTestCases.foreach(testCase => println(SherlockAndGCD.checkIfRelativelyPrimeSubsetExists(testCase._2)))


  @tailrec
  def getListOfTestCases(n: Int, i: Int = 1, list: List[(Int, Array[Int])] = List()): List[(Int, Array[Int])] = {
    if (i > n) list
    else {
      val arrLen = scala.io.StdIn.readInt()
      val arr = scala.io.StdIn.readLine().split(" ").toArray.map(_.toInt)
      getListOfTestCases(n, i + 1, list :+ (arrLen, arr))
    }
  }
}
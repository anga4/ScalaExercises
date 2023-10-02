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

  def checkIfRelativelyPrimeSubsetExists(list: List[Int]): String = {

    def gcdOfTwoNumbers(a: Int, b: Int): Int = b match {
      case 0 => a
      case n => gcdOfTwoNumbers(b, a % b)
    }

    def checkIfAnyTwoElementsSatisfy(list: List[Int], x: Int = 0, y: Int = 1): String = {
      if (y >= list.length) "NO"
      else {
        val a = list(x)
        val b = list(y)
        if (a < b && gcdOfTwoNumbers(a, b) <= 1) "YES"
        else checkIfAnyTwoElementsSatisfy(list, x + 1, y + 1)
      }
    }

    if (list.init.contains(1) && list.last > 1) "YES"
    else checkIfAnyTwoElementsSatisfy(list)
  }
}

object SherlockAndGCDApplication extends App {

  val numOfTestCases: Int = scala.io.StdIn.readInt()
  val listOfTestCases: List[(Int, List[Int])] = getListOfTestCases(numOfTestCases)
  println("\nOutput\n")
  listOfTestCases.foreach(testCase => println(SherlockAndGCD.checkIfRelativelyPrimeSubsetExists(testCase._2)))


  @tailrec
  def getListOfTestCases(n: Int, i: Int = 1, finalList: List[(Int, List[Int])] = List()): List[(Int, List[Int])] = {
    if (i > n) finalList
    else {
      val listLen = scala.io.StdIn.readInt()
      val list = scala.io.StdIn.readLine().split(" ").toList.map(_.toInt)
      getListOfTestCases(n, i + 1, finalList :+ (listLen, list))
    }
  }
}
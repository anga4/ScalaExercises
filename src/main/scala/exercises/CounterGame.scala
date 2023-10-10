package exercises

object CounterGame {

  /*
    Solution Logic
    - Since it's a turn by turn game for two, I'm keeping track
      of each turn number
    - The first player (player1) gets the odd number 1
      by default, so all his future turns will be odd numbers.
    - Therefore, if the turn that can't make a move and loses is even,
      then player1 who ended the game in the previous odd turn
      by getting the counter to 1 wins and vice versa
   */

  def counterGame(n: Int): String = {
    val player1: String = "Louise"
    val player2: String = "Richard"

    def nextLowerPowerOf2(a: Int, result: Int = 2): Int = {
      if (a == 2 || result * 2 > a) result
      else nextLowerPowerOf2(a, result * 2)
    }

    def isPowerOf2(a: Int): Boolean = {
      def powerHelper(acc: Int): Boolean = {
        if (acc < 2 || acc % 2 != 0) false
        else if (acc == 2) true
        else powerHelper(acc / 2)
      }

      powerHelper(a)
    }

    def nextCounter(c: Int): Int = {
      if (isPowerOf2(c)) c / 2
      else c - nextLowerPowerOf2(c)
    }

    def gamePlay(counter: Int, moveNumber: Int = 1): Int = {
      if (counter == 1) moveNumber
      else gamePlay(nextCounter(counter), moveNumber + 1)
    }

    if (gamePlay(n) % 2 == 0) player1
    else player2
  }
}

object CounterGameApplication extends App {

  println("Enter a counter to start game")
  val startCounter = scala.io.StdIn.readInt()
  println("Game end")
  println(s"The Winner is ${CounterGame.counterGame(startCounter)}")
}

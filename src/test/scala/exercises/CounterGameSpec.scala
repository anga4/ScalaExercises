package exercises

import org.scalatest.funspec.AnyFunSpec

class CounterGameSpec extends AnyFunSpec {
  describe("Test Cases For Counter Game") {
    it("case 1: startCounter = 1 should return Richard as winner") {
      assert(CounterGame.counterGame(1) == "Richard")
    }
    it("case 2: startCounter = 6 should return Richard as winner") {
      assert(CounterGame.counterGame(6) == "Richard")
    }
    it("case 3: startCounter = 132 should return Louise as winner") {
      assert(CounterGame.counterGame(132) == "Louise")
    }
  }
}

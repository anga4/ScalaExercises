package exercises

import org.scalatest.funspec.AnyFunSpec

class SherlockAndGCDSpec extends AnyFunSpec {

  describe("Test Cases For Sherlock and GCD") {
    it("case 1 : Array(1, 2, 3) should return YES") {
      assert(SherlockAndGCD.checkIfRelativelyPrimeSubsetExists(Array(1, 2, 3)) == "YES")
    }
    it("case 2 : Array(2, 4) should return NO") {
      assert(SherlockAndGCD.checkIfRelativelyPrimeSubsetExists(Array(2, 4)) == "NO")
    }
  }
}

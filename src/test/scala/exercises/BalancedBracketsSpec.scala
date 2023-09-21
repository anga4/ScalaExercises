package exercises

import org.scalatest.funspec.AnyFunSpec

class BalancedBracketsSpec extends AnyFunSpec {

  describe("Test Cases For Balanced Brackets") {
    it("case 1 '{[()]}' : should return YES") {
      assert(BalancedBrackets.isBalanced("{[()]}") == "YES")
    }
    it("case 2 '{[(])}' : should return NO") {
      assert(BalancedBrackets.isBalanced("{[(])}") == "NO")
    }
    it("case 3 '{{[[(())]]}}' : should return YES") {
      assert(BalancedBrackets.isBalanced("{{[[(())]]}}") == "YES")
    }
  }
}

package exercises

import org.scalatest.funspec.AnyFunSpec

class StringsSimilaritySpec extends AnyFunSpec {

  describe("Test Cases For Strings Similarity") {
    it("case 1 : The String 'ababaa' should return 11") {
      assert(StringsSimilarity.calculateSimilarity("ababaa") == 11)
    }
    it("case 2 : The String 'Aa' should return 3") {
      assert(StringsSimilarity.calculateSimilarity("Aa") == 3)
    }
  }
}

package stealth

import org.scalatest._

class CafeSpec extends FlatSpec with Cafe {

  "the bill" should "have the right sum" in {
    assert(bill(Seq()) == 0)
    assert(bill(Seq("Cola")) == 0.50)
    assert(bill(Seq("Cola", "Coffee")) == 1.50)
    assert(bill(Seq("Cola", "Coffee", "Cheese Sandwich")) == 3.50)
    assert(bill(Seq("Cola", "Ignore Me!", "Coffee", "Cheese Sandwich")) == 3.50)
  }
}

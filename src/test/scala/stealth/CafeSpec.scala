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

  "the service" should "be correct" in {
    assert(service(Seq("Cola")) ==0)
    assert(service(Seq("Cola", "Coffee")) ==0)
    assert(service(Seq("Cheese Sandwich")) == 0.2)
    assert(service(Seq("Steak Sandwich")) == 0.9)
    assert(service(Seq("Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich","Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")) == 20)
    assert(service(Seq("Cheese Sandwich", "Cola")) == 0.25)
    assert(service(Seq("Cola", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich","Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")) == 20)
  }
}

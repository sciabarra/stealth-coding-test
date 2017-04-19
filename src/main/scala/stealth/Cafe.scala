package stealth

trait Cafe {

  case class Food(price: Double, hot: Boolean = false, drink: Boolean = false, food: Boolean = false)

  val menu = Map(
    "Cola" -> Food(.50, false, true, false),
    "Coffee" -> Food(1d, true, true, false),
    "Cheese Sandwich" -> Food(2d, false, false, true),
    "Steak Sandwich" -> Food(4.50, true, false, true)
  )

  def bill(order: Seq[String]) =
    order.map(x => menu.get(x)
      .getOrElse(Food(0)).price).sum

  def service(order: Seq[String]) = {

    val onlyDrink = order.map(x => menu.get(x).getOrElse(Food(0)).drink).reduce(_ && _)

    val hotFood = order.map { x =>
      val f = menu.get(x).getOrElse(Food(0))
      f.food && f.hot
    }.reduce(_ || _)

    val res = if (onlyDrink) {
      0d
    } else {
      if (hotFood) {
        Math.min(bill(order) * 0.2, 20)
      } else {
        bill(order) * 0.1
      }
    }

    ((res * 100).toInt)/100d

  }
}
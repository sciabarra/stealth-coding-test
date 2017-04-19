package stealth

trait Cafe {

  case class Food(price: Double, hot: Boolean)

  val menu = Map(
    "Cola" -> Food(.50, false),
    "Coffee" -> Food(1d, true),
    "Cheese Sandwich" -> Food(2d, false),
    "Steak Sandwich" -> Food(4.50, false)
  )

  def bill(order: Seq[String]) =
    order.map(x => menu.get(x)
      .getOrElse(Food(0,false)).price).sum

}
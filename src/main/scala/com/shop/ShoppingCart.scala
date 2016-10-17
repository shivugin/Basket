package com.shop

import scala.math.BigDecimal.RoundingMode

/**
  * Created by Shiva on 16/10/2016.
  */
object ShoppingCart {

  // Each Item price.
  private val itemsPriceList: Map[String, Double] = Map(("Butter", 0.80), ("Milk", 1.15),("Bread",1.00))

  def getPrice(item: String): Double = {
    itemsPriceList.getOrElse(item toLowerCase, 0)
  }

  def price(item: String): Option[Double] = itemsPriceList.get(item toLowerCase)

  /**
    * To perform checkout operation with list of selected items
    * @param items A list of items
    * @return      Total cost
    */
  def checkout(items: Array[String]): Double = {
    val total = items.flatMap(price).sum
    BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN).toDouble;
  }

  /**
    * To perfrom checkout operation with list of selected items and provided offers
    * @param items
    * @return
    */
  def checkoutWithOffers(items: Array[String]): Double = {
    val noOfButter: Int = items.count(p => p.equalsIgnoreCase("Butter"))
    val noOfMilk: Int = items.count(p => p.equalsIgnoreCase("Milk"))
    val noOfBread: Int=items.count(p=> p.equalsIgnoreCase("Bread"))

    // To calculate total items price based on offers
    val totalPrice = Offers.offer("Butter")(noOfButter) + Offers.offer("Milk")(noOfMilk) + Offers.offer("Bread")(noOfBread)

    // To round total price to half even
    BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

}

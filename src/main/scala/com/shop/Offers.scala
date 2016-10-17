package com.shop

/**
  * To define online application offers
  * Created by Shiva on 16/10/2016.
  */
object Offers {

  /**
    * Offer for Items : Buy one and get one free
    *
    * @param noOfItems     Number of item selected
    * @param oneItemPrice  Each item price
    * @return
    */
  def buyOneGetOneOffer(noOfItems: Int, oneItemPrice: Double): Double = ((noOfItems / 2) + (noOfItems % 2)) * oneItemPrice

  
  /**
    * Offer for Items : 4 for the price of 3 (Milk)
    *
    * @param noOfItems     Number of item selected
    * @param oneItemPrice  Each item price
    * @return
    */
  def fourForThreeOffer(noOfItems: Int, oneItemPrice: Double): Double = (3 * (noOfItems/4) + (noOfItems %4)) * oneItemPrice


  /**
    * Calculate offers based on item types: Butter, Milk, Bread
    *
    * @param item  item : Butter, Milk or Bread
    * @return
    */
  def offer(item: String): Int => Double = {
    val price: Double = ShoppingCart.getPrice(item)

    item toLowerCase() match {
      case "butter" => (noOfItems:Int) => buyOneGetOneOffer(noOfItems,price)
      case "milk" => (noOfItems:Int) => fourForThreeOffer(noOfItems, price)
      case _ => (noOfItems:Int) => noOfItems * price
    }
  }

}

package com.shop

import org.specs2.mutable.Specification

/**
  * To test Online Store Shopping Cart functionality
  *
  * @author Created by Shiva on 16/10/2016.
  */
class ShoppingICartTest extends Specification {

  "An Butter Price should be 0.80" in {
    ShoppingCart.getPrice("Butter") must be equalTo 0.80
  }

  "An Milk price should be 1.15" in {
    ShoppingCart.getPrice("Milk") must be equalTo 1.15
  }

  "An Bread price should be 1.00" in {
    ShoppingCart.getPrice("Bread") must be equalTo 1.00
  }

  "Item's Price which doesn't exist in the store should be 0" in {
    ShoppingCart.getPrice("None") must be equalTo 0
  }

  "ShoppingCart.getPrice should work in case-insensitive manner" in {
    ShoppingCart.getPrice("BUTTER") must be equalTo 0.80
    ShoppingCart.getPrice("MILK") must be equalTo 1.15
    ShoppingCart.getPrice("BREAD") must be equalTo 1.00

  }

  "In ShoppingCart, Checkout should show the price of 5 Butter: 4.0" in {
    ShoppingCart.checkout(Array("butter", "butter", "butter", "butter", "butter")) must be equalTo 4.0
  }

  "In ShoppingCard, Checkout should show the price of 10 butter: 8.0" in {
    ShoppingCart.checkout(Array("butter", "butter", "butter","butter", "butter", "butter", "butter","butter", "butter", "butter")) must be equalTo 8.0
  }

  "In ShoppingCart, Checkout should show the price of 4 Milk: 4.6" in {
    ShoppingCart.checkout(Array("milk", "milk", "milk", "milk")) must be equalTo 4.6
  }

  "In ShoppingCart, Checkout should show the price of 2 Bread : 2.0" in {
    ShoppingCart.checkout(Array("bread", "bread")) must be equalTo 2.0
  }

  // Requested combination
  "In ShoppingCart, Checkout should show the price of one butter, one bread and one milk : 2.95" in {
    ShoppingCart.checkout(Array("butter", "milk", "bread")) must be equalTo 2.95
  }

  "In ShoppingCart, Checkout should show the price of 3 butter and 3 milk: 5.85" in {
    ShoppingCart.checkout(Array("butter", "butter", "butter", "milk", "milk", "milk")) must be equalTo 5.85
  }

  "In ShoppingCart, irrespective of the items order, Checkout should show the price of 3 butter and 3 bread: 5.85" in {
    ShoppingCart.checkout(Array("butter", "milk", "milk", "butter", "butter", "milk")) must be equalTo 5.85
  }

  "In ShoppingCart, irrespective of the items order, Checkout should show the price of Butter, Butter, Milk, Butter: 3.55" in {
    ShoppingCart.checkout(Array("Butter", "Butter", "Milk", "Butter")) must be equalTo 3.55
  }

  "On 'Buy One Get One' Offer: When one Butter cost is 0.80, then checkout should show 2 Butter cost: 0.80" in {
    ShoppingCart.checkoutWithOffers(Array("butter", "butter")) must be equalTo 0.80
  }

  "On 'Buy One Get One' Offer: When one Butter cost is 0.80, then checkout should show 3 Butter cost: 1.60" in {
    ShoppingCart.checkoutWithOffers(Array("butter", "butter", "butter")) must be equalTo 1.60
  }

  "On 'Four For Three' Offer: When one Milk cost is 1.15, then checkout should show 4 Milk cost: 3.45" in {
    ShoppingCart.checkoutWithOffers(Array("Milk", "Milk", "Milk", "Milk")) must be equalTo 3.45
  }

  "On 'Four For Three' Offer: When one Milk cost is 1.15, then checkout should show 5 Milk cost: 4.60" in {
    ShoppingCart.checkoutWithOffers(Array("milk", "milk", "milk", "milk", "milk")) must be equalTo 4.60
  }

  """ On 'Buy One Get One' and 'Four For Three' Offers: When one Butter cost is 0.80, one Milk cost is 1.15 and
      one Bread cost 1.00 then checkout should show 2 Butter cost: 0.80 and 4 Milk cost: 3.45
      Total price: 4.25 """ in {
    ShoppingCart.checkoutWithOffers(Array("butter", "butter")) must be equalTo 0.80
    ShoppingCart.checkoutWithOffers(Array("milk", "milk", "milk","milk")) must be equalTo 3.45
    ShoppingCart.checkoutWithOffers(Array("butter", "milk", "milk", "butter", "milk","milk")) must be equalTo 4.25
  }


}

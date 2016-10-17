package com.shop

import org.specs2.mutable.Specification

/**
  * To test Store Offers functionality
  *
  * @author Shiva
  */
class OffersITest extends Specification {

  "On Buy One Get One offer: When one item cost is 0.60, then 2 items cost should be 0.60" in {
    Offers.buyOneGetOneOffer(2, 0.60) must be equalTo 0.60
  }

  "On Buy One Get One offer: When one item cost is 0.60, then 3 items cost should be 1.20" in {
    Offers.buyOneGetOneOffer(3, 0.60) must be equalTo 1.20
  }

  "On Four For Three offer: When one item cost is 1.15, then 4 items cost should be 3.45" in {
    Offers.fourForThreeOffer(4 , 1.15) must be equalTo 3.45
  }

  "On Three For Two offer: When one item cost is 1.15, then 8 items cost should be 6.90" in {
    Offers.fourForThreeOffer(6 , 0.60) must be equalTo 6.90
  }

  "Apples have Buy One Get One offer" in {
    Offers.offer("butter")(2) must be equalTo ShoppingCart.getPrice("butter")
  }

  "Milk have Three For Two offer" in {
    Offers.offer("Milk")(4) must be equalTo (3 * ShoppingCart.getPrice("Milk"))
  }

}


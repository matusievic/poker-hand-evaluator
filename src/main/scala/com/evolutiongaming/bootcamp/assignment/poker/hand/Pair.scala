package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Card

object Pair extends Hand {
  val Weight: Int = ???

  override def calculateHandWeight(hand: List[Card]): Option[Int] = ???
}

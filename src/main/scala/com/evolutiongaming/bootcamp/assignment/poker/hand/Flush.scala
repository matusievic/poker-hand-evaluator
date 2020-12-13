package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Card

object Flush extends Hand {
  override val Weight: Int = ???

  override def calculateHandWeight(hand: List[Card]): Option[Int] = ???
}

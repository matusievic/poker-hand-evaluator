package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Card

trait Hand {
  val Weight: Int

  def calculateHandWeight(hand: List[Card]): Option[Int]
}

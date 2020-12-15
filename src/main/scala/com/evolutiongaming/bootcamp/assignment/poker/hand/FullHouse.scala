package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object FullHouse extends HandRankingCategory {
  override val Weight: Int = ???

  override def calculateHandWeight(hand: Hand): Option[Int] = {
    val groupedCards = hand.groupBy(identity)
    Option.when(groupedCards.size == 2) {
      // TODO: Highest card rank by three first
      Weight
    }
  }
}

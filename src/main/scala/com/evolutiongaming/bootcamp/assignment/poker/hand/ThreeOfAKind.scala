package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object ThreeOfAKind extends HandRankingCategory {
  override val Weight: Int = ???

  override def calculateHandWeight(hand: Hand): Option[Int] = {
    val countOfCards = hand.groupMapReduce(identity)(_ => 1)(_ + _)
    Option.when(countOfCards.size == 3 && countOfCards.exists { case (card, count) => count == 3 }) {
      // TODO: Highest card rank
      Weight
    }
  }
}

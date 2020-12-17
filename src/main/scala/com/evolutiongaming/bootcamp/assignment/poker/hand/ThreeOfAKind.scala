package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object ThreeOfAKind extends HandRankingCategory {
  override val weight: Long = 3 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    val countOfCards = hand.groupMapReduce(identity)(_ => 1)(_ + _)
    Option.when(countOfCards.size == 3 && countOfCards.exists { case (_, count) => count == 3 }) {
      val ranks = countOfCards.collect {
        case (card, count) if count == 3 => card.rank.id + 15
        case (card, _) => card.rank.id
      }.toSeq
      calculateTieWeight(ranks) + weight
    }
  }
}

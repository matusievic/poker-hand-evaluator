package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object TwoPairs extends HandRankingCategory {
  override val weight: Long = 3 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    val rankToCount = hand.groupMapReduce(_.rank)(_ => 1)(_ + _)
    Option.when(rankToCount.size == 3) {
      val ranks = rankToCount.collect {
        case (rank, count) if count == 2 => rank.id + 15
        case (rank, _) => rank.id
      }.toSeq
      calculateTieWeight(ranks) + weight
    }
  }
}

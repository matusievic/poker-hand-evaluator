package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object Pair extends HandRankingCategory {
  override val weight: Long = 2 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    Option.when(hand.distinctBy(_.rank).length == 4) {
      val ranks = hand.groupMapReduce(_.rank)(_ => 1)(_ + _).collect {
        case (rank, count) if count == 2 => rank.id + 15
        case (rank, _) => rank.id
      }.toSeq
      calculateTieWeight(ranks) + weight
    }
  }
}

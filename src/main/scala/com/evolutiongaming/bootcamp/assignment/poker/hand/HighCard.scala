package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object HighCard extends HandRankingCategory {
  override val weight: Long = 1 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    Option(super.calculateTieWeight(hand.map(_.rank.id)) + weight)
  }
}

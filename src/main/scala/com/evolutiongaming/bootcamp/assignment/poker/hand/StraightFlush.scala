package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object StraightFlush extends HandRankingCategory {
  override val weight: Long = 8 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    val straightWeight = Straight.calculateHandWeight(hand)
    Option.when(hand.distinctBy(_.suit).length == 1 && straightWeight.isDefined) {
      straightWeight.get - Straight.weight + weight
    }
  }
}

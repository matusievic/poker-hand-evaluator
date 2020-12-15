package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object HighCard extends HandRankingCategory {
  override val Weight: Int = 1

  override def calculateHandWeight(hand: Hand): Option[Int] = {
    Option(hand.map(_.rank.id).max * Weight)
  }
}

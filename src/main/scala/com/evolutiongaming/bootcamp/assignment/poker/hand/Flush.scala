package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object Flush extends HandRankingCategory {
  override val Weight: Int = ???

  override def calculateHandWeight(hand: Hand): Option[Int] = {
    Option.when(hand.distinctBy(_.suit).length == 1)(Weight)
  }
}

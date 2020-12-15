package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

object Pair extends HandRankingCategory {
  val Weight: Int = ???

  override def calculateHandWeight(hand: Hand): Option[Int] = {
    Option.when(hand.distinctBy(_.rank).length == 4)(Weight)
  }
}

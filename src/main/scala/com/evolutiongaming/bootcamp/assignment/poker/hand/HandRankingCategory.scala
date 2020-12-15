package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

trait HandRankingCategory {
  val Weight: Int

  def calculateHandWeight(hand: Hand): Option[Int]
}

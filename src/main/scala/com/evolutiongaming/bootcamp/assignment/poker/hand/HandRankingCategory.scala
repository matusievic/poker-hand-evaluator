package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand

trait HandRankingCategory {
  def weight: Long = 1_00_00_00_00_00L

  def calculateHandWeight(hand: Hand): Option[Long]

  def calculateTieWeight(ranks: Seq[Int]): Long = {
    ranks.sorted.reverse.reduce[Int]((l, r) => l * 100 + r)
  }
}

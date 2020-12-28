package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.{Hand, Ranks}

object Straight extends HandRankingCategory {
  override val weight: Long = 5 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    val sortedRanks = hand.map(_.rank.id).sorted
    val rankValues = if (sortedRanks.contains(Ranks.Two.id) && sortedRanks.count(_ == Ranks.Ace.id) == 1) {
      sortedRanks.map(r => if (r == Ranks.Ace.id) Ranks.Two.id - 1 else r)
    } else sortedRanks
    Option.when(sortedRanks.distinct.size == sortedRanks.size && areConsecutive(rankValues))(calculateTieWeight(rankValues) + weight)
  }

  private def areConsecutive(ranks: Seq[Int]): Boolean = ranks.sliding(2).count(n => n(0) + 1 == n(1)) == (ranks.length - 1)

}

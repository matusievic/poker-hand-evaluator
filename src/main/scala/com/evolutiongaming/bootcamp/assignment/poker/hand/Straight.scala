package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.{Hand, Ranks}

object Straight extends HandRankingCategory {
  override val weight: Long = 4 * super.weight

  override def calculateHandWeight(hand: Hand): Option[Long] = {
    val sortedRanks = hand.map(_.rank.id).sorted
    val rankValues = if (sortedRanks.contains(Ranks.Two.id) && sortedRanks.contains(Ranks.Ace.id)) {
      sortedRanks.map(r => if (r == Ranks.Ace.id) Ranks.Two.id - 1 else r)
    } else sortedRanks
    Option.when(areConsecutive(sortedRanks))(calculateTieWeight(rankValues) + weight)
  }

  private def areConsecutive(ranks: Seq[Int]): Boolean = {
    def check(numbers: Seq[Int]) = numbers.sliding(2).count(n => n(0) + 1 == n(1)) == numbers.length

    if (ranks.contains(Ranks.Ace.id)) {
      check(ranks.filterNot(_ == Ranks.Ace.id)) && (ranks.contains(Ranks.Two.id) || ranks.contains(Ranks.King.id))
    } else {
      check(ranks)
    }
  }
}

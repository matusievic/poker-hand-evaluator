package com.evolutiongaming.bootcamp.assignment.poker.hand

import com.evolutiongaming.bootcamp.assignment.poker.domain.{Hand, Ranks}

object Straight extends HandRankingCategory {
  override val Weight: Int = ???

  override def calculateHandWeight(hand: Hand): Option[Int] = {
    val sortedRanks = hand.map(_.rank.id).sorted
    Option.when(areConsecutive(sortedRanks)){
      // TODO: Add checking of highest card in the hand
      Weight
    }
  }

  private def areConsecutive(ranks: Seq[Int]): Boolean = {
    def check(numbers: Seq[Int]) = numbers.sum == ((numbers.min + numbers.max) / 2) * numbers.length

    if (ranks.contains(Ranks.Ace.id)) {
      check(ranks.filterNot(_ == Ranks.Ace.id)) && (ranks.contains(Ranks.Two.id) || ranks.contains(Ranks.King.id))
    } else {
      check(ranks)
    }
  }
}

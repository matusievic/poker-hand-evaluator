package com.evolutiongaming.bootcamp.assignment.poker.game

import com.evolutiongaming.bootcamp.assignment.poker.domain.Hand
import com.evolutiongaming.bootcamp.assignment.poker.hand._

object FiveCardDraw {
  def evaluate(hands: Seq[Hand]): Seq[Hand] = {
    hands.filter(_.length == 5).sortBy(evaluateHand)
  }

  private def evaluateHand(hand: Hand): Long = {
    rankingCategories.flatMap(_.calculateHandWeight(hand)).head
  }

  private val rankingCategories: Seq[HandRankingCategory] = Seq(
    StraightFlush,
    FourOfAKind,
    FullHouse,
    Flush,
    Straight,
    ThreeOfAKind,
    TwoPairs,
    Pair,
    HighCard
  )
}

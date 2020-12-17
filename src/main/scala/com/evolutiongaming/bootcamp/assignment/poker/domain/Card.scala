package com.evolutiongaming.bootcamp.assignment.poker.domain

import com.evolutiongaming.bootcamp.assignment.poker.domain.Ranks.Rank
import com.evolutiongaming.bootcamp.assignment.poker.domain.Suits.Suit

case class Card(suit: Suit, rank: Rank) {
  override def toString: String = rank.toString + suit.toString
}

object Card {
  def apply(stringRepresentation: String): Option[Card] = {
    for {
      rank <- Ranks.fromCharacter(stringRepresentation.charAt(0))
      suit <- Suits.fromCharacter(stringRepresentation.charAt(1))
    } yield Card(suit, rank)
  }
}

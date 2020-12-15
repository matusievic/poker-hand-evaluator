package com.evolutiongaming.bootcamp.assignment.poker.domain

import com.evolutiongaming.bootcamp.assignment.poker.domain.Ranks.Rank
import com.evolutiongaming.bootcamp.assignment.poker.domain.Suits.Suit

case class Card(suit: Suit, rank: Rank)

object Card {
  def apply(stringRepresentation: String): Option[Card] = {
    for {
      suit <- Suits.fromCharacter(stringRepresentation.charAt(0))
      rank <- Ranks.fromCharacter(stringRepresentation.charAt(1))
    } yield Card(suit, rank)
  }
}

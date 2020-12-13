package com.evolutiongaming.bootcamp.assignment.poker.domain

object Suits extends Enumeration {
  type Suit = Value

  val Club, Diamond, Heart, Spade = Value

  def fromCharacter(char: Char): Option[Suit] = {
    Suits.values.find(s => s.toString.toLowerCase.charAt(0) == char.toLower)
  }
}

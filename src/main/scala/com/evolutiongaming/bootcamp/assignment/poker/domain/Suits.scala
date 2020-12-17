package com.evolutiongaming.bootcamp.assignment.poker.domain

object Suits extends Enumeration {
  type Suit = Value

  val Club = Value("c")
  val Diamond = Value("d")
  val Heart = Value("h")
  val Spade = Value("s")

  def fromCharacter(char: Char): Option[Suit] = {
    Suits.values.find(s => s.toString.toLowerCase.charAt(0) == char.toLower)
  }
}

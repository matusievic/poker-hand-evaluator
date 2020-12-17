package com.evolutiongaming.bootcamp.assignment.poker.domain

object Ranks extends Enumeration {
  type Rank = Value

  val Ace = Value(14, "A")
  val King = Value(13, "K")
  val Queen = Value(12, "Q")
  val Jack = Value(11, "J")
  val Ten = Value(10, "T")
  val Nine = Value(9, "9")
  val Eight = Value(8, "8")
  val Seven = Value(7, "7")
  val Six = Value(6, "6")
  val Five = Value(5, "5")
  val Four = Value(4, "4")
  val Three = Value(3, "3")
  val Two = Value(2, "2")


  def fromCharacter(char: Char): Option[Rank] = {
    Ranks.values.find(s => s.toString.toLowerCase.charAt(0) == char.toLower)
  }
}

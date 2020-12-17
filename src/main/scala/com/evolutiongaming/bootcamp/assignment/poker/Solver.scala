package com.evolutiongaming.bootcamp.assignment.poker

import com.evolutiongaming.bootcamp.assignment.poker.domain.{Card, Hand}
import com.evolutiongaming.bootcamp.assignment.poker.game.FiveCardDraw

object Solver {
  // TODO: implement solution logic
  def process(line: String): String = {
    val ErrorPrefix = "Error: "

    line.toLowerCase.split("\\s+").toList match {
      case "texas-holdem" :: board :: hands   => hands.sorted.mkString(" ")
      case "omaha-holdem" :: board :: hands   => ErrorPrefix + "The solution doesn't support Omaha Hold'em"
      case "five-card-draw" :: hands          => {
        val value = fromInput(hands)
        val value1 = FiveCardDraw.evaluate(value)
        toOutput(value1)
      }
      case x :: _                             => ErrorPrefix + "Unrecognized game type"
      case _                                  => ErrorPrefix + "Invalid input"
    }
  }

  def fromInput(hands: Seq[String]): Seq[Hand] = {
    hands.map(hand => hand.grouped(2).flatMap(Card(_)).toSeq)
  }

  def toOutput(hands: Seq[Hand]): String = {
    hands.map(_.mkString).mkString(" ")
  }
}

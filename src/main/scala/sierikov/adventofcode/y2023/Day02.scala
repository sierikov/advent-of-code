package sierikov.adventofcode.y2023

import sierikov.adventofcode.Problem
import sierikov.adventofcode.y2023.Day02.Domain.*
import sierikov.adventofcode.y2023.Day02.Domain.Color.*
import sierikov.utils.Files

object Day02 extends Problem[List[String], Int] {

  override def parse(res: String): List[String] = Files.read(res)

  override def first(input: List[String]): Int = input
    .map(Game.fromString)
    .filter(_.isPossibleWithDefault)
    .map(_.gameId)
    .sum

  override def second(input: List[String]): Int = input
    .map(Game.fromString)
    .map(_.minConfiguration.power)
    .sum

  object Domain {
    case class Game(gameId: Int, minConfiguration: Configuration) {
      def isPossibleWithDefault: Boolean = Configuration.isPossible(minConfiguration)
    }

    object Game {
      private val gameRegex = """Game (\d+): (\S.+)""".r

      def fromString(gameString: String): Game = gameString match {
        case gameRegex(gameId, configurationStr) => Game(gameId.toInt, Configuration.fromString(configurationStr))
        case _ => throw new IllegalArgumentException(s"Invalid game string: $gameString")
      }
    }

    sealed trait Color
    object Color {
      case object Red extends Color

      case object Green extends Color

      case object Blue extends Color
    }

    case class Configuration(redCubes: Option[Int], greenCubes: Option[Int], blueCubes: Option[Int]) {
      def power: Int = (for {
        red   <- redCubes
        green <- greenCubes
        blue  <- blueCubes
      } yield red * green * blue).getOrElse(0)
    }

    object Configuration {

      private val default = Configuration(Some(12), Some(13), Some(14))

      def isPossible(config: Configuration): Boolean =
        default.blueCubes.getOrElse(0) >= config.blueCubes.getOrElse(0) &&
          default.greenCubes.getOrElse(0) >= config.greenCubes.getOrElse(0) &&
          default.redCubes.getOrElse(0) >= config.redCubes.getOrElse(0)

      def fromString(config: String): Configuration = {
        val combinations = config.split(";").toList.map(GameCombination.fromString)
        minimumRequiredCubes(combinations.flatten)
      }

      def fromMap(map: Map[Color, Int]): Configuration = Configuration(map.get(Red), map.get(Green), map.get(Blue))

      private def minimumRequiredCubes(combinations: List[GameCombination]): Configuration = {
        val colors = combinations.groupMap(_.color)(_.count).map((color, numbers) => color -> numbers.max)
        Configuration.fromMap(colors)
      }
    }

    case class GameCombination(color: Color, count: Int)

    private object GameCombination {
      private val tokenRegex = """(\d+) (\w+)""".r

      def fromString(setString: String): List[GameCombination] = setString.split(",").toList.map(_.trim).map {
        case tokenRegex(count, color) =>
          color match {
            case "red"   => GameCombination(Red, count.toInt)
            case "green" => GameCombination(Green, count.toInt)
            case "blue"  => GameCombination(Blue, count.toInt)
            case _       => throw new IllegalArgumentException(s"Unsupported color: $color")
          }
        case _ => throw new IllegalArgumentException(s"Invalid token: $setString")
      }
    }

  }
}

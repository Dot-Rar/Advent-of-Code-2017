import scala.io.Source

object Puzzle1 extends App {

  override def main(args: Array[String]): Unit = {
    var lines = (for (line <- Source.fromFile("day5.txt").getLines) yield line).toList.map(_.toInt)
    var i = 0
    var steps = 0

    while(i < lines.length) {
      steps += 1
      val element = lines(i)
      lines = lines.updated(i, element+1)
      i += element
    }

    println(steps)
  }
}

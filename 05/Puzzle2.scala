import scala.io.Source

object Puzzle2 extends App {

  override def main(args: Array[String]) {
    var lines = (for (line <- Source.fromFile("day5.txt").getLines) yield line).toList.map(_.toInt)
    var i = 0
    var steps = 0

    while(i < lines.length) {
      steps += 1
      val element = lines(i)

      val offset =
        if(element >= 3) -1
        else 1

      lines = lines.updated(i, element+offset)
      i += element
    }

    println(steps)
  }
}

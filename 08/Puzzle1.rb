require 'set'

class Main
  def main
    expression = /(\w+) (inc|dec) (-?\d+) [if]+ (\w+) (==|>=|<=|!=|>|<) (-?\d+)/
    lines = File.readlines("day8.txt")
    vars = Set.new

    lines.each do |line|
      match = line.match(expression)
      var = match[1]

      next if vars.include?(var)

      eval("@#{var} = 0")
      vars.add(var)
    end

    lines.each do |line|
      match = line.match(expression)

      var = match[1]
      increase = match[2] == "inc"
      offset = match[3]
      if eval("@#{match[4]} #{match[5]} #{match[6]}")
        if increase
          eval("@#{var} += #{offset}")
        else
          eval("@#{var} -= #{offset}")
        end
      end
    end

    largest = 0
    vars.each do |var|
      val = eval("@#{var}")
      largest = val if val > largest
    end
    puts largest
  end
end

Main.new.main

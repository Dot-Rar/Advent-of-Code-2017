using System;

namespace Puzzle_1 {

	public class Puzzle_1 {

		static void Main(string[] args) {
			Puzzle_1 instance = new Puzzle_1();
			Console.WriteLine(instance.Solve("1122"));
			Console.WriteLine(instance.Solve("1111"));
			Console.WriteLine(instance.Solve("1234"));
			Console.WriteLine(instance.Solve("91212129"));
		}

		public int Solve(string num) {
			int index = 0;
			int result = 0;
			foreach (char digit in num) {
				index++;

				int nextCharIndex = index == num.Length ? 0 : index;
				char nextChar = num[nextCharIndex];
				if (nextChar.Equals(digit)) {
					result += int.Parse(digit.ToString());
				}
			}
			return result;
		}
	}
}

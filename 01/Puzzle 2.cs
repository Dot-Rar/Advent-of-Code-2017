using System;

namespace Puzzle_2 {

	public class Puzzle_2 {

		static void Main(string[] args) {
			Puzzle_2 instance = new Puzzle_2();
			Console.WriteLine(instance.Solve("1212"));
			Console.WriteLine(instance.Solve("1221"));
			Console.WriteLine(instance.Solve("123425"));
			Console.WriteLine(instance.Solve("123123"));
			Console.WriteLine(instance.Solve("12131415"));
		}

		public int Solve(string num) {
			int index = 0;
			int result = 0;
			foreach (char digit in num) {
				index++;

				int nextCharIndex = index + (num.Length / 2);
				if (nextCharIndex > num.Length) nextCharIndex = nextCharIndex - num.Length;

				char nextChar = num[nextCharIndex-1];
				if (nextChar.Equals(digit)) {
					result += int.Parse(digit.ToString());
				}
			}
			return result;
		}
	}
}

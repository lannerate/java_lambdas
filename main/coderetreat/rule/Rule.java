package coderetreat.rule;

/**
 * Created by apple on 9/17/16.
 */
public class Rule {
//		private int priorty = 0;

//		public Rule(int priorty){ this.priorty = priorty; };

		public String match(int input) {
				String result = "";

				if (String.valueOf(input).contains("3") && input %3 !=0 )
						result = "FizzBuzzWhizz";

				else {

						if (input % 3 == 0) {
								result += "Fizz";
						}

						if (input % 5 == 0) {
								result += "Buzz";
						}

						if (input % 7 == 0) {
								result += "Whizz";
						}
				}

				return result.equals("") ? String.valueOf(input) : result;
		}
//		public int getPriorty(){
//				return this.priorty;
//		}

}

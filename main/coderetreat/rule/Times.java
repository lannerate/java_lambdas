package coderetreat.rule;

/**
 * Created by apple on 9/17/16.
 */
public class Times extends Rule{

//		public Times(int priorty) {
//				super(priorty);
//		}

		@Override
		public String match(int input) {
				String result = "";

				if (input % 3 == 0) {
						result += "Fizz";
				}
				else if (input % 5 == 0) {
						result += "Buzz";
				}
				else if (input % 7 == 0) {
						result += "Whizz";
				}

				return result;
		}
}

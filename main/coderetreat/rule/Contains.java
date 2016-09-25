package coderetreat.rule;

/**
 * Created by apple on 9/17/16.
 */
public class Contains extends Rule {

//		public Contains(int priorty) {
//				super(priorty);
//		}

		@Override
		public String match(int input) {
				if (String.valueOf(input).contains("3") && input %3 !=0 && input%5 != 0 && input%7 != 0 )
         return "FizzBuzzWhizz";

				return "";
		}
}

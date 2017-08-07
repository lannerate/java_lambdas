package coderetreat.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 9/17/16.
 */
public class Matcher {

		private static List<Rule> ruleList = new ArrayList<>();

		public static void setRules(Rule... rules) {
		   ruleList.addAll(Arrays.asList(rules));
		}

		public static String matches(int input){

				List<String> ruleResults = new ArrayList<>();

				ruleList.stream()
								.forEach( rule -> {
										if( !rule.match(input).equals("") )
												ruleResults.add(rule.match(input));
										else
												ruleResults.add(String.valueOf(input));
								} );

				return ruleResults.get(0);
		}
}

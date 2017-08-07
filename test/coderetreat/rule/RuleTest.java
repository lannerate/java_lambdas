package coderetreat.rule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by apple on 9/17/16. */ public class RuleTest { //		@Test

		@Test
		public void test_contains_three_then_get_FizzBuzzWhizz(){
				Matcher.setRules(new Rule());

				assertEquals("FizzBuzzWhizz",Matcher.matches( 13 ));
				assertEquals("FizzBuzzWhizz",Matcher.matches(  5 * 7 ));

		}

		@Test
		public void test_times_matches(){
				Matcher.setRules(new Rule());

				assertEquals("Fizz",Matcher.matches( 3 ));
				assertEquals("Buzz",Matcher.matches( 5 ));
				assertEquals("Whizz",Matcher.matches( 7 ));

				assertEquals("Fizz",Matcher.matches( 3 * 2 ));
				assertEquals("Buzz",Matcher.matches( 5 * 4 ));
				assertEquals("Whizz",Matcher.matches( 7 * 2 ));

				assertEquals("FizzBuzz",Matcher.matches( 3 * 5 ));
				assertEquals("FizzWhizz",Matcher.matches( 3 * 7 ));
				assertEquals("BuzzWhizz",Matcher.matches( 5 * 7 * 2));

		}
}

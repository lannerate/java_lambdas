package fp.buildinterface;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 9/25/16.
 */
public class FunctionTest {

    @Test
    public void testFuntion(){

        Function<String,Integer> toInteger = (str) -> Integer.valueOf(str);
        Function<String,String> backToString = toInteger.andThen(String::valueOf);
        Function<String,Double> toDouble = Double::valueOf;

        assertEquals(12, toInteger.apply("12").intValue() );
        assertEquals("23", backToString.apply("23"));
        assertEquals(Double.valueOf(23.3), toDouble.apply("23.3"));

    }

}

package fp.buildinterface;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 9/25/16.
 */
public class PredicatesTest {

    @Test
    public void testPredicate(){
        Predicate<String> predicate = (s) -> s.length() > 0;

        assertTrue( predicate.test("fool") );
        assertTrue( predicate.negate().test("") );

        Predicate<Boolean> notNull = Objects::nonNull;
        assertTrue(notNull.test(Boolean.FALSE));


        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> isNotEmpty = isEmpty.negate();

        assertTrue(isEmpty.test(""));
        assertTrue(isNotEmpty.test("tt"));

    }
}

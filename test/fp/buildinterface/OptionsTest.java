package fp.buildinterface;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 9/25/16.
 */
public class OptionsTest {

    @Test
    public void testOptional(){

        Optional<String> optional = Optional.of("test");
        assertTrue(optional.isPresent());
        assertEquals("test", optional.get());
        assertEquals("teet", optional.orElseGet(() -> "test"));

    }
}

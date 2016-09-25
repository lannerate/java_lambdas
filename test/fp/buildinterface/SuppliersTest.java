package fp.buildinterface;

import fp.stream.Person;
import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 9/25/16.
 */
public class SuppliersTest {

    @Test
    public void testSuppliers(){
        Supplier<Person> supplier = Person::new;

        assertTrue(supplier.get() instanceof Person);
    }
}

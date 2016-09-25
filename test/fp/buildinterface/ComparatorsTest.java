package fp.buildinterface;

import fp.stream.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by apple on 9/25/16.
 */
public class ComparatorsTest {

    @Test
    public void testComparators(){
        Comparator<Person> comparator = (p1,p2) -> p1.name.compareTo(p2.name);

        Arrays.asList(new Person("Eliden",23), new Person("Aida",23), new Person("Lindsay",32))
              .stream().sorted(comparator).forEach( e -> System.out.println(e.name));
    }
}

package fp.buildinterface;

import fp.stream.Person;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * Created by apple on 9/25/16.
 */
public class ConsumersTest {

    @Test
    public void testConsumers(){

        Consumer<Person> consumer = person -> System.out.println(person.name);

        consumer.accept(new Person("Jake",30));
    }
}

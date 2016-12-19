package fp.buildinterface;

import fp.stream.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by apple on 9/25/16.
 */
public class ComparatorsTest {

    @Test
    public void testComparators(){
        Comparator<Person> comparatorByAge = (p1,p2) -> p1.getAge().compareTo(p2.getAge());

        List<Person> persons = Arrays.asList( new Person("Eliden",43), new Person("Aida",23), new Person("Lindsay",32));

        persons.stream().sorted(comparatorByAge).map(Person::getAge).forEach(System.out::println);

        System.out.println( "-----------------------------");

//        persons.add(null);
//        persons.add(null);
//        persons.add( new Person("Aida",23) );
//        persons.add(new Person());

        Collections.sort(persons,Person.comparatorByName);

// using flat map
        Arrays.asList(persons,persons).stream().
                flatMap(persons1 -> persons1.stream().map(Person::getName))
                .sorted( (name1,name2) -> name1.compareToIgnoreCase(name2) )
                .forEach(System.out::println);


    }
}

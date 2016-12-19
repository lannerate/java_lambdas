package fp.stream;

import java.util.Comparator;

/**
 * Created by apple on 9/24/16.
 */
public class Person {
    public String name;
    public Integer age;

    public Person(){}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }



    public static Comparator<Person> comparatorByName =
//            Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER);
            Comparator.nullsLast(
                    Comparator.comparing( person -> person.getName(),
                            Comparator.nullsLast( (String name1, String name2) -> name1.compareToIgnoreCase(name2)
                            )
                    ));

}

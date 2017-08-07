package lambda.test.base;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import lambda.demo.base.stream.Article;
import lambda.demo.base.stream.Author;

/**
 * Created by hzhang3 on 2016/1/20.
 */
public class StreamTest {

    @Test
    public void testStream(){
        List<Integer> together = Stream.of( asList(1,2), asList(3,4) )
                                        .flatMap(numbers -> numbers.stream() )
                                        .collect( toList() );
        assertEquals( asList(1,2,3,4), together);

        assertEquals(Integer.valueOf(1), together.stream().min(Comparator.naturalOrder()).get());
    }

    @Test
    public void testIntStream(){
        IntStream intStream = IntStream.of(12, 33, 44, 66, 77, 21, 99);

        assertEquals(99, intStream.max().getAsInt());
    }

    @Test
    public void testOptional(){
        Optional<String> op = Optional.of("b");


        Optional<String> empty = Optional.empty();
        Optional<String> alseEmpty = Optional.ofNullable(null);

        assertEquals("b", op.get());
        assertFalse(empty.isPresent());
        assertEquals("a", empty.orElse("a"));
        assertEquals("C", empty.orElseGet(() -> "C"));

    }

    @Test
    public void testSameOrder(){
        Set<Integer> numbers = new HashSet<>(asList(4,3,2,1));

        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
//        assertEquals( asList(4,3,2,1), sameOrder);

        sameOrder = numbers.stream().sorted().collect(toList());
        assertEquals( asList(1,2,3,4), sameOrder );
    }

    @Test
    public void testOrdering(){
        List<Integer> numbers = asList(1,2,3,4);

        List<Integer> stillOrdered = numbers.stream().map( x -> x +1 ).collect(Collectors.toList());

        assertEquals( asList(2,3,4,5), stillOrdered) ;

        Set<Integer> unorderd = new HashSet<>(numbers);
        List<Integer> stillUnorderd = unorderd.stream().map( x -> x+1).collect(toList());
        assertThat(stillUnorderd, CoreMatchers.hasItem(2));

    }

    @Test
    public void testGrouping(){
        List<Article> articles = asList(
                new Article("java lambdas", new Author(false,"Jack"), true),
                new Article("C sharp Generic", new Author(true,"Mark"), true),
                new Article("Scala implicate", new Author(false,"Tony"), true),
                new Article("Lisp function", new Author(false,"Richart"), true));

        Map<Boolean, List<Article>> result = articles.stream().collect( groupingBy( article ->  article.getAuthor().isMale() ));

        List<Author> authors = articles.stream().map( article ->  article.getAuthor() ).collect( toList() );

        assertEquals(1, result.get(Boolean.TRUE).size() );
        assertEquals("Jack", authors.get(0).getName() );
    }

}

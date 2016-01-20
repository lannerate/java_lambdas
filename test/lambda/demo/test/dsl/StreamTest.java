package lambda.demo.test.dsl;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by hzhang3 on 2016/1/20.
 */
public class StreamTest {

    @Test
    public void testStream(){
        List<Integer> together = Stream.of( Arrays.asList(1,2), Arrays.asList(3,4) )
                                        .flatMap(numbers -> numbers.stream() )
                                        .collect( toList() );
        assertEquals( Arrays.asList(1,2,3,4), together);

        assertEquals(Integer.valueOf(2), together.stream().min(Comparator.naturalOrder()).get());
    }

    @Test
    public void should_filter_collection(){
        List
    }




}

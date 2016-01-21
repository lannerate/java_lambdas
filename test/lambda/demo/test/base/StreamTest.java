package lambda.demo.test.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
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

        assertEquals(Integer.valueOf(1), together.stream().min(Comparator.naturalOrder()).get());
    }

    @Test
    public void testIntStream(){
        IntStream intStream = IntStream.of(12, 33, 44, 66, 77, 21, 99);

        assertEquals(99, intStream.max().getAsInt());
    }
   
   @Test
   public void testPredicate(){

   }
}

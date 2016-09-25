package fp.buildinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 9/25/16.
 */
public class StreamsTest {

    @Test
    public void testStream(){

        List<String> stringList = Arrays.asList("dd2","aa2","ff2","cc2","ee2","bb2");

        stringList.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);

        stringList.stream().sorted().forEach(System.out::println);

        stringList.stream().map(String::toUpperCase).sorted((a,b) -> a.compareTo(b)).forEach(System.out::println);

        stringList.stream().sorted().reduce( (a,b) -> a + "##" + b).ifPresent(System.out::print);

        assertTrue(stringList.stream().anyMatch(s -> s.startsWith("a")));

        assertFalse(stringList.stream().allMatch(s -> s.startsWith("a")));

        assertTrue(stringList.stream().noneMatch(s -> s.startsWith("zz")));


    }

     @Test
    public void testSequentialSort(){
        List<String> values = generateUUIDList();

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);

        System.out.println(String.format("Sequential sort took: %d ms", millis));
    }

    @Test
    public void testParallelSort(){
        List<String> values = generateUUIDList();

        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);

        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    private List<String> generateUUIDList() {
        final int MAX = 1000000;
        List<String> values = new ArrayList<>(MAX);

        for (int i = 0; i< MAX; i++){
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        return values;
    }
}

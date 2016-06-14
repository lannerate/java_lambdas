package lambda.demo.test.base;

import lambda.demo.base.stream.BatchStream;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created by hzhang3 on 2016/6/13.
 */
public class BatchStreamTest {

    @Test
    public void testBatchStream(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);

        assertTrue( BatchStream.batch(numbers, 4).findFirst().get().contains(3) );
    }
}

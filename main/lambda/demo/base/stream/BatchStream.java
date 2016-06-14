package lambda.demo.base.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by hzhang3 on 2016/6/13.
 */
public class BatchStream {

    public static <T> Stream<List<T>> batch(List<T> source, int step){
        if( step < 1 ) throw new RuntimeException("Cant divided by Zero");

        int size = source.size();
        if( size ==0 ) return Stream.empty();

        int total = (source.size() -1) / step;

        return IntStream.range(0, total +1).mapToObj( unit -> source.subList(unit * step, total == unit ? size : (unit + 1)*step ));

    }
}

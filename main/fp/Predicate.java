package fp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 12/19/16.
 */

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}


final class Filter{

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t: list){
            if (p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

}



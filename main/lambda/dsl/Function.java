package lambda.dsl;

/**
 * Created by apple on 1/19/16.
 */
@FunctionalInterface
public interface Function<T,R> {
    R apple(T t);
}

package lambda.demo.dsl;

import java.util.Objects;


public interface Predicate<E> {
  boolean test(E e);
  
  default Predicate<E> and(Predicate<? super E> other){
    Objects.requireNonNull( other );
    return e -> test( e ) && other.test( e );
  }
  
  default Predicate<E> or(Predicate<? super E> other){
    Objects.requireNonNull( other );
    return e -> test( e ) || other.test( e );
  }
  
}

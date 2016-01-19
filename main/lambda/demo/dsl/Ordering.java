package lambda.demo.dsl;

import java.util.Comparator;


public final class Ordering {

  public static <T extends Comparable<? super T> > Comparator<T> natural(){
    return (t1, t2) -> t1.compareTo(t2);
  }
}

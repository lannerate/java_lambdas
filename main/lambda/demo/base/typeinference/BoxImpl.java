package lambda.demo.base.typeinference;


public class BoxImpl<T> implements Box<T> {

  public static <V> Box<V> make(){
    return new BoxImpl<V>();
  }

  @Override
  public T get() {
    return ( (T) make() );
  }

  @Override
  public void put( T element ) {

  }

}

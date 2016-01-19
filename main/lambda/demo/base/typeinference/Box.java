package lambda.demo.base.typeinference;


public interface Box<T> {
  
  public T get();
  
  public void put(T element);
  
}

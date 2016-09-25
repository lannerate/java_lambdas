package lambda.dsl;




public interface Matcher<T> {
  
  boolean matches(T actual);

}

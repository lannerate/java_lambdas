package lambda.demo.dsl;




public interface Matcher<T> {
  
  boolean matches(T actual);

}

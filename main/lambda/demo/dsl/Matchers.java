package lambda.demo.dsl;


public final class Matchers {
  
  public Matchers() {
  }
  
  public static <T> Matcher<T> eq(T expected){
    return actual -> expected.equals(actual);
  }
  
  public static <T> Matcher<T> neq(T expected){
    return actual -> !expected.equals( actual );
  }
  
  public static <T extends Comparable<? super T>> Matcher<T> gt(T expected){
    return actual -> compare( actual, expected ) > 0 ;
  }
  
  public static <T extends Comparable<? super T>> Matcher<T> lt(T expected){
    return actual -> compare( actual, expected ) < 0;
  }
  
  public static <T extends Comparable<? super T>> int compare(T actual, T expected) {
    return Ordering.<T>natural().compare( actual, expected );
  }
  
  public static Matcher<String> contains(String subStr){
    return str -> str.contains( subStr );
  }

  public static Matcher<String> start(String subStr){
    return str -> str.startsWith( subStr );
  }

  public static Matcher<String> ignoringCase(Function<String, Matcher<String>> m, String subStr){
    return str -> m.apple( subStr.toLowerCase() ).matches( str.toLowerCase() );
  }
  
}

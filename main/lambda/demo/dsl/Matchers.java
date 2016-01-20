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

  public static <T> Matcher<T> not(Matcher<T> matcher){
    return actual -> ! matcher.matches( actual);
  }

  public static <T> Matcher<T> not(T expected){
    return not( eq(expected) );
  }

  @SafeVarargs
  public static <T> Matcher<T> any(Matcher<? super T>... matchers){
    return combine(true,matchers);
  }

  @SafeVarargs
  public static <T> Matcher<T> all(Matcher<? super T>... matchers){
    return combine(false, matchers);
  }

  @SafeVarargs
  private static <T> Matcher<T> combine(boolean shortcut, Matcher<? super T>... matchers){
    return actual -> {
      for (Matcher<? super T> m: matchers)
        if (m.matches(actual) == shortcut)
          return shortcut;

      return !shortcut;
    };
  }

  public static <T> Matcher<T> always(boolean bool){
    return e -> bool;
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

  private static Matcher<String> ignoringCase(Function<String, Matcher<String>> m, String subStr){
    return str -> m.apple( subStr.toLowerCase() ).matches( str.toLowerCase() );
  }

  public static Matcher<String> startIgnoringCase(String subStr){
    return ignoringCase(Matchers::start, subStr);
  }


}

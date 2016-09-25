package lambda.dsl;


public final class HumanPredicates {
  private HumanPredicates(){
    
  }
  
  public static Predicate<Human> age(int age){
    return s -> s.getAge() == age;
  }
  
  public static Predicate<Human> age(Matcher<Integer> m){
    return s -> m.matches( s.getAge() );
  }
  
  public static Predicate<Human> name(String name){
    return s -> s.getName().equals( name );
  }
  
  public static Predicate<Human> name(Matcher<String> m){
    return s -> m.matches( s.getName() );
  }
  
  
}

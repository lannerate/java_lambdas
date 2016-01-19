package lambda.demo.dsl.v2;

import lambda.demo.dsl.Student;


public class NamePredicate implements StudentPredicate {

  private String name;
  
  
  public NamePredicate(String name) {
    this.name = name;
  }
  
  @Override
  public boolean test( Student s ) {
    return s.getName() .equals( name );
  }

}

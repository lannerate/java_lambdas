package lambda.dsl.v2;

import lambda.dsl.Student;


public class AgePredicate implements StudentPredicate {

  private int age;
  
  public AgePredicate(int age) {
    this.age = age;
  }
  
  @Override
  public boolean test( Student s ) {
    return s.getAge() == age;
  }

}

package lambda.demo.dsl.v2;

import lambda.demo.dsl.Student;


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

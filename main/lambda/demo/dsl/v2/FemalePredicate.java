package lambda.demo.dsl.v2;

import lambda.demo.dsl.Teacher;


public class FemalePredicate implements TeacherPredicate {

  @Override
  public boolean test( Teacher t ) {
    return t.female();
  }

}

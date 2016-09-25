package lambda.dsl.v2;

import lambda.dsl.Teacher;


public class FemalePredicate implements TeacherPredicate {

  @Override
  public boolean test( Teacher t ) {
    return t.female();
  }

}

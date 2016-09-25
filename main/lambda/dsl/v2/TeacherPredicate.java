package lambda.dsl.v2;


import lambda.dsl.Teacher;

@FunctionalInterface
public interface TeacherPredicate {
  boolean test(Teacher t);
}

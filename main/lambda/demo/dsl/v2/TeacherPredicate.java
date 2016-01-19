package lambda.demo.dsl.v2;


import lambda.demo.dsl.Teacher;

@FunctionalInterface
public interface TeacherPredicate {
  boolean test(Teacher t);
}

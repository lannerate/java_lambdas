package lambda.dsl.v2;

import lambda.dsl.Student;

@FunctionalInterface
public interface StudentPredicate {

  boolean test(Student s);
}

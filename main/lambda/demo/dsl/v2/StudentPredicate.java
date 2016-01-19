package lambda.demo.dsl.v2;

import lambda.demo.dsl.Student;

@FunctionalInterface
public interface StudentPredicate {

  boolean test(Student s);
}

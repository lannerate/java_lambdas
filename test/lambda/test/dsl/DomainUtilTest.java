package lambda.test.dsl;

import lambda.dsl.Student;
import lambda.dsl.Teacher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static lambda.dsl.DomainUtil.find;
import static lambda.dsl.HumanPredicates.age;
import static lambda.dsl.HumanPredicates.name;
import static lambda.dsl.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DomainUtilTest {
  
    

   
    @Test
    public void testFind(){
      
      //use the mutable predicate [Age, Name]
//      Student[] studentArray = { new Student( 27, "hui", false), new Student( 23, "jackson", true) };
//      assertThat( find( studentArray, new AgePredicate(26)), notNullValue() );
//      assertThat( find( studentArray, new NamePredicate( "jack" ) ), notNullValue() );
      
      //remove the duplicated construct predicate, to use lambda expression
      Collection<Student> students = new ArrayList<>();
      students.add( new Student( 27, "hui", false) );
      students.add( new Student( 24, "jackson", true) );
      
      assertThat( find( students, s -> s.getAge() == 24 ), notNullValue());
      assertThat( find( students, s -> s.getName().equals( "hui" ) ), notNullValue() );
      
      //using StudentPredicates.*
      assertThat( find( students, name( "hui" ) ), notNullValue() );
      assertThat( find( students, age( 24 ) ), notNullValue() );
      
      //using Matcher<T>
      assertThat( find( students, age( neq( 18 ) ) ), notNullValue() );
      //using the streaming function (FP)
      assertThat( find( students, age( neq( 18 ) ).and( name( "hui" ) ) ), notNullValue() );
      
      //using Optional<T>
      assertThat( find( students, age( gt( 18 ) ) ).isPresent(), is(true) );
      assertThat( find( students, name( contains("hui") ) ).isPresent(), is( true ) );
//    assertThat( find( students, name(ignoringCase(Matchers::start, "hui"))).isPresent(), is(true));

      //composite principle
      assertThat( find(students, name(startIgnoringCase("hui")) ).isPresent(), is(true) );
      //using the simple method not()
      assertThat( find(students, age(not(18))).isPresent(), is(true) );
      //using any(), all()
      assertThat(find(students, name(any(startIgnoringCase("hu")))).isPresent(), is(true));
        assertThat(find(students, name(all(startIgnoringCase("hu")))).isPresent(), is(true));

      assertThat( find(students, age(always(false))).isPresent(), is(true));
    }
    
    @Test
    public void testFindTeacher(){
//      Teacher[] teachers = { new Teacher( true ), new Teacher( false ) };
//      assertThat( find( teachers, new FemalePredicate() ), notNullValue());
      
      List<Teacher> teachers = new ArrayList<>();
      teachers.add( new Teacher( 23, "jackson", true) );
      teachers.add( new Teacher( 27, "Hui", false));
      
      //add new Teacher and Teacher predicate
      assertThat( find( teachers, t -> t.female() ), notNullValue() );
      assertThat( find( teachers, Teacher::female ), notNullValue() );
      
//    Parameterize all the things.
      
    }
}

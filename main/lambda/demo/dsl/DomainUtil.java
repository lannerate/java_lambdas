package lambda.demo.dsl;

import java.lang.System;
import java.util.Optional;

import lambda.demo.dsl.v2.StudentPredicate;

public class DomainUtil {
  
  //v1
  // using for-each expression
  public static Student findByAge(Student[] students){
    for(Student s : students)
      if ( s.getAge() == 18 ) 
        return s;
      
    return null;
  }
  // using for-each expression
  public static Student findByName(Student[] students){
    for(Student s : students)
      if ( s.getName().equals( "Hui" )) 
        return s;
      
    return null;
  }
  
  //v2
  public static Student find(Student[] students, StudentPredicate p){
    for ( Student s : students )
      if( p.test( s ))
        return s;
   
    return null;
  }
  
  //v3
/*  public static Student find( Iterable<Student> students, StudentPredicate p){
    for ( Student s : students )
      if ( p.test( s ) )
          return s;
  
    return null;
  }
  
  public static Teacher find(Iterable<Teacher> teachers, TeacherPredicate p){
    for ( Teacher t : teachers ) {
      if ( p.test( t ) ) {
        return t;
      }
    }
    return null;
  }*/
  
  //type parameter
/*  public static <E> E find(Iterable< ? extends E> c, Predicate<? super E> p){
    for ( E e : c ) {
      if ( p.test( e ) ) {
        return e;
      }
    }
    return null;
  }*/
  
  public static <E> Optional<E> find(Iterable<? extends E> c, Predicate<? super E> p){
    for ( E e : c ) {
      if ( p.test( e ) ) {
        return Optional.of( e );
      }
    }
    return Optional.empty();
  }

}

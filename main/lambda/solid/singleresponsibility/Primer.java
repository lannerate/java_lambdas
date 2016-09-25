package lambda.solid.singleresponsibility;

import java.util.stream.IntStream;



public class Primer {

  public static void main( String[] args ) {
    // TODO Auto-generated method stub
    System.out.print( countPrimes( 100 ) );
  }

  public static long countPrimes(int upTo){
    return IntStream.range( 1, upTo )
        .parallel()
        .filter( x -> isPrime( x ) )
        .count();
  }
  
  public static boolean isPrime(int num){
    return IntStream.range( 2, num )
            .allMatch( x -> ( num % x) != 0   );
  }
}

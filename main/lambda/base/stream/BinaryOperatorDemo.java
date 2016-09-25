package lambda.base.stream;

import java.util.function.BinaryOperator;

/**
 * Created by hzhang3 on 2016/1/21.
 */
public class BinaryOperatorDemo {

    private void overLoadMethod(BinaryOperator<Integer> lambda){
        System.out.println("BinaryOperator");
    }

    private void overLoadMethod(IntegerBiFunction lambda){
        System.out.println("IntegerBiFunction");
    }

}

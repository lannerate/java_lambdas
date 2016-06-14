package lambda.demo.test.patterns.factory;

import lambda.demo.patterns.factory.BeverageFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class FactoryTest {

    @Test
    public void testCreateCoffeeByFactory(){

        assertEquals(1.27, BeverageFactory
                .addSoy(BeverageFactory
                        .addMilk( BeverageFactory
                                .addDarkRoast() ) ).cost(), 0.0);
    }
}

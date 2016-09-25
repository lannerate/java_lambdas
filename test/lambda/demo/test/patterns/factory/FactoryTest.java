package lambda.demo.test.patterns.factory;

import lambda.demo.patterns.factory.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testSimpleMakeFizza(){
        PizzaStore pizzaStore = new NYStylePizzaStore(new NYStylePizzaFactory());
        assertTrue( pizzaStore.order("nystylecheese") instanceof  NYStylePizza );
    }
}

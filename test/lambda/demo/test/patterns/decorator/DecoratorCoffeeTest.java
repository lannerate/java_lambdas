package lambda.demo.test.patterns.decorator;

import lambda.demo.patterns.decorator.Beverage;
import lambda.demo.patterns.decorator.HouseBlendCoffee;
import lambda.demo.patterns.decorator.MilkCondiment;
import lambda.demo.patterns.decorator.SoyCondiment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class DecoratorCoffeeTest {

    @Test
    public void testDecoratorCoffee(){
         Beverage coffee = new HouseBlendCoffee();
         coffee = new MilkCondiment(coffee);
         coffee = new SoyCondiment(coffee);

         System.out.println(coffee.getDescription());

         assertEquals(2.93, coffee.cost(), 0.0);

    }
}

package lambda.demo.test.patterns.strategy;

import lambda.demo.patterns.strategy.Duck;
import lambda.demo.patterns.strategy.MallardDuck;
import lambda.demo.patterns.strategy.RedHeadDuck;
import lambda.demo.patterns.strategy.WoodenDuck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by zh on 16-6-12.
 */
public class MiniDuckTest {

    @Test
    public void when_is_mallard_duck_then_flywithwing_and_quack(){
        Duck duck = new MallardDuck();

        assertEquals("fly with wing", duck.performFly() );
        assertEquals("quack", duck.performQuack());
    }

    @Test
    public void when_is_redhead_duck_then_flyNoWay(){
        Duck duck = new RedHeadDuck();
        assertEquals("fly no way", duck.performFly());
        assertEquals("quack", duck.performQuack());
    }

    @Test
    public void when_is_woodenduck_when_flyNoWay_and_muteQuack(){
        Duck duck = new WoodenDuck();

        assertEquals("fly no way", duck.performFly());
        assertEquals("mute quack", duck.performQuack());
    }
}

package lambda.demo.patterns.strategy;

import lambda.demo.patterns.strategy.Duck;

/**
 * Created by zh on 16-6-12.
 */
public class WoodenDuck extends Duck {
    public WoodenDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }
}

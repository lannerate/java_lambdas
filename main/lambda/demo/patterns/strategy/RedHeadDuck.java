package lambda.demo.patterns.strategy;

/**
 * Created by zh on 16-6-12.
 */
public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
}

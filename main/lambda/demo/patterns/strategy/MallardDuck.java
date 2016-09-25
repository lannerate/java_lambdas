package lambda.demo.patterns.strategy;

/**
 * Created by zh on 16-6-12.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
}

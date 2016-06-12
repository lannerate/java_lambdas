package lambda.demo.patterns.strategy;

/**
 * Created by zh on 16-6-12.
 */
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {}

    public String performFly(){
        return flyBehavior.fly();
    };

    public String performQuack(){
        return quackBehavior.quack();
    };
}

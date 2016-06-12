package lambda.demo.patterns.strategy;

import lambda.demo.patterns.strategy.FlyBehavior;

/**
 * Created by zh on 16-6-12.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public String fly() {
        return "fly no way";
    }
}

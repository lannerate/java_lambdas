package lambda.demo.patterns.decorator;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class HouseBlendCoffee implements Beverage {
    @Override
    public String getDescription() {
        return "Home Hold Coffee";
    }

    @Override
    public double cost() {
        return 2.56;
    }
}

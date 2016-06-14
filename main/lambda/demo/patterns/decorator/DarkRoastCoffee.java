package lambda.demo.patterns.decorator;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class DarkRoastCoffee implements Beverage{
    @Override
    public String getDescription() {
        return "Dark Roast";
    }

    @Override
    public double cost() {
        return 0.9;
    }
}

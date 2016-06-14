package lambda.demo.patterns.decorator;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class SoyCondiment extends CondimentDecorator{

    public SoyCondiment(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Poy Condiment";
    }

    @Override
    public double cost() {
        return 0.16 + getBeverage().cost();
    }
}

package lambda.demo.patterns.decorator;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class MilkCondiment extends CondimentDecorator{

    public MilkCondiment(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Milk Condiment";
    }

    @Override
    public double cost() {
        return 0.21 + getBeverage().cost();
    }
}

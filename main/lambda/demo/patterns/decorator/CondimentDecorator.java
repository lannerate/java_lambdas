package lambda.demo.patterns.decorator;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public abstract class CondimentDecorator implements Beverage {
    private Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    protected Beverage getBeverage(){
        return beverage;
    }
}

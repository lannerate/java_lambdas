package lambda.demo.patterns.factory;

/**
 * Created by zh on 16-6-19.
 */
public class NYStylePizzaStore extends PizzaStore {

    public NYStylePizzaStore(NYStylePizzaFactory nyStylePizzaFactory) {
        super(nyStylePizzaFactory);
        factory = nyStylePizzaFactory;
    }

    @Override
    protected Pizza createPizza(String type) {
        return factory.makePizza(type);
    }
}

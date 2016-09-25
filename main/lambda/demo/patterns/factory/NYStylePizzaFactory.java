package lambda.demo.patterns.factory;

/**
 * Created by zh on 16-6-19.
 */
public class NYStylePizzaFactory extends PizzaFactory {
    @Override
    public Pizza makePizza(String type) {
        Pizza pizza = super.makePizza(type);
        if(type.equals("nystylecheese")){
            pizza = new NYStylePizza();
        }
        return pizza;
    }
}

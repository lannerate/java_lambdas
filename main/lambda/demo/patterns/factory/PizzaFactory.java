package lambda.demo.patterns.factory;

/**
 * Created by zh on 16-6-18.
 */
public abstract class PizzaFactory {

    public  Pizza makePizza(String type) {
        Pizza pizza =null;
        if (type.equals("cheese")){
            pizza = new CheesePizza();
        } else if (type.equals("clam")){
            pizza =  new ClamPizza();
        } else if (type.equals("veggie")){
            pizza =  new VeggiePizza();
        }
        return pizza;
    }
}
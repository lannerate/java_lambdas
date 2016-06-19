package lambda.demo.patterns.factory;

/**
 * Created by zh on 16-6-19.
 */
public class NYStylePizza extends Pizza {
    public NYStylePizza(){
        name = "NY Style Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza into square slices");
    }
}

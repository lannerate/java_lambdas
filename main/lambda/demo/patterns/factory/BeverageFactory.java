package lambda.demo.patterns.factory;

import lambda.demo.patterns.decorator.*;

/**
 * Created by hzhang3 on 2016/6/14.
 */
public class BeverageFactory {

    public static Beverage addHouseBlend() {
        return new HouseBlendCoffee();
    }

    public static Beverage addDarkRoast(){
        return new DarkRoastCoffee();
    }

    public static Beverage addMilk(Beverage beverage){
        return new MilkCondiment( beverage );
    }

    public static Beverage addSoy(Beverage beverage){
        return new SoyCondiment(beverage);
    }
}

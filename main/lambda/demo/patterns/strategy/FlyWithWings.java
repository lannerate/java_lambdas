package lambda.demo.patterns.strategy;

/**
 * Created by zh on 16-6-12.
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public String fly() {
        return "fly with wing";
    }
}

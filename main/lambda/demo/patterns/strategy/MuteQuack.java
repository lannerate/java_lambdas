package lambda.demo.patterns.strategy;

/**
 * Created by zh on 16-6-12.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public String quack() {
        return "mute quack";
    }
}

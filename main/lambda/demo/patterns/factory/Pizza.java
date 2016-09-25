package lambda.demo.patterns.factory;

/**
 * Created by zh on 16-6-18.
 */
public abstract class Pizza {

    protected String name;

    protected String dough;

    protected String sauce;

    public void prepare(){
        System.out.println("preparing "+ name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
    }

    public void bake() {
        System.out.println("bake pizza");
    }

    public void cut() {
        System.out.println("cut pizza");
    }

    public void box() {
        System.out.println("box pizza");
    }
}

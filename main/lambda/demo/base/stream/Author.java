package lambda.demo.base.stream;

public class Author {
    private String name;
    private boolean male;

    public Author(boolean male, String name) {
        this.male = male;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return male;
    }
}

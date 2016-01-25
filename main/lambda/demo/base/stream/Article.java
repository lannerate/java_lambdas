package lambda.demo.base.stream;

/**
 * Created by hzhang3 on 2016/1/25.
 */
public class Article {
    private String name;
    private Author author;
    private boolean isPublic;

    public Article(String name, Author author, boolean isPublic) {
        this.name = name;
        this.author = author;
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isPublic() {
        return isPublic;
    }

}


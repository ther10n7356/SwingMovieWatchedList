package app.movieList.api.model;

public class ItemName {

    private final String name;

    public ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ItemName{" +
                "name='" + name + '\'' +
                '}';
    }
}

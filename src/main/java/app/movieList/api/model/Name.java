package app.movieList.api.model;

public class Name {
    private final String name;
    private final String language;
    private final String type;

    public Name(String name, String language, String type) {
        this.name = name;
        this.language = language;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

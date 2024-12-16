package app.movieList.model;

public class MovieType {
    private final int typeId;
    private final String typeName;

    public MovieType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }
}

package app.movieList.api.model;

public class YearRange {

    private final int start;
    private final int end;

    public YearRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "YearRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

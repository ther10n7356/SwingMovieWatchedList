package app.movieList.api.model;

import java.util.List;

public class SearchDocs {
    private final List<MovieDoc> docs;
    private final int total;
    private final int limit;
    private final int page;
    private final int pages;

    public SearchDocs(List<MovieDoc> docs, int total, int limit, int page, int pages) {
        this.docs = docs;
        this.total = total;
        this.limit = limit;
        this.page = page;
        this.pages = pages;
    }

    public List<MovieDoc> getDocs() {
        return docs;
    }

    public int getTotal() {
        return total;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "SearchDocs{" +
                "docs=" + docs +
                ", total=" + total +
                ", limit=" + limit +
                ", page=" + page +
                ", pages=" + pages +
                '}';
    }
}

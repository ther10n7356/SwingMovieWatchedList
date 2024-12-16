package app.movieList.api.model;

import java.util.List;

public class MovieDoc {
    private final int id;
    private final String name;
    private final String alternativeName;
    private final String enName;
    private final String type;
    private final int year;
    private final String description;
    private final String shortDescription;
    private final int movieLength;
    private final List<Name> names;
    private final ExternalId externalId;
    private final Logo logo;
    private final Poster poster;
    private final BackDrop backdrop;
    private final Rating rating;
    private final Votes votes;
    private final List<ItemName> genres;
    private final List<ItemName> countries;
    private final List<YearRange> releaseYears;
    private final boolean isSeries;
    private final boolean ticketOnSale;
    private final int totalSeriesLength;
    private final int seriesLength;
    private final String ratingMpaa;
    private final int ageRating;
    private final int top10;
    private final int top250;
    private final int typeNumber;
    private final String status;

    public MovieDoc(int id,
                    String name,
                    String alternativeName,
                    String enName,
                    String type,
                    int year,
                    String description,
                    String shortDescription,
                    int movieLength,
                    List<Name> names,
                    ExternalId externalId,
                    Logo logo, Poster poster,
                    BackDrop backdrop,
                    Rating rating,
                    Votes votes,
                    List<ItemName> genres,
                    List<ItemName> countries,
                    List<YearRange> releaseYears,
                    boolean isSeries,
                    boolean ticketOnSale,
                    int totalSeriesLength,
                    int seriesLength,
                    String ratingMpaa,
                    int ageRating,
                    int top10,
                    int top250,
                    int typeNumber,
                    String status) {
        this.id = id;
        this.name = name;
        this.alternativeName = alternativeName;
        this.enName = enName;
        this.type = type;
        this.year = year;
        this.description = description;
        this.shortDescription = shortDescription;
        this.movieLength = movieLength;
        this.names = names;
        this.externalId = externalId;
        this.logo = logo;
        this.poster = poster;
        this.backdrop = backdrop;
        this.rating = rating;
        this.votes = votes;
        this.genres = genres;
        this.countries = countries;
        this.releaseYears = releaseYears;
        this.isSeries = isSeries;
        this.ticketOnSale = ticketOnSale;
        this.totalSeriesLength = totalSeriesLength;
        this.seriesLength = seriesLength;
        this.ratingMpaa = ratingMpaa;
        this.ageRating = ageRating;
        this.top10 = top10;
        this.top250 = top250;
        this.typeNumber = typeNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public String getEnName() {
        return enName;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public List<Name> getNames() {
        return names;
    }

    public ExternalId getExternalId() {
        return externalId;
    }

    public Logo getLogo() {
        return logo;
    }

    public Poster getPoster() {
        return poster;
    }

    public BackDrop getBackdrop() {
        return backdrop;
    }

    public Rating getRating() {
        return rating;
    }

    public Votes getVotes() {
        return votes;
    }

    public List<ItemName> getGenres() {
        return genres;
    }

    public List<ItemName> getCountries() {
        return countries;
    }

    public List<YearRange> getReleaseYears() {
        return releaseYears;
    }

    public boolean isSeries() {
        return isSeries;
    }

    public boolean isTicketOnSale() {
        return ticketOnSale;
    }

    public int getTotalSeriesLength() {
        return totalSeriesLength;
    }

    public int getSeriesLength() {
        return seriesLength;
    }

    public String getRatingMpaa() {
        return ratingMpaa;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public int getTop10() {
        return top10;
    }

    public int getTop250() {
        return top250;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "MovieDoc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alternativeName='" + alternativeName + '\'' +
                ", enName='" + enName + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", movieLength=" + movieLength +
                ", names=" + names +
                ", externalId=" + externalId +
                ", logo=" + logo +
                ", poster=" + poster +
                ", backdrop=" + backdrop +
                ", rating=" + rating +
                ", votes=" + votes +
                ", genres=" + genres +
                ", countries=" + countries +
                ", releaseYears=" + releaseYears +
                ", isSeries=" + isSeries +
                ", ticketOnSale=" + ticketOnSale +
                ", totalSeriesLength=" + totalSeriesLength +
                ", seriesLength=" + seriesLength +
                ", ratingMpaa='" + ratingMpaa + '\'' +
                ", ageRating=" + ageRating +
                ", top10=" + top10 +
                ", top250=" + top250 +
                ", typeNumber=" + typeNumber +
                ", status='" + status + '\'' +
                '}';
    }
}

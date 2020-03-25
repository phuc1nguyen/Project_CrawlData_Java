package core.phim;

public class FilmModelBase {
    private String name;
    private String avatar;
    private String imdScore;
    private String directors;
    private String country;
    private String publicYear;
    private String publicDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImdScore() {
        return imdScore;
    }

    public void setImdScore(String imdScore) {
        this.imdScore = imdScore;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(String publicYear) {
        this.publicYear = publicYear;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }
}

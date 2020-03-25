package core.phim;

public abstract class FilmParser<T> {
    public abstract T parserDetail(String url);
    public abstract String[] parserListLink(String url);
}

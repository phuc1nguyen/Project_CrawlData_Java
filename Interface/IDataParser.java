package Interface;

public interface IDataParser<T> {
    public T DataDetail(String url);
    public String[] parserListLink(String url);
}

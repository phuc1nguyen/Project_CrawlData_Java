package core.phim.phimmoi;

import core.phim.FilmParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PhimMoiParser extends FilmParser<PhimMoiModel> {
    @Override
    public PhimMoiModel parserDetail(String url) {
        Document html = getHtmlContent(url);

        PhimMoiModel result = new PhimMoiModel();

        String avatar = html.selectFirst("div.movie-l-img").selectFirst("img").attr("src");
        String name = html.selectFirst("a.title-1").ownText();
        String imdb = "";
        String director = "";
        String country = "";
        String publicYear = "";
        String publicDate = "";
        String voteCount = "";


        //Lay cac thong tin cua phim
        Element pros = html.selectFirst("dl.movie-dl");

        //Lay het cac phan tu con cua the dl.movie-dl
        Elements child = pros.children();
        for(int i=0; i<child.size(); i ++){
            if(child.get(i).ownText().equals("Điểm IMDb:")){
                imdb = child.get(i+1).ownText();
            }
            if(child.get(i).ownText().equals("Số người đánh giá:")){
                voteCount = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Đạo diễn:")){
                director = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Quốc gia:")){
                country = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Năm:")){
                publicYear = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Ngày ra rạp:")){
                publicDate = child.get(i+1).text();
            }
        }

        result.setName(name);
        result.setAvatar(avatar);
        result.setImdScore(imdb);
        result.setVoteCount(voteCount);
        result.setDirectors(director);
        result.setCountry(country);
        result.setPublicDate(publicDate);
        result.setPublicYear(publicYear);
        return result;
    }

    @Override
    public String [] parserListLink(String url) {

        //Parser link chua danh sach cac phim de lay duoc link chi tiet moi phim
        Document html = getHtmlContent(url);
        Elements elements = html.select("li.movie-item");

        String[] linkArray = new String[elements.size()];

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkFilm = element.selectFirst("a").attr("href");
            linkArray[i] = "http://www.phimmoi.net/" + linkFilm;
        }
        return linkArray;
    }

    private Document getHtmlContent(String url){
        Document pageHtml;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .followRedirects(true)
                    .timeout(30000)
                    .execute();
            pageHtml = response.parse();
            return pageHtml;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

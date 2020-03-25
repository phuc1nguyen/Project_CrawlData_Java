package services;

import Interface.IDataParser;
import Model.CompanyModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetCompanyService implements IDataParser {

    @Override
    public CompanyModel DataDetail(String url) {

        Document html = getHtmlContent(url);

        CompanyModel result = new CompanyModel();

        CompanyModel cpmodel = new CompanyModel();

        String ten = html.selectFirst("h1.title").ownText();

        String Rate = html.getElementsByClass("company-ratings__star-point").text();

        String city = html.getElementsByClass("country").select("span.name").text();

        String jobs = html.getElementsByClass("job").size()+"";

        String urlCompany = url ;

        result.setTen(ten);
        result.setRate(Rate);
        result.setCity(city);
        result.setJobs(jobs);
        result.setUrlCompany(urlCompany);

        return result;
    }

    @Override
    public String[] parserListLink(String url) {
        //Parser link chua danh sach cac company
        Document html = getHtmlContent(url);
        Elements elements = html.select(".featured-company");

        String[] linkArray = new String[elements.size()];

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkJob = element.selectFirst("a").attr("href");
            linkArray[i] = "https://itviec.com" + linkJob;
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

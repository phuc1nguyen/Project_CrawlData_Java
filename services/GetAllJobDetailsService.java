package services;

import Interface.IDataParser;
import Model.JobModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAllJobDetailsService implements IDataParser<JobModel> {

    @Override
    public JobModel DataDetail(String url) {
        Document html = getHtmlContent(url);

        JobModel result = new JobModel();

        String tenJob = html.selectFirst("h1.job_title").text();

        String address = html.getElementsByClass("address__full-address").select("span").text();

        Elements viTris = html.getElementsByClass("big ilabel mkt-track").select("span");

        String viTri = "";
        for (Element pr: viTris){
            String text = pr.text() + "\t";
            viTri += text;
        }

        Elements descriptions = html.select(".top-3-reasons").select("li");
        String descrtiption = "";
        for (Element pr: descriptions){
            String text = "\t"+pr.text() + "\n";
            descrtiption += text;
        }

        String TimeUpdated = html.select(".distance-time-job-posted").text();

        String tenCty = html.getElementsByClass("name").select("a").text();


        result.setTenJob(tenJob);
        result.setAddress(address);
        result.setDescription(descrtiption);
        result.setTenCty(tenCty);
        result.setViTri(viTri);
        result.setTimeUpdated(TimeUpdated);

        return result;
    }

    @Override
    public String[] parserListLink(String url) {
        //Parser link chua danh sach cac job de lay duoc link chi tiet moi job
        Document html = getHtmlContent(url);
        Elements elements = html.select("h2.title");

        String[] linkArray = new String[elements.size()];

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkJob = element.selectFirst("a").attr("href");
            linkArray[i] = "https://itviec.com" + linkJob;
        }
        return linkArray;
    }

    public Document getHtmlContent(String url){
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

import Model.CompanyModel;
import Model.JobModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.GetAllJobDetailsService;
import services.GetCompanyService;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        MainApplication mainApp = new MainApplication();
        while (true){
            mainApp.menu();
        }
    }

    private void menu(){
        System.out.println("\n\n");
        System.out.println("-------------------------- CRAWLDATA FROM WEB ITVIEC.COM --------------------------");
        System.out.println("1. Hiển thị tất cả công việc.");
        System.out.println("2. Tìm kiếm công việc theo công ty");
        System.out.println("3. Tìm kiếm công việc theo mức lương");
        System.out.println("4. Tìm kiếm công việc theo địa điểm");
        System.out.println("5. Tìm kiếm công việc theo kĩ năng");
        System.out.println("6. Thoát.");
        System.out.println("Bạn chọn: ");
        int chon = new Scanner(System.in).nextInt();

        switch (chon){
            case 1:
                getAllJob();
                break;
            case 2:
                getAllCompany();
                getAllJobFromCompany();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("GoodBye!!!");
                System.exit(0);
                break;
        }
    }


    // Lấy ra danh sách tất cả công việc trên web itviec
    private void getAllJob(){
        String url = "https://itviec.com/it-jobs/";
        GetAllJobDetailsService jobParser = new GetAllJobDetailsService();
        String[] linkArray = jobParser.parserListLink(url);
        for(String link : linkArray){
            JobModel job = jobParser.DataDetail(link);
            System.out.println(job.toString());
        }
    }

    // Lấy ra danh sách tất cả 2công ty trên web itviec
    private void getAllCompany(){
        String url = "https://itviec.com/companies/search-companies/";
        GetCompanyService companyser = new GetCompanyService();
        String[] linkArray = companyser.parserListLink(url);

        int dem = 1;
        for(String link : linkArray){
            CompanyModel cp = companyser.DataDetail(link);
            System.out.println(cp.toString(dem));
            dem++;
        }
    }

    private void getAllJobFromCompany(){
        System.out.println("\n\n");
        System.out.println("Nhap ten cong ty ma ban muon tim: ");
        String tenCompany = new Scanner(System.in).nextLine();
        tenCompany = tenCompany.trim().replace(" ","-").toLowerCase();

        String url = "https://itviec.com/companies/" + tenCompany;

        GetAllJobDetailsService ser = new GetAllJobDetailsService();

        Document html = ser.getHtmlContent(url);
        Elements elements = html.select("h4.title");

        String[] linkArray = new String[elements.size()];

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkJob = element.selectFirst("a").attr("href");
            linkArray[i] = "https://itviec.com" + linkJob;
        }

        for(String link : linkArray){
            JobModel job = ser.DataDetail(link);
            System.out.println(job.toString());
        }
    }
}

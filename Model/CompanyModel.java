package Model;

public class CompanyModel {
    private String ten;
    private String Rate;
    private String city;
    private String jobs;
    private String maCp;

    private String urlCompany;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getUrlCompany() {
        return urlCompany;
    }

    public void setUrlCompany(String urlCompany) {
        this.urlCompany = urlCompany;
    }

    public String getMaCp() {
        return maCp;
    }

    public void setMaCp(int dem) {
        this.maCp = "CP" + dem;
    }

    public String toString(int dem) {

        this.setMaCp(dem);

        return "\nCompany "+dem +"{\n" +
                "- Ma Congty = " + maCp + '\n' +
                "- ten = " + ten + '\n' +
                "- Rate = " + Rate + '\n' +
                "- city = " + city + '\n' +
                "- jobs = " + jobs + '\n' +
                "- urlCompany = " + urlCompany + '\n' +
                '}';
    }

    public String toString() {

        return "\nCompany "+maCp +"{\n" +
                "- Ma Congty = " + maCp + '\n' +
                "- ten = " + ten + '\n' +
                "- Rate = " + Rate + '\n' +
                "- city = " + city + '\n' +
                "- jobs = " + jobs + '\n' +
                "- urlCompany = " + urlCompany + '\n' +
                '}';
    }
}

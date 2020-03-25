package Model;

public class JobModel {
    private String tenJob;
    private String address;
    private String viTri;
    private String description;
    private String TimeUpdated;
    private String tenCty;

    public String getTenCty() {
        return tenCty;
    }

    public void setTenCty(String tenCty) {
        this.tenCty = tenCty;
    }

    public String getTenJob() {
        return tenJob;
    }

    public void setTenJob(String tenJob) {
        this.tenJob = tenJob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeUpdated() {
        return TimeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        TimeUpdated = timeUpdated;
    }

    @Override
    public String toString() {
        return "JOB{" +
                "\n- TENJOB = " + tenJob + '\n' +
                "- TEN CONG TY = " + tenCty + '\n' +
                "- ADDRESS = " + address + '\n' +
                "- VI TRI = " + viTri + '\n' +
                "- DESCRIPTION = " + description + '\n' +
                "- TIMEUPDATED = " + TimeUpdated + '\n' +
                '}';
    }
}

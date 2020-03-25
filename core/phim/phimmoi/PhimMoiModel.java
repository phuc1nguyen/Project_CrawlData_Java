package core.phim.phimmoi;


import core.phim.FilmModelBase;

public class PhimMoiModel extends FilmModelBase {
    private String voteCount;

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        String phim = "Name: " + this.getName() + "\n"
                + "Avatar: " + this.getAvatar() + "\n"
                + "IMDb: " + this.getImdScore() + "\n"
                + "Directors: " + this.getDirectors() + "\n"
                + "Country: " + this.getCountry() + "\n"
                + "PublicDate: " + this.getPublicDate() + "\n"
                + "Vote: " + this.getVoteCount() + "\n";
        return phim;

    }
}

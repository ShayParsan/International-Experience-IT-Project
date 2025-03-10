package be.ucll.group5.backend.Reward;

public class Rank {
    public enum RankType {
        BRONZE, SILVER, GOLD, PLATINUM
    }

    private RankType rank;

    public Rank(RankType rank) {
        this.rank = rank;
    }

    public RankType getRank() {
        return rank;
    }

    public void setRank(RankType rank) {
        this.rank = rank;
    }
}

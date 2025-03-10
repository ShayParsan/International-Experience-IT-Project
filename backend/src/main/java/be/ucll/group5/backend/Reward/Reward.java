package backEnd.src.main.Reward;

import java.time.LocalDate;

public class Reward {
    private String name;
    private String description;
    private LocalDate date;
    private Rank rank;

    public Reward(String name, String description, LocalDate date, Rank rank) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date != null) {
            this.date = date;
        }
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}

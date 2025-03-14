package be.ucll.group5.backend.Reward;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RewardRepository {
    private List<Reward> rewards = new ArrayList<Reward>();

    public RewardRepository() {
        rewards.add(new Reward("Gold Medal", "Awarded for first place", LocalDate.now(), Rank.GOLD));
        rewards.add(new Reward("Silver Medal", "Awarded for second place", LocalDate.now(), Rank.SILVER));
        rewards.add(new Reward("Bronze Medal", "Awarded for third place", LocalDate.now(), Rank.BRONZE));
        rewards.add(new Reward("Platinum Medal", "Awarded for idkman", LocalDate.now(), Rank.PLATINUM));
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public void removeReward(Reward reward) {
        rewards.remove(reward);
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}

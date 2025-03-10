package backEnd.src.main.Reward;

import java.util.ArrayList;
import java.util.List;

public class RewardRepository {
    private List<Reward> rewards;

    public RewardRepository() {
        rewards = new ArrayList<>();
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

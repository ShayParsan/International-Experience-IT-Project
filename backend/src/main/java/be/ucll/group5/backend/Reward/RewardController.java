package backEnd.src.main.Reward;

import java.util.List;

public class RewardController {
    private RewardService rewardService;

    public RewardController() {
        rewardService = new RewardService();
    }

    public void addReward(Reward reward) {
        rewardService.addReward(reward);
    }

    public void removeReward(Reward reward) {
        rewardService.removeReward(reward);
    }

    public List<Reward> getRewards() {
        return rewardService.getRewards();
    }
}

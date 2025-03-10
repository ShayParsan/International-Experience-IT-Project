package be.ucll.group5.backend.Reward;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private RewardRepository rewardRepository;

    public RewardService() {
        rewardRepository = new RewardRepository();
    }

    public void addReward(Reward reward) {
        rewardRepository.addReward(reward);
    }

    public void removeReward(Reward reward) {
        rewardRepository.removeReward(reward);
    }

    public List<Reward> getRewards() {
        return rewardRepository.getRewards();
    }
}

package be.ucll.group5.backend.Reward;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public Reward addReward(Reward reward) {
        rewardRepository.save(reward);
        return reward;
    }

    public void removeReward(Long id) {
        rewardRepository.deleteById(id);
    }

    public List<Reward> getRewards() {
        return rewardRepository.findAll();
    }
}
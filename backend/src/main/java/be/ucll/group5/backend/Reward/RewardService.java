package be.ucll.group5.backend.Reward;

import be.ucll.group5.backend.User.User;
import be.ucll.group5.backend.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;
    private final UserRepository userRepository;

    public RewardService(RewardRepository rewardRepository, UserRepository userRepository) {
        this.rewardRepository = rewardRepository;
        this.userRepository = userRepository;
    }

    public Reward addReward(RewardInput rewardInput) {
        Reward reward = new Reward(rewardInput.name(), rewardInput.description(), rewardInput.date(), rewardInput.rank());
        return rewardRepository.save(reward);
    }

    public void removeReward(Long id) {
        rewardRepository.deleteById(id);
    }

    public List<Reward> getRewards() {
        return rewardRepository.findAll();
    }

    public Reward assignRewardToUser(int userId, Reward reward) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        reward.setUser(user);
        return rewardRepository.save(reward);
    }
}

package be.ucll.group5.backend.Reward;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    public RewardController() {
        rewardService = new RewardService();
    }

    @GetMapping
    public List<Reward> getRewards() {
        return rewardService.getRewards();
    }

    @PostMapping
    public void addReward(Reward reward) {
        rewardService.addReward(reward);
    }

    @DeleteMapping
    public void removeReward(Reward reward) {
        rewardService.removeReward(reward);
    }
}

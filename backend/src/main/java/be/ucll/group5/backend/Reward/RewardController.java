package be.ucll.group5.backend.Reward;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<Reward> getRewards() {
        return rewardService.getRewards();
    }

    @PostMapping
    public Reward addReward(@RequestBody Reward reward) {
        return rewardService.addReward(reward);
    }

    @DeleteMapping("/{id}")
    public void removeReward(@PathVariable Long id) {
        rewardService.removeReward(id);
    }
}
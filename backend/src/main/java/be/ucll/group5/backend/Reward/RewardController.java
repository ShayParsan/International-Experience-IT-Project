package be.ucll.group5.backend.Reward;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reward Management", description = "APIs for managing rewards")
@RestController
@RequestMapping("/rewards")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    public RewardController() {
        rewardService = new RewardService();
    }

    @Operation(summary = "Get all rewards", description = "Returns a list of all rewards in the system")
    @GetMapping
    public List<Reward> getRewards() {
        return rewardService.getRewards();
    }

    @Operation(summary = "Add a new reward", description = "Creates a new reward")
    @PostMapping
    public void addReward(@RequestBody Reward reward) {
        rewardService.addReward(reward);
    }

    @Operation(summary = "Remove a reward", description = "Removes an existing reward")
    @DeleteMapping
    public void removeReward(@RequestBody Reward reward) {
        rewardService.removeReward(reward);
    }
}

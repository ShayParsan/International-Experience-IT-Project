package be.ucll.group5.backend.Reward;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reward Management", description = "APIs for managing rewards")
@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @Operation(summary = "Get all rewards", description = "Retrieves a list of all rewards")
    @GetMapping
    public List<Reward> getRewards() {
        return rewardService.getRewards();
    }

    @Operation(summary = "Add a new reward", description = "Creates a new reward and saves it to the database")
    @PostMapping
    public Reward addReward(@RequestBody RewardInput rewardInput) {
        return rewardService.addReward(rewardInput);
    }

    @Operation(summary = "Delete a reward", description = "Removes a reward by its ID")
    @DeleteMapping("/{id}")
    public void removeReward(@PathVariable Long id) {
        rewardService.removeReward(id);
    }

    @Operation(summary = "Assign reward to user", description = "Assigns a reward to a specific user")
    @PostMapping("/assign/{userId}")
    public Reward assignToUser(@PathVariable int userId, @RequestBody Reward reward) {
        return rewardService.assignRewardToUser(userId, reward);
    }
}

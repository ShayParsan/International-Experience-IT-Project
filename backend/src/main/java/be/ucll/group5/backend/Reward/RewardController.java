package be.ucll.group5.backend.Reward;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/rewards")
@Api(value = "Reward Management System", description = "Operations pertaining to rewards in Reward Management System")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    public RewardController() {
        rewardService = new RewardService();
    }

    @ApiOperation(value = "View a list of available rewards", response = List.class)
    @GetMapping
    public List<Reward> getRewards() {
        return rewardService.getRewards();
    }

    @ApiOperation(value = "Add a reward")
    @PostMapping
    public void addReward(
            @ApiParam(value = "Reward object to be added", required = true) @RequestBody Reward reward) {
        rewardService.addReward(reward);
    }

    @ApiOperation(value = "Remove a reward")
    @DeleteMapping
    public void removeReward(
            @ApiParam(value = "Reward object to be removed", required = true) @RequestBody Reward reward) {
        rewardService.removeReward(reward);
    }
}

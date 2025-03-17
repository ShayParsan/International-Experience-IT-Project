package be.ucll.group5.backend.Reward;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RewardDataInitializer implements CommandLineRunner {

    private final RewardRepository rewardRepository;

    public RewardDataInitializer(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @Override
    public void run(String... args) {
        if (rewardRepository.count() == 0) { // Only insert if empty
            List<Reward> rewards = List.of(
                    new Reward("Gold Medal", "Awarded for first place", LocalDate.now(), Rank.GOLD),
                    new Reward("Silver Medal", "Awarded for second place", LocalDate.now(), Rank.SILVER),
                    new Reward("Bronze Medal", "Awarded for third place", LocalDate.now(), Rank.BRONZE),
                    new Reward("Platinum Medal", "Awarded for special achievement", LocalDate.now(), Rank.PLATINUM)
            );
            rewardRepository.saveAll(rewards);
        }
    }
}
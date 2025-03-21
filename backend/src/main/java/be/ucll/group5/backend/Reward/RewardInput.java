package be.ucll.group5.backend.Reward;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record RewardInput(
        @NotBlank String name,
        String description,
        @NotBlank LocalDate date,
        @NotBlank Rank rank) {

}

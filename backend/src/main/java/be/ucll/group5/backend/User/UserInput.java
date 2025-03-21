package be.ucll.group5.backend.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserInput(
        @NotBlank String username,
        @NotBlank String password,
        @Email String email,
        @NotBlank String firstName,
        @NotBlank String lastName) {
}

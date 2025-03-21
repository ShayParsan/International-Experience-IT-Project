package be.ucll.group5.backend.Collection;

import jakarta.validation.constraints.NotBlank;

public record CollectionInput(
        @NotBlank String name,
        String address,
        String number) {
}

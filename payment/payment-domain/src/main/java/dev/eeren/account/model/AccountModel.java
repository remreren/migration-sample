package dev.eeren.account.model;

public record AccountModel(
        Long id,
        String name,
        String surname,
        String username,
        String email
) {
}

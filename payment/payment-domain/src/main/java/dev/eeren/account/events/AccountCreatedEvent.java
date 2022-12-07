package dev.eeren.account.events;

import dev.eeren.account.model.AccountModel;

public record AccountCreatedEvent(AccountModel account) {
}

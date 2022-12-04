package dev.eeren.account.usecase;

import dev.eeren.account.model.AccountModel;
import dev.eeren.utility.common.model.UseCase;

public record CreateAccountUseCase(AccountModel account) implements UseCase {
}

package dev.eeren.balance.usecase;

import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.utility.common.model.UseCase;

public record UpdateBalanceUseCase(TransactionModel transaction) implements UseCase {

}

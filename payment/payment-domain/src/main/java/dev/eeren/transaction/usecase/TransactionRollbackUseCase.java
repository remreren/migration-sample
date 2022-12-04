package dev.eeren.transaction.usecase;

import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.utility.common.model.UseCase;

public record TransactionRollbackUseCase(TransactionModel transaction) implements UseCase {
}

package dev.eeren.transaction.events;

import dev.eeren.transaction.model.TransactionModel;

public record RollbackTransactionEvent(TransactionModel transaction) {
}

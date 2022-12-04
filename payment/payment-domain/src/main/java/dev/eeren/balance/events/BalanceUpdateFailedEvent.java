package dev.eeren.balance.events;

import dev.eeren.transaction.model.TransactionModel;

public record BalanceUpdateFailedEvent(TransactionModel transaction) {
}

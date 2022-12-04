package dev.eeren.balance.port;

import dev.eeren.transaction.model.TransactionModel;

public interface BalanceEventPort {

    void balanceUpdated(TransactionModel transaction);

    void balanceUpdateFailed(TransactionModel transaction);

}

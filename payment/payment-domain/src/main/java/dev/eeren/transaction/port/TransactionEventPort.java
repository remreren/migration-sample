package dev.eeren.transaction.port;

import dev.eeren.transaction.model.TransactionModel;

public interface TransactionEventPort {

    void transactionCreated(TransactionModel transaction);

    void transactionRolledBack(TransactionModel transaction);

}

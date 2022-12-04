package dev.eeren.transaction.port;

import dev.eeren.transaction.model.TransactionModel;

import java.util.List;
import java.util.Optional;

public interface TransactionPort {

    Optional<TransactionModel> getTransaction(Long transactionId);

    TransactionModel createTransaction(TransactionModel transaction);

    List<TransactionModel> getTransactionsByUserId(Long userId);

    void deleteTransaction(Long transactionId);

}

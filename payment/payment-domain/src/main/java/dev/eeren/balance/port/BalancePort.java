package dev.eeren.balance.port;

import dev.eeren.balance.model.BalanceModel;
import dev.eeren.transaction.model.TransactionModel;

import java.util.Optional;

public interface BalancePort {

    Optional<BalanceModel> getUserBalance(Long userId);

    BalanceModel createBalance(BalanceModel balanceModel);

    void updateBalance(TransactionModel transaction);

}

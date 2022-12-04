package dev.eeren.transaction.usecase;

import dev.eeren.balance.exception.UserNotFoundException;
import dev.eeren.balance.port.BalancePort;
import dev.eeren.transaction.enums.TransactionType;
import dev.eeren.transaction.exception.InsufficientBalanceException;
import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.port.TransactionEventPort;
import dev.eeren.transaction.port.TransactionPort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@DomainComponent
@RequiredArgsConstructor
public class CreatePaymentUseCaseHandler implements UseCaseHandler<TransactionModel, CreatePaymentUseCase> {

    private final BalancePort balancePort;

    private final TransactionPort transactionPort;

    private final TransactionEventPort transactionEventPort;

    @Override
    public TransactionModel handle(CreatePaymentUseCase payment) {

        var userBalance = balancePort.getUserBalance(payment.userId())
                                     .orElseThrow(() -> new UserNotFoundException(payment.userId()));

        if (isNegative(userBalance.total().add(payment.amount().negate()))) {

            throw new InsufficientBalanceException(payment.userId());

        }

        var transaction = transactionPort.createTransaction(new TransactionModel(null, payment.userId(), TransactionType.PAYMENT, payment.amount(), null));

        transactionEventPort.transactionCreated(transaction);

        return transaction;

    }

    private boolean isNegative(BigDecimal value) {

        return value.compareTo(BigDecimal.ZERO) < 0;

    }
}

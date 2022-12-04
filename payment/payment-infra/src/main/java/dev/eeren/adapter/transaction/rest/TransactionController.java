package dev.eeren.adapter.transaction.rest;

import dev.eeren.adapter.transaction.dto.CreateTransactionRequest;
import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.usecase.CreateDebtUseCase;
import dev.eeren.transaction.usecase.CreatePaymentUseCase;
import dev.eeren.transaction.usecase.GetTransactionByIdUseCase;
import dev.eeren.transaction.usecase.GetTransactionByUserUseCase;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final UseCaseHandler<TransactionModel, GetTransactionByIdUseCase> getTransactionByIdUseCaseHandler;

    private final UseCaseHandler<List<TransactionModel>, GetTransactionByUserUseCase> getTransactionsByUserUseCaseHandler;

    private final UseCaseHandler<TransactionModel, CreatePaymentUseCase> createPaymentUseCaseHandler;

    private final UseCaseHandler<TransactionModel, CreateDebtUseCase> createDebtUseCaseHandler;

    @GetMapping("/{id}")
    public ResponseEntity<TransactionModel> getTransactionById(@PathVariable("id") Long transactionId) {

        var transaction = getTransactionByIdUseCaseHandler.handle(new GetTransactionByIdUseCase(transactionId));

        return ResponseEntity.ok(transaction);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TransactionModel>> getTransactionsByUser(@PathVariable("id") Long userId) {

        var transactions = getTransactionsByUserUseCaseHandler.handle(new GetTransactionByUserUseCase(userId));

        return ResponseEntity.ok(transactions);

    }

    @PostMapping("/payment")
    public ResponseEntity<TransactionModel> createPayment(@RequestBody CreateTransactionRequest createTransaction) {

        var created = createPaymentUseCaseHandler.handle(new CreatePaymentUseCase(createTransaction.userId(), createTransaction.amount()));

        return ResponseEntity.ok(created);

    }

    @PostMapping("/debt")
    public ResponseEntity<TransactionModel> createDebt(@RequestBody CreateTransactionRequest createTransaction) {

        var created = createDebtUseCaseHandler.handle(new CreateDebtUseCase(createTransaction.userId(), createTransaction.amount()));

        return ResponseEntity.ok(created);

    }

}

package dev.eeren.adapter.transaction;

import dev.eeren.adapter.transaction.mapper.TransactionMapper;
import dev.eeren.adapter.transaction.repository.TransactionRepository;
import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.port.TransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionAdapter implements TransactionPort {

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    @Override
    public Optional<TransactionModel> getTransaction(Long transactionId) {

        return transactionRepository.findById(transactionId).map(transactionMapper::toModel);

    }

    @Override
    public TransactionModel createTransaction(TransactionModel transaction) {

        var created = transactionRepository.save(transactionMapper.toEntity(transaction));

        return transactionMapper.toModel(created);

    }

    @Override
    public List<TransactionModel> getTransactionsByUserId(Long userId) {

        return transactionRepository.findAllByUserId(userId).stream()
                                    .map(transactionMapper::toModel)
                                    .toList();

    }

    @Override
    public void deleteTransaction(Long transactionId) {

        transactionRepository.deleteById(transactionId);

    }
}

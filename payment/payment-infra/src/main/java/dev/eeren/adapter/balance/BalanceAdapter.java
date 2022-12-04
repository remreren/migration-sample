package dev.eeren.adapter.balance;

import dev.eeren.adapter.balance.repository.BalanceRepository;
import dev.eeren.balance.model.BalanceModel;
import dev.eeren.balance.port.BalancePort;
import dev.eeren.adapter.balance.mapper.BalanceMapper;
import dev.eeren.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceAdapter implements BalancePort {

    private final BalanceRepository balanceRepository;

    private final BalanceMapper balanceMapper;

    @Override
    public Optional<BalanceModel> getUserBalance(Long userId) {

        return balanceRepository.getBalanceEntityByUserId(userId).map(balanceMapper::toModel);

    }

    @Override
    public BalanceModel createBalance(BalanceModel balanceModel) {

        var created = balanceRepository.save(balanceMapper.toEntity(balanceModel));

        return balanceMapper.toModel(created);

    }

    @Override
    public void updateBalance(TransactionModel transaction) {

        balanceRepository.updateBalance(transaction.userId(), transaction.amount());

    }

}

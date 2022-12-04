package dev.eeren.adapter.account;

import dev.eeren.account.model.AccountModel;
import dev.eeren.account.port.AccountPort;
import dev.eeren.adapter.account.mapper.AccountMapper;
import dev.eeren.adapter.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountPort {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    public Optional<AccountModel> getAccountById(Long accountId) {

        return accountRepository.findById(accountId).map(accountMapper::toModel);

    }

    @Override
    public AccountModel createAccount(AccountModel account) {

        var created = accountRepository.save(accountMapper.toEntity(account));

        return accountMapper.toModel(created);

    }

}

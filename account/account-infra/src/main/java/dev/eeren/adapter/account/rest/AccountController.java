package dev.eeren.adapter.account.rest;

import dev.eeren.account.model.AccountModel;
import dev.eeren.account.usecase.GetAccountByIdUseCase;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final UseCaseHandler<AccountModel, GetAccountByIdUseCase> getAccountByIdUseCaseHandler;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountModel> getAccountById(@PathVariable("accountId") Long accountId) {

        var account = getAccountByIdUseCaseHandler.handle(new GetAccountByIdUseCase(accountId));

        return ResponseEntity.ok(account);

    }

}

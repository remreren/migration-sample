package dev.eeren.adapter.balance.rest;

import dev.eeren.balance.model.BalanceModel;
import dev.eeren.balance.usecase.CreateBalanceUseCase;
import dev.eeren.balance.usecase.GetBalanceUseCase;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/balance")
public class BalanceController {

    private final UseCaseHandler<BalanceModel, GetBalanceUseCase> getBalanceUseCaseHandler;

    private final UseCaseHandler<BalanceModel, CreateBalanceUseCase> createBalanceUseCaseHandler;

    @GetMapping("/user/{id}")
    public ResponseEntity<BalanceModel> getUserBalance(@PathVariable("id") Long id) {

        var balance = getBalanceUseCaseHandler.handle(new GetBalanceUseCase(id));

        return ResponseEntity.ok(balance);

    }

    @PostMapping("/user/{id}")
    public ResponseEntity<BalanceModel> createUserBalance(@PathVariable("id") Long id) {

        var balance = createBalanceUseCaseHandler.handle(new CreateBalanceUseCase(id));

        return ResponseEntity.ok(balance);

    }

}

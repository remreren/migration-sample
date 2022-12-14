package dev.eeren.adapter.balance.listener;

import dev.eeren.account.events.AccountCreatedEvent;
import dev.eeren.balance.model.BalanceModel;
import dev.eeren.balance.usecase.CreateBalanceUseCase;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountEventListener {

    private final UseCaseHandler<BalanceModel, CreateBalanceUseCase> createBalanceUseCaseHandler;

    @Bean
    public Queue accountCreated() {

        return new Queue("account.created");

    }

    @RabbitListener(queues = "account.created", id = "create.balance")
    public void createBalanceListener(AccountCreatedEvent accountCreated) {

        createBalanceUseCaseHandler.handle(new CreateBalanceUseCase(accountCreated.account().id()));

    }

}

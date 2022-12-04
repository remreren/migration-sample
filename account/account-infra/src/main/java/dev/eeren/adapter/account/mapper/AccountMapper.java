package dev.eeren.adapter.account.mapper;

import dev.eeren.account.model.AccountModel;
import dev.eeren.adapter.account.model.AccountEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {

    AccountModel toModel(AccountEntity accountEntity);

    AccountEntity toEntity(AccountModel accountModel);

}

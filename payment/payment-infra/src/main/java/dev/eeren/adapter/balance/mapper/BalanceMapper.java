package dev.eeren.adapter.balance.mapper;

import dev.eeren.adapter.balance.model.BalanceEntity;
import dev.eeren.balance.model.BalanceModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BalanceMapper {

    BalanceModel toModel(BalanceEntity balanceEntity);

    BalanceEntity toEntity(BalanceModel balanceModel);

}

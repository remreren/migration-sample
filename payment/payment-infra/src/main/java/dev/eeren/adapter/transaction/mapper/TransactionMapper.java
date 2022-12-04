package dev.eeren.adapter.transaction.mapper;

import dev.eeren.adapter.transaction.model.TransactionEntity;
import dev.eeren.transaction.model.TransactionModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TransactionMapper {

    TransactionModel toModel(TransactionEntity transactionEntity);

    TransactionEntity toEntity(TransactionModel transactionModel);

}

package dev.eeren.adapter.transaction.repository;

import dev.eeren.adapter.transaction.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findAllByUserId(Long userId);
}

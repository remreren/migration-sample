package dev.eeren.adapter.balance.repository;

import dev.eeren.adapter.balance.model.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {

    Optional<BalanceEntity> getBalanceEntityByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("update balance b set b.total = b.total + :amount where b.userId = :userId")
    void updateBalance(Long userId, BigDecimal amount);

}

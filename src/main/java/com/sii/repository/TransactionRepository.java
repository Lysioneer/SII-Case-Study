package com.sii.repository;

import com.sii.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link TransactionEntity}
 *
 * Created by Simek Jan on 20.9.2023.
 */
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}

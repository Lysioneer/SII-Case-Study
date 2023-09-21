package com.sii.repository;

import com.sii.model.entity.TransactionDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link TransactionDataEntity}
 *
 * Created by Simek Jan on 21.9.2023.
 */
@Repository
public interface TransactionDataRepository extends JpaRepository<TransactionDataEntity, Integer> {
}

package com.sii.service;

import com.sii.model.request.SaveRecordRequest;
import com.sii.repository.TransactionRepository;
import com.sii.rest.TransactionController;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service layer for {@link TransactionController}
 *
 * Created by Simek Jan on 20.9.2023.
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final EntityMapper mapper;

    @Override
    @Transactional
    public void saveRecord(SaveRecordRequest request) {

        repository.save(mapper.map(request));
    }
}

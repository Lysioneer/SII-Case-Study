package com.sii.service;

import com.sii.model.request.SaveRecordRequest;

/**
 * Service interface for {@link TransactionServiceImpl}
 *
 * Created by Simek Jan on 20.9.2023.
 */
public interface TransactionService {

    void saveRecord(SaveRecordRequest request);

}

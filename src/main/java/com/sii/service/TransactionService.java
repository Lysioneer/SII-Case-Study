package com.sii.service;

import com.sii.model.request.SaveRecordRequest;
import com.sii.model.response.RetrieveRecordResponse;

/**
 * Service interface for {@link TransactionServiceImpl}
 *
 * Created by Simek Jan on 20.9.2023.
 */
public interface TransactionService {

    void saveRecord(SaveRecordRequest request);

    RetrieveRecordResponse retrieveRecord(Integer id);

}

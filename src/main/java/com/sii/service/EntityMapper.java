package com.sii.service;

import com.sii.model.entity.TransactionDataEntity;
import com.sii.model.entity.TransactionEntity;
import com.sii.model.request.SaveRecordRequest;
import com.sii.model.response.RetrieveRecordResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Mapper class for mapping request/response to/from database entity.
 *
 * Created by Simek Jan on 21.9.2023.
 */
@Service
public class EntityMapper {

    public TransactionEntity map(SaveRecordRequest request) {
        TransactionEntity entity = new TransactionEntity();
        entity.setTimeStamp(request.getTimeStamp());
        entity.setType(request.getType());
        entity.setActor(request.getActor());
        entity.setTransactionData(new ArrayList<>());

        for (String key : request.getTransactionData().keySet()) {
            TransactionDataEntity dataEntity = new TransactionDataEntity();
            dataEntity.setTransactionKey(key);
            dataEntity.setTransactionValue(request.getTransactionData().get(key));
            dataEntity.setTransaction(entity);
            entity.getTransactionData().add(dataEntity);
        }

        return entity;
    }

    public RetrieveRecordResponse map(TransactionEntity entity) {
        RetrieveRecordResponse response = new RetrieveRecordResponse();
        response.setTimeStamp(entity.getTimeStamp());
        response.setType(entity.getType());
        response.setActor(entity.getActor());
        response.setTransactionData(new HashMap<String, String>());

        for (var item : entity.getTransactionData()) {
            response.getTransactionData().put(item.getTransactionKey(), item.getTransactionValue());
        }

        return response;
    }

}

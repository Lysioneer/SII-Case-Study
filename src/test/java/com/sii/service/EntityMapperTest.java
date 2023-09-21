package com.sii.service;

import com.sii.model.entity.TransactionDataEntity;
import com.sii.model.entity.TransactionEntity;
import com.sii.model.request.SaveRecordRequest;
import com.sii.model.response.RetrieveRecordResponse;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Spy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

/**
 * Service class for {@link EntityMapper}
 *
 * Created by Simek Jan on 21.9.2023.
 */
public class EntityMapperTest {

    @Spy
    private EntityMapper mapper = new EntityMapper();

    @Test
    public void mapRequestToEntityTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        TransactionEntity entity = mapper.map(mockSaveRecordRequest());

        Assert.assertEquals(LocalDate.parse("2023-09-21", formatter), entity.getTimeStamp());
        Assert.assertEquals("type", entity.getType());
        Assert.assertEquals("actor", entity.getActor());
        Assert.assertEquals("key1", entity.getTransactionData().get(0).getTransactionKey());
        Assert.assertEquals("value2", entity.getTransactionData().get(1).getTransactionValue());
        Assert.assertEquals("key3", entity.getTransactionData().get(2).getTransactionKey());
    }

    @Test
    public void mapEntityToResponseTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        RetrieveRecordResponse response = mapper.map(mockTransactionEntity());

        Assert.assertEquals(LocalDate.parse("2023-09-21", formatter), response.getTimeStamp());
        Assert.assertEquals("type", response.getType());
        Assert.assertEquals("actor", response.getActor());
        Assert.assertEquals("value1", response.getTransactionData().get("key1"));
        Assert.assertEquals("value2", response.getTransactionData().get("key2"));
        Assert.assertEquals("value3", response.getTransactionData().get("key3"));
    }

    private SaveRecordRequest mockSaveRecordRequest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        SaveRecordRequest request = new SaveRecordRequest();
        request.setTimeStamp(LocalDate.parse("2023-09-21", formatter));
        request.setType("type");
        request.setActor("actor");

        HashMap<String, String> transactionData = new HashMap<>();
        transactionData.put("key1", "value1");
        transactionData.put("key2", "value2");
        transactionData.put("key3", "value3");

        request.setTransactionData(transactionData);

        return request;
    }

    private TransactionEntity mockTransactionEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        TransactionEntity entity = new TransactionEntity();
        entity.setTimeStamp(LocalDate.parse("2023-09-21", formatter));
        entity.setType("type");
        entity.setActor("actor");

        TransactionDataEntity transactionData1 = new TransactionDataEntity();
        transactionData1.setTransactionKey("key1");
        transactionData1.setTransactionValue("value1");
        transactionData1.setTransaction(entity);
        TransactionDataEntity transactionData2 = new TransactionDataEntity();
        transactionData2.setTransactionKey("key2");
        transactionData2.setTransactionValue("value2");
        transactionData2.setTransaction(entity);
        TransactionDataEntity transactionData3 = new TransactionDataEntity();
        transactionData3.setTransactionKey("key3");
        transactionData3.setTransactionValue("value3");
        transactionData3.setTransaction(entity);

        entity.setTransactionData(List.of(transactionData1, transactionData2, transactionData3));

        return entity;
    }

}

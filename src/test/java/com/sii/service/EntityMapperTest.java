package com.sii.service;

import com.sii.model.entity.TransactionEntity;
import com.sii.model.request.SaveRecordRequest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Spy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

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

}

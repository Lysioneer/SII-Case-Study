package com.sii.service;

import com.sii.exception.RecordNotFoundException;
import com.sii.model.entity.TransactionDataEntity;
import com.sii.model.entity.TransactionEntity;
import com.sii.model.response.RetrieveRecordResponse;
import com.sii.repository.TransactionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Test class for {@link TransactionServiceImpl}
 *
 * Created by Simek Jan on 21.9.2023.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceImplTest {

    @Mock
    private TransactionRepository repository;

    @Spy
    private EntityMapper mapper = new EntityMapper();

    @InjectMocks
    private TransactionServiceImpl service;

    @Before
    public void init() {
        ReflectionTestUtils.setField(service, "mapper", mapper);
        ReflectionTestUtils.setField(service, "repository", repository);
    }

    @Test
    public void retrieveRecordTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(mockTransactionEntity()));

        RetrieveRecordResponse response = service.retrieveRecord(3);

        Assert.assertEquals(LocalDate.parse("2023-09-21", formatter), response.getTimeStamp());
        Assert.assertEquals("type", response.getType());
        Assert.assertEquals("actor", response.getActor());
        Assert.assertEquals("value1", response.getTransactionData().get("key1"));
        Assert.assertEquals("value2", response.getTransactionData().get("key2"));
        Assert.assertEquals("value3", response.getTransactionData().get("key3"));
    }

    @Test(expected = RecordNotFoundException.class)
    public void retrieveRecordNotFoundException() {

        Mockito.when(repository.findById(3)).thenReturn(Optional.of(new TransactionEntity()));

        service.retrieveRecord(3);
    }

    private TransactionEntity mockTransactionEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        TransactionEntity entity = new TransactionEntity();
        entity.setTimeStamp(LocalDate.parse("2023-09-21", formatter));
        entity.setType("type");
        entity.setActor("actor");
        entity.setId(3);

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
